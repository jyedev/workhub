package com.work.workhub.member.approval.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.work.workhub.member.approval.model.dto.ApprovalDTO;
import com.work.workhub.member.approval.model.service.ApprovalService;
import com.work.workhub.member.member.dto.DepartmentDTO;
import com.work.workhub.member.member.dto.MemberDTO;
import com.work.workhub.member.member.dto.UserImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/approval")
public class ApprovalController {
	
	private ApprovalService approvalService;
	private MessageSource messageSource;
	
	@Autowired
	public ApprovalController(ApprovalService approvalService, MessageSource messageSource) {
		this.approvalService = approvalService;
		this.messageSource = messageSource;
	}

	@GetMapping("regist")
	public ModelAndView registPage(ModelAndView mv, @AuthenticationPrincipal UserImpl user) {
		
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
	
	@PostMapping("regist")
	public String registApproval(@ModelAttribute ApprovalDTO approval, @AuthenticationPrincipal UserImpl user, RedirectAttributes rttr, Locale locale) throws Exception {
		
		approval.setNo(user.getNo());
		log.info("결재문서 등록 : {}", approval);
		
		approvalService.registApproval(approval);
		
		rttr.addFlashAttribute("successMessage", messageSource.getMessage("registApproval", null, locale));
		
		System.out.println("결재자 수 : " + approval.getReceiverCount());
		
		return "redirect:/approval/sendList";
		
	}
	
	@GetMapping("receptionList")
	public ModelAndView receptionList(ModelAndView mv, @AuthenticationPrincipal UserImpl user) {
		
		List<ApprovalDTO> receptionList = approvalService.selectReceptionList();

		
		mv.addObject("receptionList", receptionList);

		

		log.info("수신목록 : {}", receptionList.toString());
		log.error("수신목록 : {}", receptionList.toString());
		
		return mv;
	}
	
	@GetMapping("sendList")
	public ModelAndView sendList(ModelAndView mv, @AuthenticationPrincipal UserImpl user) {
		
		List<ApprovalDTO> sendList = approvalService.selectSendList();
		
		mv.addObject("sendList", sendList);
		mv.setViewName("approval/sendList");
		
		log.info("발신목록 : {}", sendList.toString());
		log.error("발신목록 : {}", sendList.toString());
		
		return mv;
	}

}
