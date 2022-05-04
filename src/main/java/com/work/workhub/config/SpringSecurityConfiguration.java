package com.work.workhub.config;


import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/* 스프링 시큐리티 설정 활성화 + bean 등록 가능 */
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {



	/* 암호화에 사용할 객체 BCryptPasswordEncoder bean 등록 - ContextConfiguration */
	
	/* 정적 리소스는 권한이 없어도 요청 가능하게 무시할 경로를 작성한다 */
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**", "/js/**", "/images/**");
	}

	/* HTTP 요청에 대한 설정 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			/* CSRF(Cross-Site Request Forgery)
			 * 웹 애플리케이션 취약점 중 하나로 사용자의 의지와 무관하게 공격자가 의도한 행위(등록/수정/삭제)를 
			 * 특정 웹 사이트에 요청하도록 만드는 공격 
			 * 
			 * CSRF 공격 방어를 위해 referrer 검증 -> 요청 도메인이 일치하는지 검증
			 * Spring Security CSRF Token 사용 
			 * -> 임의의 토큰 발급 후 자원에 대한 변경 요청일 경우 Token 확인하여 클라이언트가 정상적인 요청을 보낸 것인지 확인
			 * 만약 CSRF Token이 존재하지 않거나 기존의 Token과 일치하지 않는 경우 4XX 상태 코드를 반환
			 * */
			.csrf().disable()	/* csrf는 기본적으로 활성화 되어 있으므로 비활성화 처리 */
			/* 요청에 대한 권한 체크 */
			.authorizeHttpRequests()
				.anyRequest().permitAll();
		
	}


	
	
}
