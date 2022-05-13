package com.work.workhub.member.member.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
//	@Override
//	public void send_mail(MemberDTO member, String div) throws Exception {
//		// Mail Server 설정
//		String charSet = "utf-8";
//		String hostSMTP = "smtp.naver.com";
//		String hostSMTPid = "이메일 입력";
//		String hostSMTPpwd = "비밀번호 입력";
//
//		// 보내는 사람 EMail, 제목, 내용
//		String fromEmail = "이메일 입력";
//		String fromName = "Spring Homepage";
//		String subject = "";
//		String msg = "";
//		
//		if(div.equals("join")) {
//			// 회원가입 메일 내용
//			subject = "Spring Homepage 회원가입 인증 메일입니다.";
//			msg += "<div align='center' style='border:1px solid black; font-family:verdana'>";
//			msg += "<h3 style='color: blue;'>";
//			msg += member.getId() + "님 회원가입을 환영합니다.</h3>";
//			msg += "<div style='font-size: 130%'>";
//			msg += "하단의 인증 버튼 클릭 시 정상적으로 회원가입이 완료됩니다.</div><br/>";
//			msg += "<form method='post' action='http://localhost:8081/homepage/member/approval_member.do'>";
//			msg += "<input type='hidden' name='email' value='" + member.getEmail() + "'>";
//			msg += "<input type='hidden' name='approval_key' value='" + member.getApproval_key() + "'>";
//			msg += "<input type='submit' value='인증'></form><br/></div>";
//		}else if(div.equals("find_pw")) {
//			subject = "Spring Homepage 임시 비밀번호 입니다.";
//			msg += "<div align='center' style='border:1px solid black; font-family:verdana'>";
//			msg += "<h3 style='color: blue;'>";
//			msg += member.getId() + "님의 임시 비밀번호 입니다. 비밀번호를 변경하여 사용하세요.</h3>";
//			msg += "<p>임시 비밀번호 : ";
//			msg += member.getPw() + "</p></div>";
//		}
//		// 받는 사람 E-Mail 주소
//		String mail = member.getEmail();
//		try {
//			HtmlEmail email = new HtmlEmail();
//			email.setDebug(true);
//			email.setCharset(charSet);
//			email.setSSL(true);
//			email.setHostName(hostSMTP);
//			email.setSmtpPort(587);
//
//			email.setAuthentication(hostSMTPid, hostSMTPpwd);
//			email.setTLS(true);
//			email.addTo(mail, charSet);
//			email.setFrom(fromEmail, fromName, charSet);
//			email.setSubject(subject);
//			email.setHtmlMsg(msg);
//			email.send();
//		} catch (Exception e) {
//			System.out.println("메일발송 실패 : " + e);
//		}
//	}

}
