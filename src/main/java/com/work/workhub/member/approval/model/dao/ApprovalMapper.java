package com.work.workhub.member.approval.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.work.workhub.member.approval.model.dto.ApprovalDTO;

@Mapper
public interface ApprovalMapper {

	List<ApprovalDTO> selectReceptionList();

}
