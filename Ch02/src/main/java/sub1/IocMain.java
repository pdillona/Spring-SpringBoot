package sub1;
/*
 * 날짜: 2023/09/18
 * 이름: 정영재
 * 내용: Spring IoC 실습하기
 * 
 * 
 * IoC
 *  - Inversion of Control(제어의 역전) 의미로 객체의 생성, 소멸 등의 관리를 컨테이너 에서 담당.
 *  - 일반적으로 컨테이너는 IoC 컨테이너 즉 Spring Container를 말함 
 * 
 * */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class IocMain {

	public static void main(String[] args) {
		
		
		//스프링 컨텍스트(컨테이너) 객체 생성
		ApplicationContext ctx = new GenericXmlApplicationContext("application.xml");
		
		LgTv lg = (LgTv) ctx.getBean("lg");
		lg.power();
		lg.powerOff();
		lg.soundUp();
		lg.soundDown();
		
		
		//SamsungTv ss = (SamsungTv) ctx.getBean("samsung");
		
	}
	
}
