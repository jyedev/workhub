package com.work.workhub.admin.reserve.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.work.workhub.admin.reserve.model.dto.MeetingRoomDTO;
import com.work.workhub.admin.reserve.model.service.RoomService;

@Controller
@RequestMapping("asset/room")
public class RoomSelectController {
	
	private RoomService roomService;
	
	public RoomSelectController(RoomService roomService) {
		this.roomService = roomService;
	}
	
	@GetMapping("list")
	public ModelAndView selectRoomList(ModelAndView mv) {
			
		List<MeetingRoomDTO> roomList = roomService.selectAllRoom();
		
		mv.addObject("roomList",roomList);
		
		mv.setViewName("/asset/room/list");
		
		return mv;
	}

}
