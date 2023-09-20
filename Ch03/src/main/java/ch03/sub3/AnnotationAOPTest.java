package ch03.sub3;
/*
 * 날짜: 2023/09/19
 * 이름: 정영재
 * 내용: 어노테이션 기반 AOP실습
 * 
 * */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class AnnotationAOPTest {

	public static void main(String[] args) {
		//스프링 컨텍스트 객체 생성(컨테이너)
		ApplicationContext ctx = new GenericXmlApplicationContext("application.xml");
		
		//service 객체 가져오기
		Service service = (Service) ctx.getBean("service2");
		
		service.insert();
		service.select();
		service.update(1);
		service.delete(1,"s");
	}
	
}
