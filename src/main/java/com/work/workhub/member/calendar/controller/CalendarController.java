package com.work.workhub.member.calendar.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.work.workhub.member.calendar.model.dto.CalendarDTO;
import com.work.workhub.member.calendar.model.dto.FullCalendarDTO;
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
	
//	/* 캘린더 일정 조회 메소드 */
//	@GetMapping("list")
//	public ModelAndView selectCalendarList (ModelAndView mv, @AuthenticationPrincipal UserImpl user) {
//		
//		int no = user.getNo();
//		
//		List<CalendarDTO> calendarList = calendarService.selectCalendarList(no);
//		
//		mv.addObject("calendarList", calendarList);
//		mv.setViewName("calendar/list");
//		
//		return mv;
//	}
	
//	/* 캘린더 일정 */
//	@GetMapping("list/json")
//	@ResponseBody
//	public List<CalendarDTO> selectCalendars(@AuthenticationPrincipal UserImpl user) {
//	      return calendarService.selectCalendarList();
//	}
//	
	
	@GetMapping("list")
	public void calendar() {}
		
	@PostMapping("/list")
	@ResponseBody
	public Map<String, FullCalendarDTO> calendar(@AuthenticationPrincipal UserImpl user) throws JsonProcessingException {
		int no = user.getNo();
		
		Map<String, FullCalendarDTO> calMap = new HashMap<>();
		List<CalendarDTO> calendarList = calendarService.selectCalendarList(no);
		
		log.info("일정목록:{}", calendarList);
		
		for(int i = 0; i < calendarList.size(); i++) {
			CalendarDTO calendar = calendarList.get(i);
			String title = calendar.getCalTitle();
			Date start = calendar.getCalStart();
			Date end = calendar.getCalEnd();
			Boolean allDay = calendar.getCalAlldayStatus();
			
			calMap.put("event" + i, new FullCalendarDTO(title, start, end, allDay));
		}
			
		return calMap;
	}

}
