package com.work.workhub.member.reserve.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.work.workhub.member.reserve.model.dto.ResCarDTO;
import com.work.workhub.member.reserve.model.service.CarResService;



@Controller
@RequestMapping("/reserve/car")
public class CarResSelectController {
	
	private CarResService carResService;
	
	@Autowired
	public CarResSelectController(CarResService carResService) {
		this.carResService = carResService;
	}
	
	@GetMapping("list")
	public ModelAndView selectCarList(ModelAndView mv) {
			
		
		
		mv.setViewName("reserve/car/list");
		
		return mv;
	}
	


}
