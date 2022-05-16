package com.work.workhub.admin.member.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.work.workhub.admin.member.model.service.AdminMemberService;
import com.work.workhub.member.member.dto.MemberDTO;
import com.work.workhub.member.member.dto.UserImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminMemberController {

	private AdminMemberService adminMemberService;
	private MessageSource messageSource;

	@Autowired
	public AdminMemberController(AdminMemberService adminMemberService, MessageSource messageSource) {
		this.adminMemberService = adminMemberService;
		this.messageSource = messageSource;
	}

	@GetMapping("/signUp")
	public String signUpPage() {
		
		return "admin/member/signUp";
	}
	
//	@GetMapping("/memberList")
//	public String selectMemberList() {
//		
//		return "admin/member/memberList";
//	}
	
	@GetMapping(value="/member/memberList")
	public ModelAndView memberListPage(ModelAndView mv) {
		
		List<MemberDTO> memberList = adminMemberService.memberList();
		mv.addObject("memberList", memberList);
		
		mv.setViewName("admin/member/memberList");
		
		return mv;
	}
	
	@PostMapping("/signUp")
	public String signUp(MemberDTO member, RedirectAttributes rttr, Locale locale) {
		
		log.error("사원 등록 : {}", member);
		log.info("사원 등록 : {}", member);		
		
		adminMemberService.signUp(member);
		
		rttr.addFlashAttribute("succesMessage", messageSource.getMessage("signUp", null, locale));
		
		return "redirect:/admin/member/memberList";
	}
	
}
