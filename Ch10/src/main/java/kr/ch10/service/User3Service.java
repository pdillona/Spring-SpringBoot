package kr.ch10.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ch10.controller.repository.User3Repository;
import kr.ch10.dto.User3DTO;
import kr.ch10.entity.User2Entity;
import kr.ch10.entity.User3Entity;

@Service
public class User3Service {

	@Autowired
	private User3Repository repo;
	
	
	public void insertUser3(User3DTO dto) {
		// DTO 를 entity로 변환
		User3Entity entity = dto.toEntity();
		
		repo.save(entity);
	}
	
	public User3DTO selectUser3(String id) {
		
		Optional<User3Entity> result = repo.findById(id);
		
		User3DTO entity = result.get().toDTO();
		
		return entity;
	}
	
	public List<User3DTO> selectUser3s() {
		
		//List<Entity>를 List<DTO>로 변환해서 리턴
		return repo.findAll()
						.stream()
						.map(entity -> User3DTO.builder()
										.id(entity.getId())
										.name(entity.getName())
										.hp(entity.getHp())
										.age(entity.getAge())
										.build())
						.collect(Collectors.toList());
						
	}
	
	public void updateUser3(User3DTO dto) {
		//DTO를 Entity로 변환
		User3Entity entity = dto.toEntity();
		// findById를 통해 데이터를 검색해보고 있을 때 update 없으면 redirect 시키거나 아예 뷰단에서 막는 등의 데이터를 정확히 들어오게 하는법 밖에 없음 
		
		
		repo.save(entity);
	}
	
	public void deleteUser3(String id) {
		
		repo.deleteById(id);
	}
	
}
