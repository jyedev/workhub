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

import com.work.workhub.admin.work.model.dto.WorkDTO;
import com.work.workhub.admin.work.model.service.WorkService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/work")
public class WorkWriteController {
	
	private WorkService workService;
	private MessageSource messageSource;
	
	@Autowired
	public WorkWriteController(WorkService workService, MessageSource messageSource) {
		this.workService = workService;
		this.messageSource = messageSource;
	}
	
	
	/* 근무유형 조회*/		
	
	@GetMapping("list")
	public ModelAndView workSelect(ModelAndView mv) {
			
		List<WorkDTO> workList = workService.selectAllwork();
		
		mv.addObject("workList",workList);
		
		mv.setViewName("work/workSelect");
		
		return mv;
	}
	
	
	//근무 유형 작성 폼
	@GetMapping("workWrite")
	public void workWrite() {}
	
	@PostMapping("workWrite")
	public String workWrite(@ModelAttribute WorkDTO post, RedirectAttributes rttr, Locale locale) throws Exception {
		
		log.error("등록 요청 글 : {}", post);
		log.warn("등록 요청 글 : {}", post);
		log.info("등록 요청 글 : {}", post);
		log.debug("등록 요청 글 : {}", post);
		log.trace("등록 요청 글 : {}", post);
		
		workService.workWrite(post);
		
		rttr.addFlashAttribute("successMessage", messageSource.getMessage("workWrite", null, locale));
		
		return "redirect:/work/list";
		
	}

	
	
}
