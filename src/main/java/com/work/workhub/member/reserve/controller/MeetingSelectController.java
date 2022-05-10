package com.work.workhub.member.reserve.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("reserve")
public class MeetingSelectController {
	
	@GetMapping("meeting/list")
	public ModelAndView selectMeetingList(ModelAndView mv) {
			
		
		mv.setViewName("/reserve/meeting/list");
		
		return mv;
	}
	

}
