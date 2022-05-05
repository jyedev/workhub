package com.work.workhub.member.reserve.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/reserve/car")
public class CarResSelectController {
	
	@GetMapping("list")
	public ModelAndView selectCarReserveList(ModelAndView mv) {
			
		
		mv.setViewName("/reserve/car/list");
		
		return mv;
	}

}
