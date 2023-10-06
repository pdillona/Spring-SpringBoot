package kr.ch10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping(value = {"/","/index"})
	public String index() {
		
		
		return "/index";
	}
	
	@GetMapping("/index2")
	public String index2() {
		
		
		return "/index2";
	}
	
	@GetMapping("/index3")
	public String index3() {
		
		
		return "/index3";
	}
}
