package ch25_socket.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor	//final 변수의 생성자를 만들어줌
public class ConnectedSocket extends Thread{
	
	private final Socket socket;	//final 변수일 경우 생성자의 매개변수가 자동으로 잡힘

	@Override
	public void run() {	//스레드 상속받으면 run()메소드를 사용할 수 있음
		BufferedReader bufferedReader = null;	//
		
		try {
			while(true) {
				bufferedReader  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String requestBody = bufferedReader.readLine();
				System.out.println("입력데이터: " + requestBody);				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		//문자열 단위로 받아들여서 버퍼단위로 읽음
		
	}
	
}
