package kr.Test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.Test.Mapper.User6Mapper;
import kr.Test.dto.User6DTO;
import lombok.extern.slf4j.Slf4j;



@Slf4j
@Service
public class User6Service {

	@Autowired
	User6Mapper user6Mapper;
	
	
	public void insertUser6(User6DTO dto) {
		
		log.info("insertservice: "+ dto.getGender());
		
		if(dto.getGender().equals("남")) {
			dto.setGender("M");
		}else {
			dto.setGender("F");
		}
		
		log.info("insertservice: "+ dto.getGender());
		
		user6Mapper.insertUser6(dto);
	};
	public User6DTO selectUser6(String uid) {
		
		return user6Mapper.selectUser6(uid);
	};
	public List<User6DTO> selectUser6s(){
		
		
		
		return user6Mapper.selectUser6s();
	};
	public void updateUser6(User6DTO dto) {
		user6Mapper.updateUser6(dto);
	};
	public void deleteUser6(String uid) {
		user6Mapper.deleteUser6(uid);
	}
	;
	
	
	
}
