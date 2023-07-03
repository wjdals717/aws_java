package ch11_문자열;

public class String04 {
	public static void main(String[] args) {
		String phone = "       010-1234-          .1234        ";
		
		String replacePhone = phone
				.replaceAll("-", "")
				.replaceAll(" ", "")
				.replaceAll("[.]", "");		//.은 문자열로 인식하지 않기 때문에 [대괄호]에 입력해서 문자열로 인식하도록 함
		System.out.println(replacePhone);
		
		String phone2 = phone.trim();		//문자열의 앞뒤 공백 제거
		System.out.println(phone2);
	}
}
