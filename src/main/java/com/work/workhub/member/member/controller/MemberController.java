package com.work.workhub.member.member.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.work.workhub.member.member.dto.MemberDTO;
import com.work.workhub.member.member.dto.UserImpl;
import com.work.workhub.member.member.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
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
	
	@GetMapping("/signup")
	public void signupForm() {}
	
	@PostMapping("/signup")
	public String signup(MemberDTO member, RedirectAttributes rttr, Locale locale) {
		
		memberService.signup(member);
		
		rttr.addFlashAttribute("successMessage", messageSource.getMessage("registMember", null, locale));
		
		return "redirect:/";
	}
	
	@GetMapping("/mypage")
	public void mypage(@AuthenticationPrincipal UserImpl user) {
		
		log.info("로그인 유저 : {}", user);
		
	}
}
