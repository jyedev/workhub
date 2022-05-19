package com.work.workhub.member.survey.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.work.workhub.member.survey.model.service.SurveyService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/survey")
public class SurveyController {
	
//	private SurveyService surveyService;
//	private MessageSource messageSource;
//	
//	@Autowired
//	public SurveyController(SurveyService surveyService, MessageSource messageSource) {
//		this.surveyService = surveyService;
//		this.messageSource = messageSource;
//	}
	
	
	//설문 홈
	@GetMapping("home")
	public void homeSurvey() {}
	
	//진행중 설문 목록
	@GetMapping("list_ing")
	public void listSurvey() {}
	
	//미참여 설문 상세조회
	@GetMapping("detail")
	public void detailSurvey() {}
	
	//참여 설문 상세조회
	@GetMapping("detail_check")
	public void detailCheckSurvey() {}
	
	//설문 작성
	@GetMapping("write")
	public void writeSurvey() {}
	
	


}
