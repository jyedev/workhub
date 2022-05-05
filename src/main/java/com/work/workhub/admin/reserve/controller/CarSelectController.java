package com.work.workhub.admin.reserve.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/asset")
public class CarSelectController {
	
	@GetMapping("car/list")
	public ModelAndView selectCarList(ModelAndView mv) {
			
		
		mv.setViewName("/asset/car/list");
		
		return mv;
	}
	

}
