package com.work.workhub.member.approval.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class approvalController {
	@GetMapping(value="/approval/regist")
	public void registPage() {}

}