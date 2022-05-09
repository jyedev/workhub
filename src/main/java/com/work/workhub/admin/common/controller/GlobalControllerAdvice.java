package com.work.workhub.admin.common.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerAdvice {
	
	/* @ExceptionHandler
	 * : @Controller, @RestController 가 적용 된 bean 내에서 발생하는 예외를 잡아서 하나의 메서드에서 처리해주는 기능
	 *   이를 @ControllerAdvice, @RestControlleAdvice 가 적용 된 bean 내에서 작성하면 전역 설정이 된다.
	 * */
	
	@ExceptionHandler(value = Exception.class)
	public String exception(Exception e, Model model) {
		
		model.addAttribute("errorMessage", e.getMessage());
		
		return "error/error";
	}
	

}
