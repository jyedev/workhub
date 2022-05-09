package com.work.workhub.member.member.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.work.workhub.member.member.dto.MemberDTO;
import com.work.workhub.member.member.dto.MemberRoleDTO;

@Mapper
public interface MemberMapper {

	MemberDTO findMemberById(String username);

	void insertMember(MemberDTO member);

	void insertMemberRole(MemberRoleDTO memberRole);

}
