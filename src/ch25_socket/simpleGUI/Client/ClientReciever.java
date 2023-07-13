package ch25_socket.simpleGUI.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.google.gson.Gson;

import ch25_socket.simpleGUI.Server.dto.RequestBodyDto;


public class ClientReciever extends Thread{
	
	@Override
	public void run() {
		SimpleGUIClient simpleGUIClient = SimpleGUIClient.getInstance();
		while (true) {
			try {
				BufferedReader bufferedReader = new BufferedReader
						(new InputStreamReader(simpleGUIClient.getSocket().getInputStream()));
				String requsetBody = bufferedReader.readLine();
//				simpleGUIClient.getTextArea().append(requsetBody + "\n"); //문자열을 TextArea에 추가
				
				requestController(requsetBody);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	private void requestController(String requestBody) {
		Gson gson = new Gson();
		
		String resource = gson.fromJson(requestBody, RequestBodyDto.class).getResource();
		
		switch(resource) { //textArea에 문자를 뿌려줌...
			case "updateRoomList":
				List<String> roomList = (List<String>) gson.fromJson(requestBody, RequestBodyDto.class).getBody();
				SimpleGUIClient.getInstance().getRoomListModel().clear();
				SimpleGUIClient.getInstance().getRoomListModel().addAll(roomList);
				break;
				
			case "showMessage":
				String messageContent = (String) gson.fromJson(requestBody, RequestBodyDto.class).getBody();
				SimpleGUIClient.getInstance().getChattingtextArea().append(messageContent + "\n");
				break;
				
			case "updateUserList":
				List<String> usernameList = (List<String>) gson.fromJson(requestBody, RequestBodyDto.class).getBody();
				SimpleGUIClient.getInstance().getUserListModel().clear();	//List 초기화
				SimpleGUIClient.getInstance().getUserListModel().addAll(usernameList); 	//초기화한 List에 uesrname을 다시 입력함
				//클라이언트가 접속할 때마다 리스트를 초기화 하고 다시 추가
				break;
		}
	}
}
