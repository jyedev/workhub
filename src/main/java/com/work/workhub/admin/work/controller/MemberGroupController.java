package com.work.workhub.admin.work.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.work.workhub.admin.work.model.dto.WorkGroupDTO;
import com.work.workhub.admin.work.model.service.MemberGroupService;
import com.work.workhub.member.member.dto.MemberDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/mgroup")
public class MemberGroupController {
	
	private MemberGroupService memberGroupService;
	private MessageSource messageSource;
	
	@Autowired
	public MemberGroupController(MemberGroupService memberGroupService, MessageSource messageSource) {
		this.memberGroupService = memberGroupService;
		this.messageSource = messageSource;
	}
	
	//사원 아이디 검색으로 근무그룹 조회
//	@GetMapping("list")
//	public ModelAndView memberGroupSelect(ModelAndView mv) {
//			
//		List<MemberDTO> memberGroupList = memberGroupService.selectAllmemberGroup();
//		
//
//		mv.addObject("memberGroupList",memberGroupList);
//		
//		mv.setViewName("mgroup/memberGroupSelect");
//		
//		return mv;
//	}
	

	
	
}
