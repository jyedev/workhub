package com.work.workhub.member.message.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.work.workhub.member.member.dto.DepartmentDTO;
import com.work.workhub.member.member.dto.MemberDTO;
import com.work.workhub.member.message.model.dto.MessageDTO;

@Mapper
public interface MessageMapper {
	
	List<MessageDTO> findMessageInbox();

	List<MessageDTO> findMessageSent();

	List<MessageDTO> findMessageRecyclebinList();

	int sendMessage(MessageDTO message);

	List<DepartmentDTO> selectDepartmentList();

	List<MemberDTO> selectMemberList();

}
