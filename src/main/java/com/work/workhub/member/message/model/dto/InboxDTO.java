package com.work.workhub.member.message.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InboxDTO {
	
	private int msgCode;			//쪽지번호 
	private int senderNo;			//발신자사번 
	private int reicipientNo;		//수신자사번 
	private String msgContent;		//쪽지내용 
	private String sendDate;		//발신날짜 
	private String sendTime;		//발신시간 
	private String readDate;		//읽은날짜 
	private String readTime;		//읽은시간 
	private String recycleBinStatus;//휴지통여부 
	private String deleteStatus;	//삭제여부 

}
