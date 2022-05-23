package com.work.workhub.member.myPage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/myPage")
public class MyPageController {

	// 마이페이지 이동
	@RequestMapping(value = "/myPage")
	public String myPage() throws Exception{
		return "/myPage/myPage";
	}

	
	// myPage 수정
//	@RequestMapping(value = "/editInfo", method = RequestMethod.POST)
//	public String edit_info(@ModelAttribute MemberDTO member, HttpSession session, RedirectAttributes rttr) throws Exception{
//		session.setAttribute("member", memberService.editInfo(member));
//		rttr.addFlashAttribute("msg", "회원정보 수정 완료");
//		return "redirect:/myPage/myPage.do";
//	}
	
	// 비밀번호 변경
//	@RequestMapping(value = "/updatePw", method = RequestMethod.POST)
//	public String update_pw(@ModelAttribute MemberDTO member, @RequestParam("oldPw") String oldPw, HttpSession session, HttpServletResponse response, RedirectAttributes rttr) throws Exception{
//		session.setAttribute("member", memberService.updatePw(member, oldPw, response));
//		rttr.addFlashAttribute("msg", "비밀번호 수정 완료");
//		return "redirect:/myPage/mypage.do";
//	}
	
}
