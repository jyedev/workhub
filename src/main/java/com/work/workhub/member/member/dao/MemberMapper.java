package com.work.workhub.member.member.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

import com.work.workhub.member.member.dto.MemberDTO;

@Mapper
public interface MemberMapper {

	MemberDTO findMemberById(String username);
	
	/* 웹소켓 쪽지 Id 찾기 */
	String findIdByNo(String receiver);

	// 마이페이지
//	@Transactional
//	public int update_myPage(MemberDTO member) throws Exception{
//		return sqlsession.update("member.update_mypage", member);
//	}

}
