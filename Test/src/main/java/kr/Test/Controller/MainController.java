package kr.Test.Controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.Test.dto.User6DTO;
import kr.Test.service.User6Service;
import lombok.extern.slf4j.Slf4j;


@Slf4j  // 로거 선언 (롬복)
@Controller
public class MainController {

	@Autowired
	User6Service service;
	
	
	@GetMapping(value = {"/","/index"})
	public String index(Model model) {
		
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
	
	
	
	@GetMapping("/main_index")
	public String main_index() {
		
		
		return "/main_index";
	}
	
	
	@PostMapping("/main_index")
	public String register(User6DTO dto) {
		log.info("레지스터 dto 투스트링"+dto.toString());
		
		service.insertUser6(dto);
		

		log.info("레지스터 dto 투스트링"+dto.toString());
		
		return "redirect:/main_index";
		
	}
	
	
	
	@GetMapping("/modify")
	public String modify() {
		return "/modify";
	}
	
	
	@GetMapping("/list")
	public String list(Model model) {
		
		service.selectUser6s();
		
		model.addAttribute("Users", model);
		
		
		return "/list";
	}
	
}
