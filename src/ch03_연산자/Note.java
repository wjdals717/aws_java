package ch03_연산자;

/* 
 * 여기도 주석
 * 여기도 주석
 * 
 * **/
//이 코드를 보는 사람에게 알려주고 싶은 거 다 적음

/**
 * 여기도 주석
 * 여기도 주석
 * @author bjm3305(변정민)
 * @version v1.0.1
 * @since 2023-06-26
 * @apiNote
 * 	-Method : get
 * 	-URL : https://localhost:8080/test
 * 
 */
//꼭 알려줘야 하는 정보만 입력
public class Note {
	public static void main(String[] args) {
		System.out.println("주석 테스트1");
		System.out.println("주석 테스트2");
//		System.out.println("주석 테스트3");
		System.out.println("주석 테스트4");
		System.out.println("주석 테스트5");
	}
}

//	주석 : 코드의 설명을 작성할 때 사용한다.
//	컴파일 시에 무시된다.
//	(//) : 한 줄 주석
// 	(/* 내용 */)  : 여러 줄 주석
// 	(/** 내용 */) : 여러 줄 주석 (클래스, 메소드의 정보 설명)