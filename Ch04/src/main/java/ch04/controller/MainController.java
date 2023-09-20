package ch04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

	
	//컨트롤러에서 핸들러 어뎁터로 모델 데이터를 리턴하는데 뷰 이름이 리턴되기에 메서드명과 리턴이 index이다. 그 이후 디스패쳐 서블릿으로 갔다가 뷰리졸버로 가서 뷰리졸버 설정대로 prefix, suffix를 붙여 반환 한다.
	@RequestMapping(value = {"/","/index"}, method = RequestMethod.GET) //value는 주소값 method는 요청 종류
	public String index() {
		
		return "index";
	}
	//최종적으로 view == index()    주소 "/index"  템플릿 return index 이름을 맞춰야 한다.
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		
		return "hello";
	}
	
	@RequestMapping("/greeting")
	public String greeting() {
		
		return "greeting";
	}
	
	@RequestMapping("/welcome")
	public String welcome() {
		
		return "welcome";
	}
	
	@GetMapping("/redirect")
	public String redirect() {
		//resp.sedRedirect(~);로 하던걸 redirect: ~~로 작성한다.
		
		
		return "redirect:/annotation/param";
	}
	
	@GetMapping("/forward")
	public String forward() {
		
		//forward와 reodirect 모두 contextroot가 빠진다.
		
		return "forward:/annotation/model";
	}
	
	
	
}
