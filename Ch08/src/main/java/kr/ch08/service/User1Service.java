package kr.ch08.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ch08.dto.User1DTO;
import kr.ch08.entity.User1Entity;
import kr.ch08.repository.User1Repository;

@Service
public class User1Service {
	
	@Autowired
	private User1Repository repo;

	public void insertUser1(User1DTO dto) {
		//controller 에서는 service로 dto가 넘어가야 하지만 service에서 repository로 entity가 넘어가야 한다. 즉 dto로 들어온 데이터를 entity로 변환해야 한다.
		//DTO를 Entity로 변환
		User1Entity entity = dto.toEntity();
		
		repo.save(entity);
	}
	
	public User1DTO selectUser1(String uid) {
		
		Optional<User1Entity> result = repo.findById(uid);
		//findById =  select * from where uid = uid; 와 같다.
		//Optional 이란 null값의 처리를 쉽게 해주는 자료형
		// .get()이 붙어야 user1dto로 리턴된다. 그냥 result는 에러
		
		//Entity를 dto로 변환
		User1DTO dto = result.get().toDTO();
		
		return dto;
	}
	
	public List<User1DTO> selectUser1s() {
		
		
		//List<Entity>를 List<dto>로 변환
		List<User1DTO> list = repo.findAll()
									.stream()
									.map(entity -> User1DTO.builder()         //findAll로 user1entity의 리스트를 찾고 stream을 통해 rs.next while로 꺼내지 않고 가공 처리 가능 map()으로 이를 일괄 처리 map이 실질적인 while문에 해당한다.
															.uid(entity.getUid())
															.name(entity.getName())
															.hp(entity.getHp())
															.age(entity.getAge())
															.build())
									.collect(Collectors.toList());  
		
		
		return list;
	}
	
	public void updateUser1(User1DTO dto) {
		
		User1Entity entity = dto.toEntity();
		
		repo.save(entity);   //insert와 update 모두 save()를 사용하는데 어떻게 구분할까? 바로 매개변수의 유무로 체크가 된다. 전달된 dto의 pk값이이 이미 존재한다면 update 없다면 insert로 작동 한다.
	}
	
	public void deleteUser1(String uid) {
		repo.deleteById(uid);
		
		
	}
	
}
