package kr.ch11.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserRequestDTO {  //json데이터를 받기 위한 클래스

	private String uid;
	private String pass;
}
