package com.work.workhub.member.message.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.work.workhub.member.message.model.dao.InboxMapper;
import com.work.workhub.member.message.model.dto.InboxDTO;

@Service("inboxService")
@Transactional
public class InboxServiceImpl implements InboxService {
	
	private final InboxMapper inboxMapper;
	
	@Autowired
	public InboxServiceImpl(InboxMapper inboxMapper) {
		this.inboxMapper = inboxMapper;
	}

	@Override
	public List<InboxDTO> findMessageInbox() {
		return inboxMapper.findMessageInbox();
	}

}
