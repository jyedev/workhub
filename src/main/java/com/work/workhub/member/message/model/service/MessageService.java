package com.work.workhub.member.message.model.service;

import java.util.List;

import com.work.workhub.member.member.dto.DepartmentDTO;
import com.work.workhub.member.member.dto.MemberDTO;
import com.work.workhub.member.message.model.dto.MessageDTO;

public interface MessageService {
	
	List<MessageDTO> findMessageInbox();

	List<MessageDTO> findMessageSent();

	List<MessageDTO> findMessageRecyclebinList();

	boolean sendMessage(MessageDTO message) throws Exception;

	List<DepartmentDTO> selectDepartmentList();

	List<MemberDTO> selectMemberList();

}
