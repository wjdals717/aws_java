import java.util.Scanner;

public class b25304 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int price = 0, num = 0;
		
		price = scanner.nextInt();
		num = scanner.nextInt();
		
		int[][] array = new int[num][2];
		int result = 0;
		
		for(int i = 0; i < num; i++) {
			array[i][0] = scanner.nextInt();
			array[i][1] = scanner.nextInt();
		}
		
		for(int i = 0; i < num; i++) {
			result += array[i][0] * array [i][1];
		}
		//System.out.println(result);
		System.out.println(result == price ? "Yes" : "No");
		
	}
}
