package exam;

public class Factory {
	private static Factory instance;
	
	private String factoryName;
	
	public static Factory getInstance() {
		if(instance == null) {
			instance = new Factory(); //객체 생성
		}
		return instance;       //비어있지 않으면 이전에 만든 객체 반환
	}
}
