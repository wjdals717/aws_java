import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class b1152 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		//1
		int count = 0;
		for(int i = 0; i< str.length(); i++) {
			if(str.charAt(i) == '\n') {
				if(str.charAt(i - 1) != ' ') count++;
				break;
			}
			if(str.charAt(i) == ' ') {
				if(str.charAt(i - 1) != ' ') count++;
			}
		}
		System.out.println(count);
		
		//2
		StringTokenizer st = new StringTokenizer(str, " ");
		System.out.println(st.countTokens());
		
		//3
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			//2번 반복
		
		
	}
}
