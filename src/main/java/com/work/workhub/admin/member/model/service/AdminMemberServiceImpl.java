package com.work.workhub.admin.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.work.workhub.admin.member.model.dao.AdminMemberMapper;
import com.work.workhub.member.member.dto.MemberDTO;
import com.work.workhub.member.member.dto.MemberRoleDTO;

@Service
public class AdminMemberServiceImpl implements AdminMemberService {

	private AdminMemberMapper adminMemberMapper;
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public AdminMemberServiceImpl(AdminMemberMapper adminMemberMapper, PasswordEncoder passwordEncoder) {
		this.adminMemberMapper = adminMemberMapper;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		
		return null;
	}

	@Override
	public void signUp(MemberDTO member) {
		
		member.setPwd(passwordEncoder.encode(member.getPwd()));
		adminMemberMapper.insertMember(member);
		
		MemberRoleDTO memberRole = new MemberRoleDTO();
		memberRole.setAuthNo(1);
		adminMemberMapper.insertMemberRole(memberRole);
		
	}
	
	
	
	
}
