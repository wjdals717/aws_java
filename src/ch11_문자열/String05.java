package ch11_문자열;

public class String05 {
	public static void main(String[] args) {
		String name = " ";
		
		boolean flag = name.isBlank();	//공백 인식
		System.out.println(flag);
		
		boolean flag2 = name.isEmpty();	//공백도 비웠다고 봄
		System.out.println(flag2);
		
	}
}
