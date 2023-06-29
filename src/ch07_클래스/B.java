package ch07_클래스;

public class B {
	
//	반환x 매개변수x
	void test1() {
		System.out.println("test1 메소드 호출");
	}

//	반환(정수) 매개변수x
	int test2() {
		System.out.println("test2 메소드 호출");
		return 100;
	}
//	반환(논리) 매개변수x
	boolean test3() {
		System.out.println("test3 메소드 서비스를 실행합니다.");
		return test2() == 100;
		
	}
	
	void test4(String name, int age) {
		System.out.println("이름 : "+ name);
		System.out.println("나이 : "+ age);
	}	//메소드명과 변수명은 중복 불가
	
	void test4(int age, String name) {
		System.out.println("나의 이름 : "+ name);
		System.out.println("나의 나이 : " + age);
	}
	
}
