package com.work.workhub.admin.reserve.controller;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.work.workhub.admin.reserve.model.dto.CarDTO;
import com.work.workhub.admin.reserve.model.service.CarService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("asset/car")
public class CarRegistController {
	
	private CarService carService;
	private MessageSource messageSource;
	
	/* 메뉴 등록용 화면 이동*/
	@GetMapping("regist")
	public void registPage() {
		
	}
	
	
	@PostMapping("regist")
	public String registCar(@ModelAttribute CarDTO car, RedirectAttributes rttr, Locale locale) throws Exception {
		

		
		log.error("등록요청메뉴 : {}",car);
		log.warn("등록요청메뉴 : {}",car);
		log.info("등록요청메뉴 : {}",car);
		log.debug("등록요청메뉴 : {}", car);
		log.trace("등록요청메뉴 : {}", car);
		
		carService.registCar(car);
		
		rttr.addFlashAttribute("successMessage", messageSource.getMessage("registCar", null, locale));
		
		return "redirect:/menu/list";
		
	}

}
