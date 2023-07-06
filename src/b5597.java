import java.util.Scanner;

public class b5597 {
	public static void main(String[] args) {
		boolean[] student = new boolean[30];
		Scanner sc = new Scanner(System.in);
		int num = 0;
		
		for(int i = 0; i < 28 ; i++) {
//			sc.nextLine();
			student[sc.nextInt()- 1] = true;
		}
		for(int i = 0; i < 30 ; i++) {
			if(!student[i])
				System.out.println(i + 1);
		}
	}
}