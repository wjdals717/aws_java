package ch04_입력;

import java.util.Scanner;

public class Input02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String name = null;
		int age = 0;
		String phone = null;
		String address = null;
		String gender = null;
		
		System.out.print("이름 : ");		//next() : 엔터, 스페이스 무시함
		name = scanner.nextLine();
		System.out.print("나이 : ");
		age = scanner.nextInt();			//nextInt() : 엔터, 스페이스 무시함
		scanner.nextLine();					//버퍼에 남아있는 엔터를 없애야 함
		System.out.print("연락처 : ");
		phone = scanner.nextLine();
		System.out.print("주소 : ");
		address = scanner.nextLine();		
		System.out.print("성별 : ");
		gender = scanner.nextLine();
		
		System.out.println("고객님의 이름은 " + name + "이고 나이는 " + age +"세 입니다.");
		System.out.println("연락처는 " + phone + "이며 주소는 " + address + "입니다.");
		System.out.println("성별은 " + gender + "입니다.");

		
		/*
		 * 이름(name) : 
		 * 나이(age) : 
		 * 연락처(phone) : 
		 * 주소(address) : 
		 * 성별(gender) : 
		 *
		 * 고객님의 이름은 변정민이고 나이는 23세입니다.
		 * 연락처는 010-6491-3305이며 주소는 부산 연제구입니다.
		 * 성별은 여입니다.
		 */
	}
}
