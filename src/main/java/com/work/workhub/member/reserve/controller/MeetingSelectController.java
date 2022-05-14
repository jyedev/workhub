package com.work.workhub.member.reserve.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.work.workhub.admin.reserve.model.dto.MeetingRoomDTO;
import com.work.workhub.member.reserve.model.service.MeetingService;


@Controller
@RequestMapping("reserve")
public class MeetingSelectController {
	
	private MeetingService meetingService;
	
	@Autowired
	public MeetingSelectController(MeetingService meetingService) {
		this.meetingService = meetingService;
	}
	
	@GetMapping("meeting/list")
	public ModelAndView selectMeetingList(ModelAndView mv) {
			
		List<MeetingRoomDTO> locationList = meetingService.selectAllLocation();
		List<MeetingRoomDTO> roomList = meetingService.selectRoomList();
		
		mv.addObject("locationList", locationList);
		mv.addObject("roomList", roomList);
		
		mv.setViewName("/reserve/meeting/list");
		
		return mv;
	}
	

}
