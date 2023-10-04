package kr.ch07.mapper;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.ch07.dao.User6Mapper;
import kr.ch07.dto.User6DTO;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class User6MapperTest {

	@Autowired
	private User6Mapper mapper;

	//@Test
	public void insertUser() {
		User6DTO user1 = User6DTO.builder()
								.uid("t101")
								.name("테스트")
								.birth("1980-12-12")
								.gender("M")
								.age(80)
								.addr("대구")
								.hp("010-1234-5678")
								.build();
		
		mapper.insertUser(user1);
	}
	
	//@Test
	public void selectUsers() {
		List<User6DTO> users = mapper.selectUsers();
		
		for(User6DTO user : users) {
			log.info("user : " + user);
		}
		
	}
	
	//@Test
	public void updateUser() {
		User6DTO user1 = User6DTO.builder()
				.uid("t101")
				.name("업데이트")
				.birth("1980-12-12")
				.gender("F")
				.age(80)
				.addr("서울")
				.hp("010-0000-1111")
				.build();

		mapper.updateUser(user1);
	}
	
	@Test
	public void deleteUser() {
		String user1 = "t101";
		mapper.deleteUser(user1);
	}
}
