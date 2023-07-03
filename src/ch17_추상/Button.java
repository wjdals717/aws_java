package ch17_추상;

public interface Button {
	public int buttonCount = 4;	//스태틱 상수, 일반 변수를 사용할 수 없음
	
	public void powerOn();
	public void powerOff();
	public void volumeUp();
	public void volumeDown();
	
}
