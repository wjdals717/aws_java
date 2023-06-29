package ch04_입력;

import java.util.Scanner;

public class Input01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);	
		
		System.out.print("입력1 : ");
		String input1 = scanner.nextLine();				//next() : 문자열 String 전용(띄어쓰기 미포함)
		System.out.println("출력 : " + input1);

//		scanner.nextLine();							//nextLine() : 문자열 String 전용(띄어쓰기 포함)
		
		System.out.print("입력2 : ");
		String input2 = scanner.nextLine();	
		System.out.println("출력 : " + input2);
		
		System.out.println("입력완료");
		
	}
}
