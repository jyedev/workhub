package com.work.workhub.admin.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.work.workhub.admin.member.model.service.AdminMemberService;

@Controller
@RequestMapping("/admin")
public class AdminMemberController {

//	private AdminMemberService adminMemberService;

//	@Autowired
//	public AdminMemberController(AdminMemberService adminMemberService) {
//		this.adminMemberService = adminMemberService;
//	}

	@GetMapping("/signUp")
	public String signUpPage() {
		
		return "admin/member/signUp";
	}
	
}
