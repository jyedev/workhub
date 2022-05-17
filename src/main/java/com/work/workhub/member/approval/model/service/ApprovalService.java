package com.work.workhub.member.approval.model.service;

import java.util.List;

import com.work.workhub.member.approval.model.dto.ApprovalDTO;
import com.work.workhub.member.member.dto.DepartmentDTO;
import com.work.workhub.member.member.dto.MemberDTO;

public interface ApprovalService {

	List<ApprovalDTO> selectReceptionList(int no);

	List<ApprovalDTO> selectSendList(int no);

	List<DepartmentDTO> selectDepartmentList();

	List<MemberDTO> selectMemberList();

	void registApproval(ApprovalDTO approval);

	ApprovalDTO findAppByNo(Integer approvalNo);

}
