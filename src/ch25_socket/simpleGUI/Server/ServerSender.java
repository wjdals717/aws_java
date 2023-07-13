package ch25_socket.simpleGUI.Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import com.google.gson.Gson;

import ch25_socket.simpleGUI.Server.dto.RequestBodyDto;

public class ServerSender {
	
	private Gson gson;
	private static ServerSender instance;
	
	private ServerSender() {
		gson = new Gson();
	}
	public static ServerSender getInstance() {
		if(instance == null) {
			instance = new ServerSender();
		}
		return instance;
	}
	
	//서버는 소켓에 대한 각각의 센더를 가지고 있어야 함, 서버는 여러 개의 소켓을 가지고 있기 때문
	public void send(Socket socket, RequestBodyDto requestBodyDto) {
		try {
			PrintWriter printWriter = 
					new PrintWriter(socket.getOutputStream(), true);
			printWriter.println(gson.toJson(requestBodyDto));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
