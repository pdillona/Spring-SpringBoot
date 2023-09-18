package sub1;

public class SamsungTv {

	private Speaker spk;
	
	
	public void power() {
		System.out.println("LgTv powerOn===================");
	}
	
	public void powerOff() {
		System.out.println("LgTv powerOff===================");
	}
	
	public void soundUp() {
		spk.soundUp();
	}
	
	public void soundDown() {
		spk.soundDown();
	}
	

	
}
