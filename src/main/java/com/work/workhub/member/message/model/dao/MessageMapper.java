package com.work.workhub.member.message.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.work.workhub.member.member.dto.DepartmentDTO;
import com.work.workhub.member.member.dto.MemberDTO;
import com.work.workhub.member.message.model.dto.MessageDTO;

@Mapper
public interface MessageMapper {
	
	List<MessageDTO> findMessageInbox(int no);

	List<MessageDTO> findMessageSent(int no);

	List<MessageDTO> findMessageRecyclebinList();

	void sendMessage(MessageDTO message);

	List<DepartmentDTO> selectDepartmentList();

	List<MemberDTO> selectMemberList();

	void deleteMessage(String code);

	void updateMessageForView(int msgCode);


}
