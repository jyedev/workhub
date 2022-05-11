package com.work.workhub.member.approval.model.service;

import java.util.List;

import com.work.workhub.member.approval.model.dto.ApprovalDTO;

public interface ApprovalService {

	List<ApprovalDTO> selectReceptionList();

	List<ApprovalDTO> selectSendList();

}
