package com.work.workhub.member.reserve.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/reserve/meeting")
public class MeetingModifyController {

	/* 회의실 예약 수정용 화면 이동*/
	@GetMapping("modify")
	public void modifyMeeting() {
		
	}
	
}
