package ch25_socket.simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SimpleClient {
	public static void main(String[] args) {		
		try {
			Scanner scanner = new Scanner(System.in);
			Socket socket  = new Socket("127.0.0.1", 8000);
			System.out.println("클라이언트 실행");
			
			//input : server에서 받아 온 내용을 받아들임 -> 모든 클라이언트에 보여줌
			Thread inputThread = new Thread(()->{
				try {
//					InputStream inputStream = socket.getInputStream();
//					InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//					BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
					while(true) {
						BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));	//위 세 줄과 같음
						String requestBody = bufferedReader.readLine();
						System.out.println("내용: " + requestBody);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			
			inputThread.start();
			
			//output : sc를 통해 입력받은 내용을 server에 전송
			while(true) {	//버퍼를 묶어서 전송하는 역할 //소켓에서 output을 받아옴
				PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
				System.out.println("입력: ");
				String input = scanner.nextLine();
				
				printWriter.println(input); //입력을 server로 output
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
