package sub2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 * 날짜: 2023/09/18
 * 이름: 정영재
 * 내용: Spring 컨테이너 실습하기
 * 
 * DI
 *  - DI: Dependency Injection은 의존성 주입 의미로 객체를 생성하는 방식이 아닌 컨테이너로 부터 주입받는 방식.
 *  - 생성자, 세터, 필드 3가지 주입 방식.
 *  - @Component 선언으로 객체를 컨테이너에 관리 등록한다.
 *  - @Component는 @Controller, @Service, @Repository로 세분화.
 * */



public class SpringContainerTest {


	public static void main(String[] args) {
		
		ApplicationContext ctx = new GenericXmlApplicationContext("application.xml");
		
		Computer com = (Computer) ctx.getBean("com"); //component 어노테이션에 com으로 네이밍 했기 때문에 네이밍 안했따면 computer가 됬을것.
		com.show();
	}
	
}
