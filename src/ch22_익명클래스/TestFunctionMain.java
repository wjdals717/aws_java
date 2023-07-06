package ch22_익명클래스;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class TestFunctionMain {
	public static void main(String[] args) {
//		TestFunctional1 function1 = () -> {
//			System.out.println("매개변수 X, 리턴 X");
//		};
//		명령문이 하나인 경우 중괄호 { }를 생략할 수 있다
//		TestFunction1 function1 = () -> System.out.println("매개변수 X, 리턴 X");
//		function1.test();
		
//		매개변수는 타입을 생략할 수 있다.그리고 매개변수가 하나인 경우 괄호()도 생략 가능하다.
		TestFunction2 function2 = (int num) -> {
			System.out.println("매개변수 1개, 리턴 X");
			System.out.println("num: " + num);
		};
		function2.test(100);
		
//		매개변수가 없거나 두 개 이상일 경우에는 매개변수의 괄호를 생략할 수 없다.
		TestFunction3 function3 = (age, name)-> {
			System.out.println("매개변수 2개, 리턴 X");
			System.out.println("나이: " + age);
			System.out.println("이름: " + name);
		};
		function3.test(30, "김준일");
		/*
		TestFunction4 function4 = (age, name)-> {
			System.out.println("매개변수 2개, 리턴 O");
			return "나이: " + age + ", 이름: " + name;
		};*/
		//명령이 한 줄이 경우 중괄호를 생략할 수 있으며 중괄호를 생략한 경우 즉시 리턴값이 된다.
		TestFunction4 function4 = (age, name) -> "나이: " + age + ", 이름: " + name;
		
		String result1 = function4.test(30, "김준일");
		System.out.println(result1);
		
		Runnable runnable = () -> {
			System.out.println("매개변수 X, 리턴 X");
		};
		runnable.run();
		
		Consumer<String> consumerStr = name -> {
			System.out.println(name);
		};
		consumerStr.accept("김준일");
		
		BiConsumer<String, Integer> biConsumer = (name, age) -> {
			System.out.println("이름: " + name);
			System.out.println("나이: " + age);
		};
		biConsumer.accept("김준일", 30);
		
		Supplier<Integer> supplier = () -> 100;
		System.out.println(supplier.get());
		
		Function<Integer, String> function = year -> "생일: " + year;
		System.out.println(function.apply(1994));
		
		ArrayList<Integer> numbers = new ArrayList();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		numbers.add(6);
		numbers.add(7);
		System.out.println(numbers);
		numbers.removeIf(num -> num % 2 ==0);
		System.out.println(numbers);
		
		numbers.forEach(num -> System.out.println("출력: " + num));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
