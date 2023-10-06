package kr.ch10.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ch10.controller.repository.User2Repository;
import kr.ch10.entity.User1Entity;
import kr.ch10.entity.User2Entity;

@Service
public class User2Service {

	@Autowired
	private User2Repository repo;
	
	
	public void insertUser2(User2Entity user1) {
		repo.save(user1);
	}
	
	public User2Entity selectUser2(String id) {
		return repo.findById(id).get();
	}
	
	public List<User2Entity> selectUser2s() {
		return repo.findAll();
	}
	
	public void updateUser2(User2Entity user1) {
		repo.save(user1);
	}
	
	public void deleteUser2(String id) {
		
		repo.deleteById(id);
	}
	
}
