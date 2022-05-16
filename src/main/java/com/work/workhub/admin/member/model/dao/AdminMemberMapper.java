package com.work.workhub.admin.member.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.work.workhub.member.member.dto.MemberDTO;
import com.work.workhub.member.member.dto.MemberRoleDTO;

@Mapper
public interface AdminMemberMapper {

	void insertMember(MemberDTO member);
	
	void insertMemberRole(MemberRoleDTO memberRole);
	
	List<MemberDTO> selectMemberList();
}
