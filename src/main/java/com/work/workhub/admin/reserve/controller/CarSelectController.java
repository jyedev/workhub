package com.work.workhub.admin.reserve.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.work.workhub.admin.reserve.model.dto.CarDTO;
import com.work.workhub.admin.reserve.model.service.CarService;

@Controller
@RequestMapping("asset/car")
public class CarSelectController {
	
	private CarService carService;
	
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
	

}
