package com.work.workhub.member.myPage.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.work.workhub.member.member.dto.MemberDTO;
import com.work.workhub.member.myPage.model.dao.MyPageMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MyPageServiceImpl implements MyPageService {

	@Autowired
	private MyPageMapper myPageMapper;

	@Override
	public MemberDTO findMemberById(String username) {
		return myPageMapper.findMemberById(username);
	}
	
	
}
