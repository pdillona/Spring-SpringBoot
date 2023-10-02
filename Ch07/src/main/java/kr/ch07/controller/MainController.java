package kr.ch07.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.ch07.dto.User1DTO;
import lombok.extern.slf4j.Slf4j;


@Slf4j  // 로거 선언 (롬복)
@Controller
public class MainController {

	
	@GetMapping(value = {"/","/index"})
	public String index(Model model) {

		String str1 = "스프링부트";
		String str2 = "타임리프";
		
		//setter를 이용한 초기화
		User1DTO user1 = new User1DTO();
		
		user1.setUid("A101");
		user1.setName("김유신");
		user1.setHp("010-1234-1234");
		user1.setAge(24);
		
		//생성자를 이용한 초기화
		User1DTO user2 = new User1DTO("A102", "김춘추", "010-6464-7890",33);
		
		model.addAttribute("str1", str1);
		model.addAttribute("str2", str2);
		
		
		//builder를 이용한 초기화. boot에서 많이 사용하는 방법. 빌더를 호출하여 속성의 이름으로 정의된 메서드를 체이닝 방식으로 초기화
		User1DTO user3 = User1DTO.builder()
								.uid("A103")
								.name("장보고")
								.hp("010-1123-4456")
								.age(12)
								.build();
		
		User1DTO user4 = null;
		
		// List생성
		List<User1DTO> users = new ArrayList<>();
		users.add(new User1DTO("A101","김유신","010-1111-1222",22));
		users.add(new User1DTO("A102","김춘추","010-1111-1233",33));
		users.add(new User1DTO("A103","강감찬","010-1111-1244",44));
		users.add(new User1DTO("A104","장보고","010-1111-1255",55));
		users.add(new User1DTO("A105","이순신","010-1111-1266",66));
		
		
		
		
		model.addAttribute("str1",str1);
		model.addAttribute("str2",str2);
		model.addAttribute("user1",user1);
		model.addAttribute("user2",user2);
		model.addAttribute("user3",user3);
		model.addAttribute("user4",user4);
		model.addAttribute("users",users);
		
		
		log.info(user1.toString());
		log.info(user2.toString());
		log.info(user3.toString());
		
		
		return "/index";
	}
	
	@GetMapping("/include")
	public String include() {
		return "/include";
	}

	@GetMapping("/layout")
	public String layout() {
		return "/layout";
	}
	
}
