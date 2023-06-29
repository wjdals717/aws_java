package ch06_반복;

public class For02 {
	public static void main(String[] args) {
		int num = 10;
		System.out.println(num);
		
		
		for(int i = 0; i < 10; i++) {
			System.out.println(i);
		}
		
		String str = "코리아아이티";
		System.out.println(str.substring(0, 3));	//substring(start, end+1) : 문자열을 자름
	}
}
