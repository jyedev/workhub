package com.work.workhub.member.member.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.work.workhub.member.member.dto.MemberDTO;

public interface MemberService extends UserDetailsService {

	public void findPw(String memberEmail, String memberId) throws Exception;
	
	public int findPwCheck(MemberDTO memberDTO) throws Exception;
	
}


