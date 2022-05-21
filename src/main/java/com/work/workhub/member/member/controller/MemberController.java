package com.work.workhub.member.member.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.work.workhub.member.member.dto.MemberDTO;
import com.work.workhub.member.member.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/member")
public class MemberController {

	private MemberService memberService;
	private MessageSource messageSource;
	
	@Autowired
	public MemberController(MemberService memberService, MessageSource messageSource) {
		this.memberService = memberService;
		this.messageSource = messageSource;
	}

	@RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
	public void loginForm(@RequestParam(required=false) String errorMessage, Model model) {
		
		model.addAttribute("errorMessage", errorMessage);
	}

	
	// 마이페이지 이동
	@RequestMapping(value = "/myPage")
	public String myPage() throws Exception{
		return "/myPage/myPage";
	}

	
	// myPage 수정
//	@RequestMapping(value = "/editInfo.do", method = RequestMethod.POST)
//	public String edit_info(@ModelAttribute MemberDTO member, HttpSession session, RedirectAttributes rttr) throws Exception{
//		session.setAttribute("member", memberService.editInfo(member));
//		rttr.addFlashAttribute("msg", "회원정보 수정 완료");
//		return "redirect:/myPage/myPage.do";
//	}
	
	// 비밀번호 변경
//	@RequestMapping(value = "/updatePw.do", method = RequestMethod.POST)
//	public String update_pw(@ModelAttribute MemberDTO member, @RequestParam("oldPw") String oldPw, HttpSession session, HttpServletResponse response, RedirectAttributes rttr) throws Exception{
//		session.setAttribute("member", memberService.updatePw(member, oldPw, response));
//		rttr.addFlashAttribute("msg", "비밀번호 수정 완료");
//		return "redirect:/myPage/mypage.do";
//	}

}
