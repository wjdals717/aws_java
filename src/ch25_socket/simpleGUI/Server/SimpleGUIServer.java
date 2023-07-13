package ch25_socket.simpleGUI.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import ch25_socket.simpleGUI.Server.entity.Room;

public class SimpleGUIServer {
	
	public static List<ConnectedSocket> connectedSocketList = new ArrayList<>();
	public static List<Room> roomList = new ArrayList<>();		//방들이 만들어지는 리스트
	
	public static void main(String[] args) {		
		try {
			ServerSocket serverSocket = new ServerSocket(8000);
			System.out.println(" [ 서버 실행 ] ");
			
			while(true) {	//클라이언트가 접속할 때마다 ConnectedSocket을 생성해서 List에 순서대로 추가
				Socket socket = serverSocket.accept();
				ConnectedSocket connectedSocket = new ConnectedSocket(socket);
				connectedSocketList.add(connectedSocket);	//버퍼에서 읽은 값을 리스트에 추가
				connectedSocket.start();					//스레드 실행
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
