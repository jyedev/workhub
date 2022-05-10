package com.work.workhub.member.approval.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.work.workhub.member.approval.model.dto.ApprovalDTO;
import com.work.workhub.member.approval.model.service.ApprovalService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/approval")
public class ApprovalController {
	
	private ApprovalService approvalService;
	
	@Autowired
	public ApprovalController(ApprovalService approvalService) {
		this.approvalService = approvalService;
	}

	@GetMapping("regist")
	public void registPage() {}
	
	@GetMapping("receptionList")
	public ModelAndView receptionList(ModelAndView mv) {
		
		List<ApprovalDTO> receptionList = approvalService.selectReceptionList();
		
		mv.addObject("receptionList", receptionList);
		mv.setViewName("approval/receptionList");
		
		return mv;
	}

}
