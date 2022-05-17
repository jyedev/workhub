package com.work.workhub.member.employ.controller;

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
import com.work.workhub.admin.work.model.dto.WorkDTO;
import com.work.workhub.admin.work.model.dto.WorkGroupDTO;
import com.work.workhub.member.employ.model.dto.AttDTO;
import com.work.workhub.member.employ.model.service.EmploymentService;
import com.work.workhub.member.member.dto.UserImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/employ")
public class EmploymentController {
	
	private EmploymentService employmentService;
	private MessageSource messageSource;
	
	@Autowired
	public EmploymentController(EmploymentService employmentService, MessageSource messageSource) {
		this.employmentService = employmentService;
		this.messageSource = messageSource;
	}
	

		
		//출근하기 버튼 눌렀을 때
		@GetMapping("in")
		public String employmentIn(@ModelAttribute AttDTO post, @AuthenticationPrincipal UserImpl user, RedirectAttributes rttr, Locale locale) throws Exception {
			
			post.setNo(user.getNo());
			
			log.info("등록 요청 글 : {}", post);
			
			
			employmentService.employmentIn(post);
			
			rttr.addFlashAttribute("successMessage", messageSource.getMessage("employmentIn", null, locale));
			
			return "redirect:/employ/employmentSelect";
			
		}
		
		//퇴근하기 버튼 눌렀을 때
		@GetMapping("out")
		public String employmentOut(@ModelAttribute AttDTO post, @AuthenticationPrincipal UserImpl user, RedirectAttributes rttr, Locale locale) throws Exception {
			
			post.setNo(user.getNo());
			
			log.info("등록 요청 글 : {}", post);
			
			
			employmentService.employmentOut(post);
			
			rttr.addFlashAttribute("successMessage", messageSource.getMessage("employmentOut", null, locale));
			
			return "redirect:/employ/employmentSelect";
			
		}
		
		/* 근무유형 select box*/		
		//근태 조회
		@GetMapping("employmentSelect")
		public ModelAndView employmentSelect(ModelAndView mv) {
			
			//근무 유형 select box
			List<WorkDTO> attList = employmentService.selectBox();
			
			//근태 조회
			List<AttDTO> attenList = employmentService.attenSelect();
			

			mv.addObject("attList",attList);
			mv.addObject("attenList",attenList);
			
			mv.setViewName("employ/employmentSelect");
			
			return mv;
		}
		
		//select box 근무 등록
		@PostMapping("other")
		public String employmentOther(@ModelAttribute AttDTO post, @AuthenticationPrincipal UserImpl user ,RedirectAttributes rttr, Locale locale) throws Exception {
			
			post.setNo(user.getNo());
			
			log.info("등록 요청 글 : {}", post);
			
			
			employmentService.employmentOther(post);
			
			rttr.addFlashAttribute("successMessage", messageSource.getMessage("employmentOther", null, locale));
			
			return "redirect:/employ/employmentSelect";
			
		}
		
}
