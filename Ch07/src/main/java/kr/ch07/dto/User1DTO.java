package kr.ch07.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


//@Data  // data로 위의 것들을 동시에 사용가능 (조금다름)
@Getter		//겟터 생성
@Setter		//셋터 생성
@ToString	//투스트링 생성
@AllArgsConstructor // 모든 필드를 매개변수를 갖는 생성자. 걍 uid,name,hp,age가 다 직접 매개변수와 this.uid~~로 되있는거
@NoArgsConstructor // default생성자 즉 매개변수 필드 다 빈거
@Builder
public class User1DTO {

	private String uid;
	private String name;
	private String hp;
	private int age;
	
	

	
	
}
