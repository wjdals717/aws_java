package ch05_조건;

public class If02 {
	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		int c = 30;
		
		if(a == 40) 
			System.out.println("a는 40입니다.");
		else if (b == 40)
			System.out.println("b는 40입니다.");
		else if (c == 40)
			System.out.println("c는 40입니다.");
		else
			System.out.println("40이 없습니다.");
	}		
}