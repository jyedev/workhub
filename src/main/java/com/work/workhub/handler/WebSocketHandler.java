package com.work.workhub.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class WebSocketHandler extends TextWebSocketHandler {
	
	private Map<String, WebSocketSession> userSessionsMap = new ConcurrentHashMap<String, WebSocketSession>();

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {  //클라이언트와 서버 
		
		log.info("Socket 연결");
		log.info(currentUserName(session)); // 현재 접속한 사원 
		userSessionsMap.put(currentUserName(session), session);
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception { // 메시지 
		
		String msg = message.getPayload();
		
		if(msg != null) {
			String[] msgs = msg.split(",");
			log.info(msgs.toString());
			if(msgs != null && msgs.length == 2) {  // alarm 테이블 생성해서 추가하기 
				String sender = msgs[0];
				String url = msgs[1];
				log.info(sender);
				log.info(url);

				WebSocketSession sendersession = userSessionsMap.get(sender);
				
				if(sendersession != null) {
					TextMessage txtmsg = new TextMessage("<a href='"+ url +"'>" + sender + "로부터 새로운 쪽지가 도착했습니다.</a>");
					sendersession.sendMessage(txtmsg);
				}
			}
		}
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		
		log.info("Socket 끊음");
		userSessionsMap.remove(currentUserName(session), session);
	}
	
	
	private String currentUserName(WebSocketSession session) {
		String mid = session.getPrincipal().getName();
		return mid;
	}
	
	

}
