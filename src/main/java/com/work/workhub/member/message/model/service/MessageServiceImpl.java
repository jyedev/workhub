package com.work.workhub.member.message.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.work.workhub.member.message.model.dao.MessageMapper;
import com.work.workhub.member.message.model.dto.MessageDTO;

@Service("listService")
@Transactional
public class MessageServiceImpl implements MessageService {
	
	private final MessageMapper messageMapper;
	
	@Autowired
	public MessageServiceImpl(MessageMapper messageMapper) {
		this.messageMapper = messageMapper;
	}

	/* 쪽지 - 받은 쪽지함 조회 */
	@Override
	public List<MessageDTO> findMessageInbox() {
		return messageMapper.findMessageInbox();
	}

	/* 쪽지 - 보낸 쪽지함 조회 */
	@Override
	public List<MessageDTO> findMessageSent() {
		return messageMapper.findMessageSent();
	}

	/* 쪽지 - 휴지통 조회 */
	@Override
	public List<MessageDTO> findMessageRecyclebinList() {
		return messageMapper.findMessageRecyclebinList();
	}

	/* 쪽지 - 새 쪽지 보내기 */
	@Override
	public boolean sendMessage(MessageDTO message) throws Exception {
		
		int result = messageMapper.sendMessage(message);
		
		if(result <= 0) {
			throw new Exception("쪽지 전송에 실패하였습니다. 다시 시도해주세요.");
		}
		
		return result > 0 ? true : false;
		
	}

}
