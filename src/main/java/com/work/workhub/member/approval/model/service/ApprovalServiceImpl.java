package com.work.workhub.member.approval.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.work.workhub.member.approval.model.dao.ApprovalMapper;
import com.work.workhub.member.approval.model.dto.ApprovalDTO;
import com.work.workhub.member.member.dto.DepartmentDTO;
import com.work.workhub.member.member.dto.MemberDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("approvalService")
public class ApprovalServiceImpl implements ApprovalService {

	private final ApprovalMapper approvalMapper;
	
	@Autowired
	public ApprovalServiceImpl(ApprovalMapper approvalMapper) {
		this.approvalMapper = approvalMapper;
	}

	@Override
	public List<ApprovalDTO> selectReceptionList() {
		
		return approvalMapper.selectReceptionList();
	}

	@Override
	public List<ApprovalDTO> selectSendList() {
		
		return approvalMapper.selectSendList();
	}

	@Override
	public List<DepartmentDTO> selectDepartmentList() {
		return approvalMapper.selectDepartmentList();
	}

	@Override
	public List<MemberDTO> selectMemberList() {
		return approvalMapper.selectMemberList();
	}

}
