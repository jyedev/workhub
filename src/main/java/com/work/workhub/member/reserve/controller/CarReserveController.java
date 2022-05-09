package com.work.workhub.member.reserve.controller;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.work.workhub.member.reserve.model.dto.ResCarDTO;
import com.work.workhub.member.reserve.model.service.CarService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
@RequestMapping("/reserve/car")
public class CarReserveController {
	
	private CarService carService;
	
	private MessageSource messageSource;
	
	/* 차량 등록용 화면 이동*/
	@GetMapping("reserve")
	public void registCar() {
		
	}
	
	
	@PostMapping("reserve")
	public String registCar(@ModelAttribute ResCarDTO car, RedirectAttributes rttr, Locale locale) throws Exception {
		

		
		log.error("등록요청메뉴 : {}",car);
		log.warn("등록요청메뉴 : {}",car);
		log.info("등록요청메뉴 : {}",car);
		log.debug("등록요청메뉴 : {}", car);
		log.trace("등록요청메뉴 : {}", car);
		
		carService.reserveCar(car);
		
		rttr.addFlashAttribute("successMessage", messageSource.getMessage("reserveCar", null, locale));
		
		return "redirect:/reserve/car/list";
		
	}

}
