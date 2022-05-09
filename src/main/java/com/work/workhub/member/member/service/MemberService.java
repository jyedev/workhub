package com.work.workhub.member.member.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.work.workhub.member.member.dto.MemberDTO;


/* 스프링 시큐리티에서 제공하는 기능을 이용해 로그인 로직을 작성해야 함 */
public interface MemberService extends UserDetailsService{

	void signup(MemberDTO member);

}
