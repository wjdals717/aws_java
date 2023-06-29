package ch06_반복;

public class For03 {
	public static void main(String[] args) {
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5- i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		int n = 7; 
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n - 1 - i ; j++) {
				System.out.print(" ");
			}
			for(int j = 0; j < i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
