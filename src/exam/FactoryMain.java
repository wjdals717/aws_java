package exam;

class Factory{
	private 
}

public class FactoryMain {
	private static FactoryMain instance;
	
	private String factoryName;
	private FactoryMain() { }
	
	public static FactoryMain getInstance() {
		if(instance == null) {
			instance = new FactoryMain(); //객체 생성
		}
		return instance;       //비어있지 않으면 이전에 만든 객체 반환
	}
}
