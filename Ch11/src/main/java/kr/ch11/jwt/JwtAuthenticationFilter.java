package kr.ch11.jwt;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Log4j2
@RequiredArgsConstructor
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{ // OncePerRequestFilter는 모든요청에 한번만 수행되는 필터

	@Autowired
	private final JwtProvider jwtProvider;
	
	public static final String AUTH_HEADER = "Authorization";
	public static final String TOKEN_PREFIX = "Bearer";
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		log.info("JwtAuthenticationFilter......1");
		
		String header = request.getHeader(AUTH_HEADER);
		log.info("JwtAuthenticationFilter......2: " + header);
		
		String token = getTokenFromHeader(header);
		log.info("JwtAuthenticationFilter......3: " + token);
		
		if(token != null && jwtProvider.validateToken(token)) {
			log.info("JwtAuthenticationFilter......4 성공시 일로 들어와서 다음 필터로 넘어가야 한다.");
			
			// Security 인증처리 시큐리티가 처리하는 세션을 컨텍스트라함
			Authentication atuthetication = jwtProvider.getAuthentication(token);
			SecurityContextHolder.getContext().setAuthentication(atuthetication);
		}

		// 다음 필터 이동
		filterChain.doFilter(request, response);   
	}  

	public String getTokenFromHeader(String header) {
		
		if(header != null && header.startsWith(TOKEN_PREFIX)) {
			return header.substring(TOKEN_PREFIX.length());
		}
		
		return null;
	}
}
