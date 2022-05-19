package com.work.workhub.member.member.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.work.workhub.member.member.dto.MemberDTO;

public interface MemberService extends UserDetailsService {

	public void findPw(String memberEmail, String memberId) throws Exception;
	
	public int findPwCheck(MemberDTO memberDTO) throws Exception;

	public MemberDTO editInfo(MemberDTO member)throws Exception;
	
	public MemberDTO updatePw(MemberDTO member, String old_pw, HttpServletResponse response) throws Exception;
}


