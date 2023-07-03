package ch11_문자열;

public class String08 {
	public static void main(String[] args) {
		String strNumbers = "1, 2, 3, 4, 5, 6, 7, 8, 9, 10";
		
		String[] strNumberArray = strNumbers.split(",");
		
		for(int i = 0; i< strNumberArray.length; i++)
			System.out.println(strNumberArray[i]);
	}
}
