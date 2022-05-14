package com.work.workhub.admin.work.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.work.workhub.admin.work.model.dto.RestCateDTO;
import com.work.workhub.admin.work.model.service.RestCateService;
import com.work.workhub.member.member.dto.UserImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/restcate")
public class RestCateController {
	
	private RestCateService restcateService;
	private MessageSource messageSource;
	
	@Autowired
	public RestCateController(RestCateService restcateService, MessageSource messageSource) {
		this.restcateService = restcateService;
		this.messageSource = messageSource;
	}
	
	
	/* 연차유형 조회*/		
	
	@GetMapping("list")
	public ModelAndView restCateSelect(ModelAndView mv) {
			
		List<RestCateDTO> restcateList = restcateService.selectAllrestcate();
		
		mv.addObject("restcateList",restcateList);
		
		mv.setViewName("restcate/restCateSelect");
		
		return mv;
	}
	
	
	//연차 유형 작성 폼
	@GetMapping("restCateWrite")
	public void restCateWrite() {}
	
	@PostMapping("restCateWrite")
	public String restCateWrite(@ModelAttribute RestCateDTO post, @AuthenticationPrincipal UserImpl user ,RedirectAttributes rttr, Locale locale) throws Exception {
		
		post.setWriteNo(user.getNo());
		log.error("등록 요청 글 : {}", post);
		log.warn("등록 요청 글 : {}", post);
		log.info("등록 요청 글 : {}", post);
		log.debug("등록 요청 글 : {}", post);
		log.trace("등록 요청 글 : {}", post);
		
		restcateService.restCateWrite(post);
		
		rttr.addFlashAttribute("successMessage", messageSource.getMessage("restCateWrite", null, locale));
		
		return "redirect:/restcate/list";
		
	}

	
	
}
