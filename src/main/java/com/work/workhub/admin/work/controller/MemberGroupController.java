package com.work.workhub.admin.work.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.work.workhub.admin.work.model.dto.MemberGroupDTO;
import com.work.workhub.admin.work.model.dto.WorkGroupDTO;
import com.work.workhub.admin.work.model.service.MemberGroupService;
import com.work.workhub.member.member.dto.MemberDTO;
import com.work.workhub.member.member.dto.UserImpl;

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
	
	//사원 근무그룹 사원 아이디 검색 없는 조회
	@GetMapping("memberGroupSelect")
	public void memberGroupSelect() {}
	
	//사원 아이디 검색으로 근무그룹 조회
	@GetMapping("memberGroupSelects")
	public String memberGroupSelect(@RequestParam int no, Model model) {
			
		log.debug("조회 요청 no : {}", no);
		
		List<MemberDTO> memberGroupList = memberGroupService.selectAllmemberGroup(no);
		
		model.addAttribute("memberGroupList", memberGroupList);
		
		return "mgroup/memberGroupSelect";
	}
	
	
	/* 사원 근무그룹 등록 (근무그룹 select box)*/		
	
	@GetMapping("memberGroupWrite")
	public ModelAndView boxSelect(ModelAndView mv) {
			
		List<WorkGroupDTO> boxList = memberGroupService.selectAllbox();
		

		mv.addObject("boxList",boxList);
		
		mv.setViewName("mgroup/memberGroupWrite");
		
		return mv;
	}
	
	/*사원 근무그룹 등록*/
	@PostMapping("memberGroupWrite")
	public String memberGroupWrite(@ModelAttribute MemberGroupDTO post, @AuthenticationPrincipal UserImpl user ,RedirectAttributes rttr, Locale locale) throws Exception {
		
		
		post.setWriteNo(user.getNo());
		log.error("등록 요청 글 : {}", post);
		log.warn("등록 요청 글 : {}", post);
		log.info("등록 요청 글 : {}", post);
		log.debug("등록 요청 글 : {}", post);
		log.trace("등록 요청 글 : {}", post);
		
		memberGroupService.memberGroupWrite(post);
		
		rttr.addFlashAttribute("successMessage", messageSource.getMessage("memberGroupWrite", null, locale));
		
		return "redirect:/mgroup/memberGroupSelect";
		
	}
	
	
}
