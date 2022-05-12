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

import com.work.workhub.admin.work.model.dto.RestCateDTO;
import com.work.workhub.admin.work.model.dto.WorkGroupDTO;
import com.work.workhub.admin.work.model.service.WorkGroupService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/group")
public class WorkGroupController {
	
	private WorkGroupService workgroupService;
	private MessageSource messageSource;
	
	@Autowired
	public WorkGroupController(WorkGroupService workgroupService, MessageSource messageSource) {
		this.workgroupService = workgroupService;
		this.messageSource = messageSource;
	}
	
	
	/* 근무그룹유형 조회 status = 'y'*/		
	
	@GetMapping("list")
	public ModelAndView workGroupSelect(ModelAndView mv) {
			
		List<WorkGroupDTO> workGroupList = workgroupService.selectAllworkGroup();
		

		mv.addObject("workGroupList",workGroupList);
		
		mv.setViewName("group/workGroupSelect");
		
		return mv;
	}
	
	 //근무그룹 유형 작성 폼
		@GetMapping("workGroupWrite")
		public void workGroupWrite() {}
		
		@PostMapping("workGroupWrite")
		public String workGroupWrite(@ModelAttribute WorkGroupDTO post, RedirectAttributes rttr, Locale locale) throws Exception {
			
			
			
			log.error("등록 요청 글 : {}", post);
			log.warn("등록 요청 글 : {}", post);
			log.info("등록 요청 글 : {}", post);
			log.debug("등록 요청 글 : {}", post);
			log.trace("등록 요청 글 : {}", post);
			
			workgroupService.workGroupWrite(post);
			
			rttr.addFlashAttribute("successMessage", messageSource.getMessage("workGroupWrite", null, locale));
			
			return "redirect:/group/list";
			
		}
		
		/* 근무그룹유형 조회 use = '사용' 만*/		
		
//		@GetMapping("lists")
//		public ModelAndView workGroupSelects(ModelAndView mv) {
//				
//			List<WorkGroupDTO> workGroupLists = workgroupService.selectAllworkGroups();
//			
//
//			mv.addObject("workGroupLists",workGroupLists);
//			
//			mv.setViewName("group/workGroupWrite");
//			
//			return mv;
//		}

	
	
}
