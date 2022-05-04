package com.work.workhub.member.reserve.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/reserve")
public class MtReserveSelectController {
	
	@GetMapping("/meeting/list")
	public ModelAndView selectAllMtReserveList(ModelAndView mv) {
			
		
		mv.setViewName("/reserve/meeting/list");
		
		return mv;
	}
	

}
