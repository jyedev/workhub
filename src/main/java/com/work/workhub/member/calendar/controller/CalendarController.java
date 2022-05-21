package com.work.workhub.member.calendar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.work.workhub.member.calendar.model.dto.CalendarDTO;
import com.work.workhub.member.calendar.model.service.CalendarService;
import com.work.workhub.member.member.dto.UserImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/calendar")
public class CalendarController {
	
	private CalendarService calendarService;
	private MessageSource messageSource;
	
	@Autowired
	public CalendarController(CalendarService calendarService, MessageSource messageSource) {
		this.calendarService = calendarService;
		this.messageSource = messageSource;
	}
	
	/* 캘린더 일정 조회 메소드 */
	@GetMapping("list")
	public ModelAndView selectCalendarList (ModelAndView mv, @AuthenticationPrincipal UserImpl user) {
		
		List<CalendarDTO> calendarList = calendarService.selectCalendarList();
		
		mv.addObject("calendarList", calendarList);
		mv.setViewName("calendar/list");
		
		return mv;
	}

}
