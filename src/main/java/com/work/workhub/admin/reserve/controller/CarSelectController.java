package com.work.workhub.admin.reserve.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ModelAndView selectCarList(ModelAndView mv, Model model) {
			
		List<CarDTO> carList = carService.selectAllCar();
				
		mv.addObject("carList",carList);
		
		mv.setViewName("asset/car/list");
		
		return mv;
	}
	
	
	@GetMapping("modify")
	public String dispatchCarInfo(HttpServletRequest request, Model model) {
		int carNo = Integer.parseInt(request.getParameter("carNo"));
		
		CarDTO carInfo = carService.selectCarInfo(carNo);
		model.addAttribute("carInfo", carInfo);
		
		return "/asset/car/modify";
		
	}

}
