package ch03_연산자;

public class Operator03 {
	public static void main(String[] args) {
		int a = 3;
		int b = 4;
		int c = 5;
		
		int result = (a > b) ? a : b;
		result = ( result > c ) ? result : c;
		System.out.println(result);
		
		System.out.println(a < b ? b < c ? c : b : a < c ? c : a );

	}
}