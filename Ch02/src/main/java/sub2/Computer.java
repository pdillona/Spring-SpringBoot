package sub2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


//ioc 컨테이너에 들어가는 객체명은 소문자 클래스명이다. 즉 computer로 들어감 
//단 ()내부에 직접 객체명 설정 가능
@Component("com")
public class Computer {

	private CPU cpu;
	private RAM ram;
	
	/*di의 세가지 방식 필드 방식, 생성자 방식, 필드 방식*/
	
	//DI - Field Inject
	@Autowired
	private HDD hdd;
	
	//DI - Constructor Inject 생성자 인젝션
	@Autowired
	public Computer(CPU cpu) {
		this.cpu = cpu;
	}
	
	//set (=초기화 X 값을 바꿔주는 간접적 방법 초기화는 생성자가 담당함.)
	// ID - Setter inject
	@Autowired
	public void setRam(RAM ram) {
		this.ram = ram;
	}
	

	
	
	public void show() {
		cpu.show();
		ram.show();
		hdd.show();
	}
	
}
