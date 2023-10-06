package kr.ch10.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ch10.entity.User1Entity;
import kr.ch10.service.User1Service;

@Controller
public class User1Controller {

	//요청 주소가 같아도 rest api의 어노테이션을 통해 다른 요청을 알아서 해준다.
	
	@Autowired
	private User1Service service;
	
	@ResponseBody //요청 메서드의 리턴값을 json 데이터로 변환해서 클라이언트에 응답해 준다.
	@GetMapping("/user1")
	public List<User1Entity> list() {
		
		List<User1Entity> user1s = service.selectUser1s();
		
		
		//rest api 에서는 화면을 넘기는게 아니라 json 데이터를 넘김
		return user1s;
	}
	
	@ResponseBody
	@GetMapping("/user1/{id}") //mapping에 파라메타 값을 {}안에 받고자 하는 파라메타 컬럼을 명시해서 받아준다.
	public User1Entity user1(@PathVariable("id") String id) {
		
		
		return service.selectUser1(id);
		
	}
	
	// 리스폰스 바디 안붙이면 에러뜸 콘솔에 하지만 기능은 제대로 작동됨 jquery.min.js:2     DELETE http://localhost:8080/Ch10/user1/s101 500 (Internal Server Error)
	@ResponseBody
	@PostMapping("/user1")
	public void register(User1Entity user1) {
		service.insertUser1(user1);
	}
	
	@ResponseBody
	@PutMapping("/user1")
	public void modify(User1Entity user1) {
		
		service.updateUser1(user1);
	}
	
	@ResponseBody
	@DeleteMapping("/user1/{id}")
	public void delete(@PathVariable("id") String id) {
		service.deleteUser1(id);
	}
	 
}
