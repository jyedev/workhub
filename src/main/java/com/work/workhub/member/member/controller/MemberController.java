package com.work.workhub.member.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.work.workhub.member.member.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/member")
public class MemberController {

	private MemberService memberService;
	private MessageSource messageSource;
	
	@Autowired
	public MemberController(MemberService memberService, MessageSource messageSource) {
		this.memberService = memberService;
		this.messageSource = messageSource;
	}

	@GetMapping("/login")
	public void loginForm() {}
	
	@PostMapping("/login")
	public void loginForm(@RequestParam(required=false) String errorMessage, Model model) {

		model.addAttribute("errorMessage", errorMessage);
	}

	
	//비밀번호 찾기
	/*
	 * @RequestMapping("/findPw", method=RequestMethod.POST) public String findPw()
	 * throws Exception { return "/member/findPw"; }
	 * 
	 * @RequestMapping("/findPw", method=RequestMethod.POST) public String
	 * findPw(MemberDTO memberDTO, Model model) throws Exception {
	 * log.info("memberPw"+memberDTO.getMemberId());
	 * 
	 * if(memberService.findPwCheck(memberDTO)==0) { log.info("memberPwcheck");
	 * model.addAttribute(""); }
	 * 
	 * }
	 */

	
}
