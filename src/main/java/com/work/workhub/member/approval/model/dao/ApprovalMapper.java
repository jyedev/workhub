package com.work.workhub.member.approval.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.work.workhub.member.approval.model.dto.AppLineDTO;
import com.work.workhub.member.approval.model.dto.ApprovalDTO;
import com.work.workhub.member.approval.model.dto.ReferenceDTO;
import com.work.workhub.member.member.dto.DepartmentDTO;
import com.work.workhub.member.member.dto.MemberDTO;

@Mapper
public interface ApprovalMapper {

	List<ApprovalDTO> selectSendList(int no);

//	List<ApprovalDTO> selectReceptionList(int receiverNo, int refNo);
	List<ApprovalDTO> selectReceptionList(int no);

	List<DepartmentDTO> selectDepartmentList();

	List<MemberDTO> selectMemberList();
	
	void insertApproval(ApprovalDTO approval);

	ApprovalDTO findAppByNo(Integer approvalNo);

	List<AppLineDTO> findReceiverByNo(Integer approvalNo);

	List<ReferenceDTO> findRefByNo(Integer approvalNo);

	void modifyRet(Integer no);

	void deleteApp(int no);

	void insertReceiver(ApprovalDTO approval, int receiverNo);

	void insertRef(ApprovalDTO approval, int refNo);


}
