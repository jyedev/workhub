package com.work.workhub.member.approval.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.work.workhub.member.approval.model.dto.ApprovalDTO;
import com.work.workhub.member.approval.model.service.ApprovalService;
import com.work.workhub.member.member.dto.DepartmentDTO;
import com.work.workhub.member.member.dto.MemberDTO;

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
	public ModelAndView registPage(ModelAndView mv) {
		
		List<DepartmentDTO> departmentList = approvalService.selectDepartmentList();
		List<MemberDTO> memberList = approvalService.selectMemberList();
		
		mv.addObject("departmentList", departmentList);
		mv.setViewName("approval/regist");
		
		mv.addObject("memberList", memberList);
		mv.setViewName("approval/regist");
		
		log.info("부서 목록 : {}", departmentList);
		log.info("사원 목록 : {}", memberList);
		
		return mv;
	}
	
	@GetMapping("receptionList")
	public ModelAndView receptionList(ModelAndView mv) {
		
		List<ApprovalDTO> receptionList = approvalService.selectReceptionList();

		
		mv.addObject("receptionList", receptionList);

		

		log.info("수신목록 : {}", receptionList.toString());
		log.error("수신목록 : {}", receptionList.toString());
		
		return mv;
	}
	
	@GetMapping("sendList")
	public ModelAndView sendList(ModelAndView mv) {
		
		List<ApprovalDTO> sendList = approvalService.selectSendList();
		
		mv.addObject("sendList", sendList);
		mv.setViewName("approval/sendList");
		
		log.info("발신목록 : {}", sendList.toString());
		log.error("발신목록 : {}", sendList.toString());
		
		return mv;
	}

}
