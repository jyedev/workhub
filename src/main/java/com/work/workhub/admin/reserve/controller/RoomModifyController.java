package com.work.workhub.admin.reserve.controller;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.work.workhub.admin.reserve.model.dto.MeetingRoomDTO;
import com.work.workhub.admin.reserve.model.service.RoomService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("asset/room")
public class RoomModifyController {
	
	private RoomService roomService;
	private MessageSource messageSource;
	
	/* 차량 정보 수정,삭제용 화면 이동*/
	@GetMapping("modify")
	public void modifyRoom() {
		
	}
	
	
	@PostMapping("modify")
	public String modifyRoom(@ModelAttribute MeetingRoomDTO room, RedirectAttributes rttr, Locale locale) throws Exception {
		

		
		log.error("등록요청메뉴 : {}",room);
		log.warn("등록요청메뉴 : {}",room);
		log.info("등록요청메뉴 : {}",room);
		log.debug("등록요청메뉴 : {}", room);
		log.trace("등록요청메뉴 : {}", room);
		
		roomService.modifyRoom(room);
		
		rttr.addFlashAttribute("successMessage", messageSource.getMessage("modifyRoom", null, locale));
		
		return "redirect:/asset/room/list";
		
	}

}
