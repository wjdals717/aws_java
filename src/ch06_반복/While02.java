package ch06_반복;

public class While02 {
	public static void main(String[] args) {
		int i = 0;	//while은 i를 전역변수로 사용함 -> 메모리 공간 낭비
		
		while (i < 10) {
			if( i % 2 == 0) {
				i++;
				continue;
			}
			System.out.println(i);			
			i++;
		}
	}
}
