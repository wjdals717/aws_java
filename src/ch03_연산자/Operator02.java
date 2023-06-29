package ch03_연산자;
/*
 * 논리연산자
 * 1. && -> and (그리고)	- 곱
 * true && false => false
 * 2. || -> or  (또는)		- 합
 * true || false => true
 * 3. !  -> not (부정)		- 반전
 * !(true || false) => false
 */

public class Operator02 {
	public static void main(String[] args) {
		/*
		final int MAX = 100;
		final int MIN = 0;
		int num = -10;
		//MAX = 10;				//final : 상수이기 때문에 최초 초기화만 인정됨.
		
		System.out.println(MAX > num && MIN < num);	//프로그램에서는 MAX < num < MAX 사용 불가 -> 따로 연산해야 함
		*/
		
		int year = 2000;
		
		System.out.println(year % 4 == 0 && year % 100 != 100 || year % 400 == 0 ? 1 : 0);
		
		int result = 10 + 1;
		System.out.println(result);
		
		boolean result2 = year % 4 == 0 && year % 100 != 100 || year % 400 == 0;
		System.out.println(result2);	
		
		String result3 = year % 4 == 0 && year % 100 != 100 || year % 400 == 0 ? "1" : "0";	//삼항연산자의 참, 거짓은 자료형이 같아야 함
		System.out.println(result3);
		
		
		
		
	}
}
