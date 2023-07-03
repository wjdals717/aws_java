package ch15_오브젝트;

import java.util.Scanner;

public class ScannerString {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String username = "aaa";
		String password = "1234";
		String inputUsername = null;
		String inputUserpassword = null;
		
		System.out.print("아이디: ");
		inputUsername = scanner.nextLine();			//new Stirng 안에 들어감
		System.out.print("비밀번호: ");
		inputUserpassword = scanner.nextLine();
		
		System.out.println(username.hashCode());
		System.out.println(password.hashCode());
		
		System.out.println("입력된 아이디: " + inputUsername);
		System.out.println("입력된 비밀번호: " + inputUserpassword);
		
		
//		if( username != inputUsername) {	//주소 비교 //문자열 비교할 때 사용 불가
//			System.out.println("아이디가 일치하지 않습니다.");
//			return;
//		}
		
		if( !username.equals(inputUsername)) {	
			System.out.println("아이디가 일치하지 않습니다.");
			return;
		}
		if( !password.equals(inputUserpassword)) {
			System.out.println("비밀번호가 일치하지 않습니다.");
			return;
		}
		System.out.println("로그인 성공!!!!");
		
	}
}
