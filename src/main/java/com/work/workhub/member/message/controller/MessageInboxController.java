package com.work.workhub.member.message.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.work.workhub.member.message.model.dto.InboxDTO;
import com.work.workhub.member.message.model.service.InboxService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/message")
public class MessageInboxController {
	
	private InboxService inboxService;
	
	@Autowired
	public MessageInboxController(InboxService inboxService) {
		this.inboxService = inboxService;
	}
	
	
	@GetMapping("inboxList")
	public ModelAndView findMessageInboxList(ModelAndView mv) {
		
		List<InboxDTO> messageInboxList = inboxService.findMessageInbox();
		
		mv.addObject("messageInboxList", messageInboxList);
		mv.setViewName("message/inboxList");
		
		return mv;
		
	}

}