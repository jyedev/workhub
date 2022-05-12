package com.work.workhub.member.member.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

import com.work.workhub.member.member.dto.MemberDTO;

@Mapper
public interface MemberMapper {

	MemberDTO findMemberById(String username);
	
	//=====================해결 중=======================
	// 비밀번호 변경
//	@Transactional
//	public int update_pw(MemberDTO member) throws Exception{
//		return sqlsession.update("member.update_pw", member);
//	}

}
