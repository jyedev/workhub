package com.work.workhub.admin.member.model.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.work.workhub.member.member.dto.MemberDTO;

public interface AdminMemberService extends UserDetailsService {

	void signUp(MemberDTO member);
}
