package com.work.workhub.member.message.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.work.workhub.member.message.model.dto.InboxDTO;

@Mapper
public interface InboxMapper {
	
	List<InboxDTO> findMessageInbox();

}
