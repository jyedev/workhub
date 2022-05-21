package com.work.workhub.member.approval.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.work.workhub.member.approval.model.dao.ApprovalMapper;
import com.work.workhub.member.approval.model.dto.AppLineDTO;
import com.work.workhub.member.approval.model.dto.ApprovalDTO;
import com.work.workhub.member.approval.model.dto.ReferenceDTO;
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

//	@Override
//	public List<ApprovalDTO> selectReceptionList(int receiverNo, int refNo) {
//		
//		return approvalMapper.selectReceptionList(receiverNo, refNo);
//	}
	
	@Override
	public List<ApprovalDTO> selectReceptionList(int no) {
		
		return approvalMapper.selectReceptionList(no);
	}

	@Override
	public List<ApprovalDTO> selectSendList(int no) {
		
		return approvalMapper.selectSendList(no);
	}

	@Override
	public List<DepartmentDTO> selectDepartmentList() {
		return approvalMapper.selectDepartmentList();
	}

	@Override
	public List<MemberDTO> selectMemberList() {
		return approvalMapper.selectMemberList();
	}

	@Override
	public void registApproval(ApprovalDTO approval) {
		
		approvalMapper.insertApproval(approval);
		
		AppLineDTO appLine = new AppLineDTO();
//		appLine.setAppNo(0);
		
//		approvalMapper.insertAppLine(appLine);
		
	}

	@Override
	public ApprovalDTO findAppByNo(Integer approvalNo) {
		
		return approvalMapper.findAppByNo(approvalNo);
	}

	@Override
	public List<AppLineDTO> findReceiverByNo(Integer approvalNo) {
		
		return approvalMapper.findReceiverByNo(approvalNo);
	}

	@Override
	public List<ReferenceDTO> findRefByNo(Integer approvalNo) {
		
		return approvalMapper.findRefByNo(approvalNo);
	}

	@Override
	public void modifyRet(Integer no) {
		
		approvalMapper.modifyRet(no);
	}

	@Override
	public void deleteApp(int no) {

		approvalMapper.deleteApp(no);
	}

	@Override
	public void insertReceiver(ApprovalDTO approval, int receiverNo) {
		
		approvalMapper.insertReceiver(approval, receiverNo);
	}

	@Override
	public void insertRef(ApprovalDTO approval, int refNo) {

		approvalMapper.insertRef(approval, refNo);
	}


}
