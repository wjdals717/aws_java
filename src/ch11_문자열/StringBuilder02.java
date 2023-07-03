package ch11_문자열;

public class StringBuilder02 {
	public static void main(String[] args) {
		//권한
		String[] roles = { "ROLE_USER", "ROLE_MANAGER", "ROLE_ADMIN"};
		
		String strRoles = "";
		
		for(int i = 0; i < roles.length; i++) {
			strRoles += roles[i];
			if( i != roles.length -1) {	//마지막 인덱스가 아닐 때 ", "추가
				strRoles += ", ";
			}
		}
		System.out.println(strRoles);
		
		//StringBuilder를 쓸 줄 알면 이 방법이 더 ... 좋음
		StringBuilder strRolesBuiler = new StringBuilder();
		
		for(int i = 0; i < roles.length; i++) {
			strRolesBuiler.append(roles[i] + ", ");	//제일 뒤에 문자 추가
		}
		strRolesBuiler.delete(strRolesBuiler.lastIndexOf(", "), strRolesBuiler.length());	//마지막 인덱스의 글자 ", "삭제
		
		System.out.println(strRolesBuiler.toString());
	}
}
