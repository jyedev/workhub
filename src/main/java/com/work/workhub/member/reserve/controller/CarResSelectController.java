package com.work.workhub.member.reserve.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.work.workhub.admin.reserve.model.dto.CarDTO;
import com.work.workhub.member.member.dto.UserImpl;
import com.work.workhub.member.reserve.model.dto.ResCarDTO;
import com.work.workhub.member.reserve.model.service.CarResService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/reserve/car")
public class CarResSelectController {
	
	private CarResService carResService;
	
	@Autowired
	public CarResSelectController(CarResService carResService) {
		this.carResService = carResService;
	}
	
	@GetMapping("list")
	public ModelAndView selectCarList(ModelAndView mv, @AuthenticationPrincipal UserImpl user) {
		
		log.info("로그인 유저 정보 : {}", user);
		
		List<CarDTO> carList = carResService.selectAllCar();
		List<ResCarDTO> resCarList = carResService.selectAllResCarList();
		
		mv.addObject("carList", carList);
		mv.addObject("resCarList", resCarList);
		
		mv.setViewName("reserve/car/list");
		
		return mv;
	}
	


}
