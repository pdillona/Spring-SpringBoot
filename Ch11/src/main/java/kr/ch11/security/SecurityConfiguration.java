package kr.ch11.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import kr.ch11.jwt.JwtAuthenticationFilter;
import kr.ch11.jwt.JwtProvider;

@Configuration
public class SecurityConfiguration {

	@Autowired
	private SecurityUserService service;
	
	@Autowired
	private JwtProvider jwtProvider;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		
		http
		// 사이트 위변조 방지해제
		.csrf(CsrfConfigurer::disable)   // csrf 보안설정   (CsrfConfigurer::disable)는 보안설정을 해제 하는 설정
		// 기본 http 인증방식 비활성화
		.httpBasic(HttpBasicConfigurer::disable)  // :: 란 메서드 참조연산자 람다식을 간단히 표현한 방법.
		// 토큰 방식으로 로그인 처리하기 때문에 폼방식 비활성화 (즉 세션을 사용하지 않음)
		.formLogin(FormLoginConfigurer::disable)	// jwt는 json으로 데이터가 넘어와서 기존의 form 데이터가 아니라 해제 해야함
		// 토큰 기반 인증 방식이기 때문에 세션을 사용하지 않음 (실제 운영방식은 토큰과 세션을 동시에 사용하는 방식으로 사용) 
		.sessionManagement(config -> config.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		// 토큰 검사 필터 설정
		.addFilterBefore(new JwtAuthenticationFilter(jwtProvider), UsernamePasswordAuthenticationFilter.class) // 시큐리티 인증처리 필터인 UsernamePasswordAuthenticationFilter 앞에 JwtAuthenticationFilter를 둔다는 의미
		// 인가 권한 설정
		.authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests               
								.requestMatchers("/admin/**").hasAnyAuthority("ADMIN")				//admin에대한 요청은 ADMIN만 허가
								.requestMatchers("/manager/**").hasAnyAuthority("ADMIN","MANAGER")	//manager에대한 요청은 ADMIN, MANAGER만 허가
								.requestMatchers("/user/**").permitAll()							//user에대한 요청은 전부 허가
								.anyRequest().permitAll()											//모든요청 전부 허가.
				); // 인가설정 
		
	

		
		
		
		return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		
		return config.getAuthenticationManager();
	}
	
	
}