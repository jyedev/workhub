package com.work.workhub.member.myPage.model.service;

import com.work.workhub.member.member.dto.MemberDTO;

public interface MyPageService {
	
	MemberDTO findMemberById(String username);

}
