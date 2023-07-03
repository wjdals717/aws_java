package ch17_추상;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data

public abstract class SmartDevice {
	private String deviceName;
	private double displaySize;
	
	public abstract void connectedWifi();
//	메소드는 구현부분이 존재해야 하지만
//	추상 메소드는 존재하지 않음
//	호출하려면 구체화가 필요함 -> 상속을 받아서 오버라이드(재정의)를 해야 함
}
