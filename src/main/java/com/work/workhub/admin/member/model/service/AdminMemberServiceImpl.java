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
		
		/* 시퀀스 이름을 부서 별로 따로 쓰니깐 부서별로 각각 다르게 정의해주는것 */
		String sequenceName = "SEQ_MEM_NO_";
		switch(member.getDepNo()) {
		case 1 : sequenceName += "GBB"; break;
		case 2 : sequenceName += "GNT"; break;
		case 3 : sequenceName += "HR"; break;
		case 4 : sequenceName += "MKT"; break;
		case 5 : sequenceName += "SAL"; break;
		}
		member.setSequenceName(sequenceName);
		
		/* 인사팀(depNo 가 1) 에만 관리자 권한(authNo 를 1로) 부여하고, 다른 경우는 모두 일반 관리자 (authNo 를 2로) 부여한다 */
		int authNo = 2;
		if(member.getDepNo() == 1) authNo = 1;
		
		member.setPwd(passwordEncoder.encode(member.getPwd()));
		adminMemberMapper.insertMember(member);
		
		MemberRoleDTO memberRole = new MemberRoleDTO();
		memberRole.setAuthNo(1);
		memberRole.setSequenceName(sequenceName);
		memberRole.setAuthNo(authNo);
		adminMemberMapper.insertMemberRole(memberRole);
		
	}
	
}
