package com.work.workhub.member.message.model.service;

import java.util.List;

import com.work.workhub.member.message.model.dto.InboxDTO;

public interface InboxService {
	
	List<InboxDTO> findMessageInbox();

	

}
