package ch17_추상;

public class TestB implements TestA {
	@Override
	public void test() {
		System.out.println("재정의해서 쓸 거임!!!!!!");
	}
}
