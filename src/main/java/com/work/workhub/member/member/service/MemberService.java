package com.work.workhub.member.member.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.work.workhub.member.member.dto.MemberDTO;

public interface MemberService extends UserDetailsService {

	public void findPw(String memberEmail, String memberId) throws Exception;
	
	public int findPwCheck(MemberDTO memberDTO) throws Exception;
	
	// 회원정보 수정
//	@Override
//	public MemberDTO update_mypage(MemberDTO member) throws Exception {
//		manager.update_mypage(member);
//		return manager.login(member.getId());
//	}
	
	// 비밀번호 변경
//	@Override
//	public MemberDTO update_pw(MemberDTO member, String old_pw, HttpServletResponse response) throws Exception {
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out = response.getWriter();
//		if(!old_pw.equals(manager.login(member.getId()).getPw())) {
//			out.println("<script>");
//			out.println("alert('기존 비밀번호가 다릅니다.');");
//			out.println("history.go(-1);");
//			out.println("</script>");
//			out.close();
//			return null;
//		}else {
//			manager.update_pw(member);
//			return manager.login(member.getId());
//		}
//	}
	
}


