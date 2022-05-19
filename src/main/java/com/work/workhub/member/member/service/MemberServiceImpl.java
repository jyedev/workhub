package com.work.workhub.member.member.service;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.work.workhub.member.member.dao.MemberMapper;
import com.work.workhub.member.member.dto.AuthorityDTO;
import com.work.workhub.member.member.dto.MemberDTO;
import com.work.workhub.member.member.dto.MemberRoleDTO;
import com.work.workhub.member.member.dto.UserImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {
	
	private MemberMapper memberMapper;
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public MemberServiceImpl(MemberMapper memberMapper, PasswordEncoder passwordEncoder) {
		this.memberMapper = memberMapper;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		/* 우리가 정의한 타입으로 유저 조회 */
		MemberDTO member = memberMapper.findMemberById(username);
		
		/* null 값이 없게 하기 위해 조회 된 값이 없을 시 빈 객체 */
		if(member == null) member = new MemberDTO();
		log.info(member.toString());
		
		/* 권한 리스트 */
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		if(member != null && member.getMemberRoleList() != null) {
			
			for(MemberRoleDTO role : member.getMemberRoleList()) {
				AuthorityDTO authority = role.getAuthority();
				
				if(authority != null) {
					authorities.add(new SimpleGrantedAuthority(authority.getAuthName()));
				}
			}

		}
		
		/* User 객체에 담기지 않는 추가 정보를 User 객체를 extends한 UserImpl에 담아서 리턴한다. */
		UserImpl user = new UserImpl(member.getId(), member.getPwd(), authorities);
		user.setDetails(member);
		
		return user;
	}

	
	// =========================html 수정 중=========================
	// 이메일 발송
	@Override
	public int findPwCheck(MemberDTO memberDTO) throws Exception {
		return memberDTO.findPwCheck(memberDTO);
	}

	@Override
	public void findPw(String memberEmail, String memberId) throws Exception {

		
	}

	@Override
	public MemberDTO edit_info(MemberDTO member) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberDTO update_pw(MemberDTO member, String old_pw, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	

	// 회원정보 수정
	/*
	 * @Override public MemberDTO edit_info(MemberDTO member) throws Exception {
	 * manager.update_mypage(member); return manager.login(member.getId()); }
	 * 
	 * // 비밀번호 변경
	 * 
	 * @Override public MemberDTO update_pw(MemberDTO member, String old_pw,
	 * HttpServletResponse response) throws Exception {
	 * response.setContentType("text/html;charset=utf-8"); PrintWriter out =
	 * response.getWriter();
	 * if(!old_pw.equals(manager.login(member.getId()).getPw())) {
	 * out.println("<script>"); out.println("alert('기존 비밀번호가 다릅니다.');");
	 * out.println("history.go(-1);"); out.println("</script>"); out.close(); return
	 * null; }else { manager.update_pw(member); return
	 * manager.login(member.getId()); } }
	 */
}
