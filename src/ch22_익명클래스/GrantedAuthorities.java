package ch22_익명클래스;

@FunctionalInterface	//메소드는 딱 하나만 있어야 한다.
public interface GrantedAuthorities {
	public String getAuthority();
	
}
