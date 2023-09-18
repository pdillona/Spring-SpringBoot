package sub1;

import org.springframework.beans.factory.annotation.Autowired;

public class LgTv {

	@Autowired
	private Speaker spk;
	
	
	public void power() {
		System.out.println("SamsungTv powerOn===================");
	}
	
	public void powerOff() {
		System.out.println("SamsungTv powerOff===================");
	}
	
	public void soundUp() {
		spk.soundUp();
	}
	
	public void soundDown() {
		spk.soundDown();
	}
	

	
}
