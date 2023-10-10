package kr.ch11.controller;

import java.util.Map;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.ch11.dto.UserRequestDTO;
import kr.ch11.entity.UserEntity;
import kr.ch11.jwt.JwtProvider;
import kr.ch11.security.MyUserDetails;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // 생성자 어노테이션 (autowired가 많을 때 final을 붙여 사용한다.)
@RestController   // 화면이 아닌 데이터를 출력해주는 컨트롤어
public class UserController {

	/*
	 * @Autowired private AuthenticationManager autenticationManager;
	 * 
	 * @Autowired private JwtProvider jwtProvider;
	 */
	

	 private final AuthenticationManager autenticationManager;
	 private final JwtProvider jwtProvider;
	 
	 @PostMapping("/login")
	 public Map<String, String> login(@RequestBody UserRequestDTO dto) {  //String uid, String pass json으로 들어와서 이처럼 받는건 불가, json으로 들어오는 데이터는 @RequestBody로 받아줘야함.

		 try {
			UsernamePasswordAuthenticationToken authenticationToken
				= new UsernamePasswordAuthenticationToken(dto.getUid(), dto.getPass());
			
			Authentication authentication = autenticationManager.authenticate(authenticationToken);
			MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
			 
			UserEntity user = userDetails.getUser();
			
			
			// 토큰 발행
			String accessToken = jwtProvider.createToken(user, 1);	// 1일
			String refreshToken = jwtProvider.createToken(user, 7); // 7일
			
			Map<String, String> resultMap = Map.of("grantType", "Bearer", 
													"accessToken", accessToken, 
													"refreshToken", refreshToken);
			
			return resultMap;
			
		} catch (Exception e) {
			Map<String, String> resultMap = Map.of("grantType", "None",
													"message", e.getMessage());
			return resultMap;
		}
		 
	 }
	 
	 
	 
}
