package ch18_빌더;

public class KoreaUserMain {
	public static void main(String[] args) {
//		KoreaUser koreaUser = new KoreaUser(1, "aaa", "1234", "김준일", "aaa@naver.com");
		//데이터가 많은 경우에는 setter쓰는게 더 명확함, setter처럼 쓸 수 있도록
		
		KoreaUser koreaUser = KoreaUser.builder()
				.userId(1)
				.username("김준일")
				.password("1234")
				.name("김준일")
				.email("aaa@naver.com")
				.build();
//		자기 자신에게 계속 set하는 것과 같음
//		순서를 바꿔도 상관없음
		
		KoreaUser koreaUser2 = new KoreaUser(1, null, null, null, null);
		KoreaUser koreaUser3 = new KoreaUser();
		koreaUser3.setUserId(1);
		//전부 다 같음
		
	}
}
