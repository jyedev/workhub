package com.work.workhub.member.reserve.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.work.workhub.admin.reserve.model.dto.MeetingRoomDTO;
import com.work.workhub.member.member.dto.UserImpl;
import com.work.workhub.member.member.service.MemberService;
import com.work.workhub.member.reserve.model.service.MeetingService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("reserve")
public class MeetingSelectController {
	
	private MeetingService meetingService;
	private MemberService memberService;
	
	@Autowired
	public MeetingSelectController(MeetingService meetingService) {
		this.meetingService = meetingService;
	}
	
	@GetMapping("meeting/list")
	public ModelAndView selectMeetingList(ModelAndView mv, String username, @AuthenticationPrincipal UserImpl user) {
		
		log.info("로그인 유저 {} : ", user);
		
		List<MeetingRoomDTO> locationList = meetingService.selectAllLocation();
		List<MeetingRoomDTO> roomList = meetingService.selectRoomList();
		
		
		mv.addObject("locationList", locationList);
		mv.addObject("roomList", roomList);
		
		mv.setViewName("/reserve/meeting/list");
		
		return mv;
	}
	

}
