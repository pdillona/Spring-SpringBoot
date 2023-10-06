package kr.ch09.security;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@Builder
@ToString
public class MyUserDetails implements UserDetails{


	private static final long serialVersionUID = 1066540475632524961L;
	
	private String uid;
	private String pass;
	private String name;
	private String role;
	private String hp;
	private int age;
	private LocalDateTime regDate;
	
	
	//사용자 권한을 가져옴
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// 계정이 갖는 권한 목록
		// 반드시 접두어로 ROLE_입력 해야함 그래야 hasRole(), hasAnyRole() 메서드가 처리됨.
		// 만약 ROLE_ 접두어를 안쓰면 hasAuthority(), hasAnyAuthority() 메서드로 해야함.
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_"+role));
		
		return authorities;
	}

	@Override
	public String getPassword() {
		// 계정이 갖는 비밀번호
		
		
		return pass;
	}

	@Override
	public String getUsername() {
		// 계정이 갖는 아이디 (이름 아님)
		
		
		return uid;
	}

	@Override
	public boolean isAccountNonExpired() {
		// 계정 만료 여부(true: 만료 되지 않음, false: 만료 됨)
		
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// 계정 잠김 여부(true: 잠기지 않음, false: 잠김)
		
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// 계정 비밀 번호 만료 여부(true: 만료 되지 않음, false: 만료 됨) 일정 개월마다 비밀번호를 변경해야 하기때문에 비밀번호도 만료일을 설정 해야함
		
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		// 계정 활성화 여부(true: 활성화, false: 비활성화) Lock과는 조금 다른 역할(알아보기)
		
		
		return true;
	}

	
	
	
}
