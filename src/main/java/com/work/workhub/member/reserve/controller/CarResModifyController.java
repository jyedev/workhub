package com.work.workhub.member.reserve.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.work.workhub.member.reserve.model.dto.ResCarDTO;
import com.work.workhub.member.reserve.model.service.CarResService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("reserve/car")
public class CarResModifyController {
	
	private CarResService carService;
	private MessageSource messageSource;
	
	@Autowired
	public CarResModifyController(CarResService carService, MessageSource messageSource) {
		this.carService = carService;
		this.messageSource = messageSource;
	}
	
	
	@GetMapping("modify")
	public void modifyCarRes() {
		
	}
	
	
	/* 차량 예약 수정 메소드 */
	@PostMapping("modify")
	public String modifyCarRes(@ModelAttribute ResCarDTO car, RedirectAttributes rttr, Locale locale) throws Exception {
		
		log.error("수정할 차 정보 : {}",car);
		log.info("수정할 차 정보 : {}",car);
		
		carService.modifyCarRes(car);
		
		rttr.addFlashAttribute("successMessage", messageSource.getMessage("modifyCarRes", null, locale));
		
		return "redirect:/reserve/mylist";
		
	}
}
