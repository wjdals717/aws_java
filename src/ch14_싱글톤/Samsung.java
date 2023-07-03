package ch14_싱글톤;

import java.time.LocalDate;

public class Samsung {
	private static Samsung instance;
	
	private String companyName;
	private int autoIncrementSerialNumber = LocalDate.now().getYear() * 10000;
	
	private Samsung() {
//		companyName = "SAMSUNG";
		companyName = Samsung.class.getSimpleName().toUpperCase();
	}
	
	public static Samsung getInstance() {
		if(instance == null) {			//처음 1번만 삼성 객체 생성가능 => 싱글톤
			instance = new Samsung();
		}
		return instance;
	}
	
	public int getAutoIncrementSerialNumber() {
		return autoIncrementSerialNumber;
	}
	public void setAutoIncrementSerialNumber(int autoIncrementSerialNumber) {
		this.autoIncrementSerialNumber = autoIncrementSerialNumber;
	}
	public String getCompanyName() {
		return companyName;
	}
	
	
}
