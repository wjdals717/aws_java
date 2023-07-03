package ch14_싱글톤;

public class SamsungFactory {
	/*
	private Samsung samsung;
	
	public SamsungFactory(Samsung samsung) {
		this.samsung = samsung;
	}
	*/
	public Galaxy produce(String model) {
		System.out.println(Samsung.getInstance().getCompanyName() + "에서 스마튼폰을 생산합니다.");
		int newSerialNumber = Samsung.getInstance().getAutoIncrementSerialNumber() + 1;
		Samsung.getInstance().setAutoIncrementSerialNumber(newSerialNumber);
		return new Galaxy(newSerialNumber, model);	//갤럭시 객체를 반환해 줌(주소를 반환)
	}
	
	public void getCompanyName() {
		System.out.println("회사명: " +Samsung.getInstance().getCompanyName());
	}
	
}
