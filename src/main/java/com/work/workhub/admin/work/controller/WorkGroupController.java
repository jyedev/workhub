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
	
	
	/* 근무그룹유형 조회*/		
	
//	@GetMapping("list")
//	public ModelAndView workGroupSelect(ModelAndView mv) {
//			
//		List<WorkGroupDTO> workGroupList = workgroupService.selectAllworkGroup();
//		
//		mv.addObject("workGroupList",workGroupList);
//		
//		mv.setViewName("group/workGroupSelect");
//		
//		return mv;
//	}
	
	

	
	
}
