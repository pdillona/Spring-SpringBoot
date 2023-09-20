package ch03.sub3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch03.sub2.LogAdvice;

@Component("service2")
public class Service {


	public void insert() {
		System.out.println("core corecern - insert.........");
	}
	
	public void select() {
		System.out.println("core corencern - select.........");
	}
	
	public void update(int no) {
		System.out.println("core corencern - update.........");
	}
	
	public void delete(int no, String name) {
		System.out.println("core corencern - delete.........");
	}
}
