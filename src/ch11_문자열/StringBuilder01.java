package ch11_문자열;

public class StringBuilder01 {
	public static void main(String[] args) {
//		String str = "abc";
//		str = str + "def";
//		System.out.println(str);
		
		StringBuilder builder = new StringBuilder();
		builder.append("이름: ");		//제일 뒤에 추가
		builder.append("김준일");
		builder.delete(builder.indexOf(":"), builder.indexOf(":") + 1);
		builder.insert(2, ">>");	//원하는 위치에 삽입
		
		String str = builder.toString();		//builder는 toString을 써야 문자열이 됨
		System.out.println(str);
		
		String name = "이름: 김준일";
		System.out.println(
				name.substring(0, name.indexOf(":"))
				.concat(name.substring(name.indexOf(":") + 1)));
		
		System.out.println(
				name.substring(0, 2)
				.concat(name.substring(3)));
	}
}
