package ch18_빌더;

public class UserTest {
	public static void printUser() {
		System.out.println("사용자 정보 출력");
		(new UserTest()).test();		//test()를 사용할 수 있는 방법
//		(new UserTest()).new UserTestTest().testTest();
		new UserTestTest();
		new UserTest.UserTestTest();
	}
	
	public void test() {
		System.out.println("테스트 메소드 호출");
	}
	
	public static class UserTestTest {
		public void testTest() {
			System.out.println("테스트테스트 메소드 호출");
		}
	}
}
