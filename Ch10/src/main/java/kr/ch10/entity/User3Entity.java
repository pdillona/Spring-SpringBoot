package kr.ch10.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.ch10.dto.User3DTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

// @data나 @setter를 정의하지 않는 이유는 entity 는 db 테이블과 mapping이 되어 있기 때문에 실제 칼럼값만이 존재 해야함
// 즉 불변 객체로 정의 하는 것을 권장 하기에 setter로 값이 들어오는 것을 방지 하고자 setter를 제거한다.
@Getter   
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name="USER3")
public class User3Entity {

	@Id
	private String id;
	private String name;
	private String hp;
	private int age;
	
	
	
	// DTO 변환 메서드
	public User3DTO toDTO() {
		
		return User3DTO.builder()
				.id(id)
				.name(name)
				.hp(hp)
				.age(age)
				.build();
	}
	
}
