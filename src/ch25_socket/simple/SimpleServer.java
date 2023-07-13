package ch25_socket.simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import lombok.RequiredArgsConstructor;

public class SimpleServer {
	public static void main(String[] args) {
		try {
			System.out.println("서버실행");
			ServerSocket serverSocket = new ServerSocket(8000);
			List<Socket> socketList = new ArrayList<>();
			
			while(true) {
				Socket socket = serverSocket.accept();			//클라이언트의 접속을 기다림 //반복이 실행되야 여러 클라이언트의 접속을 받아들일 수 있음
				//System.out.println(socket.getInetAddress());
				socketList.add(socket);
				
				Thread thread = new Thread(()-> {
					Socket threadSocket = socket;				//소켓이 새 주소로 변경될 때 기존에 있던 소켓의 주소가 변경되지 않도록
					while(true) {
						try {
							//input : 입력받은 데이터를 requeseBody에 저장함
							System.out.println("데이터 입력을 기다림");
							InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
							//데이터를 입력받을 수 있는 객체
							BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
							//버퍼는 인풋스트림리더 안에서 사용가능
							//System.out.println(bufferedReader.readLine()); //output을 받음
							//한 글자씩 가져옴 //read() : 유니코드로 데이터를 가져옴, enter등등 다 가져옴
							String requestBody = bufferedReader.readLine();
							
							//output : request에 저장된 내용을 모든 호스트에 전송
							socketList.forEach(s -> {
								try {
									PrintWriter printWriter = new PrintWriter(s.getOutputStream(), true);	//서버에 들어온 내용을 client에 output
									printWriter.println("메세지내용(" + requestBody + ")");
								} catch (IOException e) {
									e.printStackTrace();
								}
							});
							
						} catch(IOException e) {
							e.printStackTrace();
						}
					}
				});
				thread.start();	//스레드가 실행됨, 이전까지는 실행되지 않음
				
			}
		} catch (IOException e) {}
	}
}
