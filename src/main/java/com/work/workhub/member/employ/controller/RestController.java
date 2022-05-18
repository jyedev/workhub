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

import com.work.workhub.admin.work.model.dto.RestCateDTO;
import com.work.workhub.admin.work.model.dto.WorkDTO;
import com.work.workhub.member.employ.model.dto.AttDTO;
import com.work.workhub.member.employ.model.service.RestService;
import com.work.workhub.member.member.dto.UserImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/rest")
public class RestController {
	
	private RestService restService;
	private MessageSource messageSource;
	
	@Autowired
	public RestController(RestService restService, MessageSource messageSource) {
		this.restService = restService;
		this.messageSource = messageSource;
	}
	
	
		/* 근무유형 select box*/		
		@GetMapping("restSelect")
		public ModelAndView restSelect(ModelAndView mv) {
			
			//근무 유형 select box
			List<WorkDTO> attsList = restService.selectsBox();
			

			mv.addObject("attsList",attsList);
			
			
			mv.setViewName("rest/restSelect");
			
			return mv;
		}	
		
		
		//휴가 신청서
		@GetMapping("restWrite")
		public ModelAndView restWrite(ModelAndView mv) {
		
		//휴가 유형 select box
		List<RestCateDTO> rcList = restService.rcBox();
		

		mv.addObject("rcList",rcList);
		
		
		mv.setViewName("rest/restWrite");
		
		return mv;
		
		}

}
