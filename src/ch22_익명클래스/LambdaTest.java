package ch22_익명클래스;

import java.util.Arrays;

public class LambdaTest {
	public static void main(String[] args) {
		GrantedAuthorities authorities = new GrantedAuthorities() { //인터페이스를 상속받지 않고 일회용으로 사용할 수 있도록 함
			@Override
			public String getAuthority() {
				System.out.println("권한 출력");
				return "ROLE_USER";
			}
		};
		
		GrantedAuthorities authorities2 = () -> {
			System.out.println("권한 출력");
			return "ROLE_USER";
		};
		authorities.getAuthority();
		
		System.out.println(authorities.getAuthority());
		
		Integer[] test = {1,2,3,4,5,6,7,8,9,10};
		Arrays.asList(test).forEach(num -> System.out.println(num));
		
		
	}
}