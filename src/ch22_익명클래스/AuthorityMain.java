package ch22_익명클래스;

public class AuthorityMain {
	public static void main(String[] args) {
		GrantedAuthorities authorities = new GrantedAuthorities() { //인터페이스를 상속받지 않고 일회용으로 사용할 수 있도록 함
			@Override
			public String getAuthority() {
				System.out.println("권한 출력");
				return "ROLE_USER";
			}
		};
		System.out.println(authorities.getAuthority());
		
		A a = new A();
		System.out.println(a.getAuthority());
	}
}

class A implements GrantedAuthorities {
	@Override
	public String getAuthority() {
		System.out.println("두번째권한 출력");
		return "ROLE_ADMIN";
	}
}
