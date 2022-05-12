package com.work.workhub.admin.reserve.controller;


import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.work.workhub.admin.reserve.model.dto.CarDTO;
import com.work.workhub.admin.reserve.model.service.CarService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("asset/car")
public class CarSelectController {
	
	private CarService carService;
	private MessageSource messageSource;
	
	@Autowired
	public CarSelectController(CarService carService) {
		this.carService = carService;
	}
	
	@GetMapping("list")
	public ModelAndView selectCarList(ModelAndView mv) {
			
		List<CarDTO> carList = carService.selectAllCar();
				
		mv.addObject("carList",carList);
		
		mv.setViewName("asset/car/list");
		
		return mv;
	}
	
	
	@GetMapping("modify")
	public String dispatchCarInfo(@RequestParam int carNo, Model model) {
		
		CarDTO carInfo = carService.selectCarInfo(carNo);
		model.addAttribute("carInfo", carInfo);
		
		log.info("carInfo : {}", carInfo);
				
		
		return "/asset/car/modify";
		
	}
	
	@GetMapping("delete")
	public String deleteCar(@RequestParam int carNo, Model model) {
		CarDTO carInfo = carService.selectCarInfo(carNo);
		model.addAttribute("carInfo", carInfo);
		
		log.info("carInfo : {}", carInfo);
		
		return "/asset/car/delete";
	}
	
	
	
}
