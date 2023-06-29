package ch07_클래스;

public class AMain {
	public static void main(String[] args) {
		A a = new A();
		System.out.println(a);
		System.out.println(a.num1);
		a.num1 = 10;
		System.out.println(a.num1);
		a.num2 = 20;
		System.out.println(a.num2);
		
		A a2 = new A();
		System.out.println(a);
		a2.num1 = 100;
		System.out.println(a.num1 + a2.num1);
		
		a.test();
		a.test2(1, 2);
		a.test3();			//메모리 공간이 분리되어이 있는 것을 확인할 수 있음
		a2.test3();
	}
}
