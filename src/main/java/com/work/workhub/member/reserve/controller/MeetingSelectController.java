package com.work.workhub.member.reserve.controller;


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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.work.workhub.admin.reserve.model.dto.MeetingRoomDTO;
import com.work.workhub.member.member.dto.UserImpl;
import com.work.workhub.member.reserve.model.dto.ResMeetingDTO;
import com.work.workhub.member.reserve.model.service.MeetingService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("reserve/meeting")
public class MeetingSelectController {
	
	private MeetingService meetingService;
	private MessageSource messageSource;
	
	@Autowired
	public MeetingSelectController(MeetingService meetingService, MessageSource messageSource) {
		this.meetingService = meetingService;
		this.messageSource = messageSource;
	}
	
	@GetMapping("list")
	public ModelAndView selectMeetingList(ModelAndView mv, @AuthenticationPrincipal UserImpl user) {
		
		log.info("로그인 유저 {} : ", user);
		
		List<MeetingRoomDTO> locationList = meetingService.selectAllLocation();
		List<MeetingRoomDTO> roomList = meetingService.selectRoomList();
		
		
		mv.addObject("locationList", locationList);
		mv.addObject("roomList", roomList);
		
		
		mv.setViewName("reserve/meeting/list");
		
		return mv;
	}
	
	@PostMapping("list")
	public String reserveRoom(@ModelAttribute ResMeetingDTO resRoom, RedirectAttributes rttr, Locale locale) throws Exception {
		log.info("등록 요청 : {} ", resRoom);
		log.error("등록요청 : {}", resRoom);
		
		meetingService.reserveRoom(resRoom);
		
		rttr.addFlashAttribute("successMessage", messageSource.getMessage("registRoomReservation", null, locale));
		
		return "redirect:/reserve/meeting/list";
	}

}
