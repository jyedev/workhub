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

@Controller
@Slf4j
@RequestMapping("asset/car")
public class CarModifyController {

	private CarService carService;
	private MessageSource messageSource;
	
	/* 차량 정보 수정,삭제용 화면 이동*/
	@GetMapping("modify")
	public void modifyCar() {
		
	}
	
	
	@PostMapping("modify")
	public String modifyCar(@ModelAttribute CarDTO car, RedirectAttributes rttr, Locale locale) throws Exception {
		

		
		log.error("등록요청메뉴 : {}",car);
		log.warn("등록요청메뉴 : {}",car);
		log.info("등록요청메뉴 : {}",car);
		log.debug("등록요청메뉴 : {}", car);
		log.trace("등록요청메뉴 : {}", car);
		
		carService.modifyCar(car);
		
		rttr.addFlashAttribute("successMessage", messageSource.getMessage("modifyCar", null, locale));
		
		return "redirect:/asset/car/list";
		
	}
}
