package sub1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMain {

	public static void main(String[] args) {

		ApplicationContext ctx = new GenericXmlApplicationContext("application.xml");
		
		if(ctx != null) {
			
			Hello hello = (Hello) ctx.getBean("hello"); //hello객체 가져오기
			Welcome welcome = (Welcome) ctx.getBean("welcome"); //welcome객체 가져오기
			Greeting greeting = (Greeting) ctx.getBean("greeting"); //greeting객체 가져오기
			
			
			
			
			hello.show();
			welcome.show();
			greeting.show();
			
		}
		
		
	}

}
