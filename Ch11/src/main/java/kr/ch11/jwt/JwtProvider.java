package kr.ch11.jwt;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SecurityException;
import kr.ch11.entity.UserEntity;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Getter
@Component
public class JwtProvider {

	
	private String issuer;
	private SecretKey secretKey;
	
	public JwtProvider(@Value("${jwt.issuer}") String issuer,@Value("${jwt.secret}")  String secret) {  // @Value 로 프로퍼티의 설정값을 가져옴
		
		this.issuer = issuer;
		this.secretKey = Keys.hmacShaKeyFor(secret.getBytes());  // 시크릿 객체로 변환
		
	}
	
	public String createToken(UserEntity user, int days) {
		
		// 발급일, 만료일 생성
		Date issuedDate = new Date();
		Date expireDate = new Date(issuedDate.getTime() + Duration.ofDays(days).toMillis());
		
		// 클레임 생성 (토큰에는 사용자의 정보가 최소한으로 제공 되어야 한다.)
		Claims clamis = Jwts.claims();
		clamis.put("uid", user.getUid());
		clamis.put("role", user.getRole());
		
		// 토큰 생성
		String token = Jwts.builder()										  // 빌더 방식은 객체 생성 방식을 의미함 new와 같은 의미 해당 클래스의 속성들을 멤버변수들의 이름으로 초기화
						.setHeaderParam(Header.TYPE, Header.JWT_TYPE)    
						.setIssuer(issuer)
						.setIssuedAt(issuedDate)
						.setExpiration(expireDate)
						.addClaims(clamis)
						.signWith(secretKey, SignatureAlgorithm.HS256)
						.compact();
		
		return token;
	}
	
	public Authentication getAuthentication(String token) {
		
		Claims claims = getClaims(token);
		String uid = (String) claims.get("uid");
		String role = (String) claims.get("role");
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_"+role));
		
		User principal = new User(uid, "", authorities);
		
		
		return new UsernamePasswordAuthenticationToken(principal, token, authorities);
	}
	
	// 토큰 검사 메서드 (토큰 만료시 또는 토큰의 외부로부터의 변조에 관한 검사 메서드)
	public boolean validateToken(String token) {
		
		try {
			
			Jwts.parserBuilder()
				.setSigningKey(secretKey)
				.build()
				.parseClaimsJws(token);
			
			return true;
			
		} catch (SecurityException | MalformedJwtException e) {
			log.info("잘못된 JWT서명 입니다.");
		} catch (ExpiredJwtException e) {
		log.info("만료된 JWT토큰 입니다.");
		} catch (UnsupportedJwtException e) {
			log.info("지원 되지 않는 JWT토큰 입니다.");
		} catch (IllegalArgumentException e) {
			log.info("JWT토큰이 잘못 되었 습니다.");
		}

		
		
		return false;
	}
	
	// 토큰정보  (토큰의 내용을 클레임 이라고함.)
	public Claims getClaims(String token) {
		
		return Jwts.parserBuilder()
					.setSigningKey(secretKey)
					.build()
					.parseClaimsJws(token)
					.getBody();
	}
	
	
	
}
