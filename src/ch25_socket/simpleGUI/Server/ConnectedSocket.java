package ch25_socket.simpleGUI.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import ch25_socket.simpleGUI.Server.dto.RequestBodyDto;
import ch25_socket.simpleGUI.Server.dto.SendMessage;
import ch25_socket.simpleGUI.Server.entity.Room;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor	//매개변수로 socket 객체를 받는 생성자 만들어줌
public class ConnectedSocket extends Thread{
	
	private final Socket socket;
	private Gson gson;
	
	private String username;
	
	@Override
	public void run() {
		gson = new Gson();
		
		while(true) {
			try {
				//input : client에서 보낸 값을 받아들임
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String requestBody = bufferedReader.readLine(); //요청 데이터를 받음
				
				requestController(requestBody);
				
				/*
				//requestBody를 모든 client에게 뿌림
				List<ConnectedSocket> connectedSocketList = SimpleGUIServer.connectedSocketList;
				connectedSocketList.forEach(s -> {
					try {
						PrintWriter printWriter = new PrintWriter(s.socket.getOutputStream(), true);	//서버에 들어온 내용을 client에 output
						printWriter.println(requestBody);
					} catch (IOException e) {
						e.printStackTrace();
					}
				});*/
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	private void requestController(String requestBody) {
//		RequestBodyDto<?> requestBodyDto = gson.fromJson(requestBody, RequestBodyDto.class);
		
//		TypeToken<?> token = new TypeToken<RequestBodyDto<SendMessage>>() {};
//		RequestBodyDto<SendMessage> requestBodyDto = gson.fromJson(requestBody, token.getType());
		
		String resource = gson.fromJson(requestBody, RequestBodyDto.class).getResource();
		
		switch(resource) {
			case "connection":	//user 생성했을 때
				connection(requestBody);
				break;
						
			case "createRoom":	
				createRoom(requestBody);
				break;
				
			case "join":
				join(requestBody);
				break;
				
			case "sendMessage":
				sendMessage(requestBody);
				break;
		}
	}
	
	private void connection(String requestBody) {
		username = (String) gson.fromJson(requestBody, RequestBodyDto.class).getBody();
		
		List<String> roomNameList = new ArrayList<>();
		
		SimpleGUIServer.roomList.forEach(room -> {
			roomNameList.add(room.getRoomName());
		});			//RoomList에 새로 만든 room 추가
		
		RequestBodyDto<List<String>> updateRoomListrequestBodyDto = 
				new RequestBodyDto<List<String>>("updateRoomList", roomNameList);
		
		ServerSender.getInstance().send(socket, updateRoomListrequestBodyDto);	//자기 자신에게만 List를 업데이트해 줌
	}
	
	private void createRoom(String requestBody) {
		String roomName = (String) gson.fromJson(requestBody, RequestBodyDto.class).getBody();
		Room newRoom = Room.builder()
			.roomName(roomName)
			.owner(username)
			.userList(new ArrayList<ConnectedSocket>())
			.build();
		
		SimpleGUIServer.roomList.add(newRoom);
		
		List<String> roomNameList = new ArrayList<>();
		
		SimpleGUIServer.roomList.forEach(room -> {
			roomNameList.add(room.getRoomName());
		});			//RoomList에 새로 만든 room 추가
		
		RequestBodyDto<List<String>> updateRoomListrequestBodyDto = 
				new RequestBodyDto<List<String>>("updateRoomList", roomNameList);
		
		SimpleGUIServer.connectedSocketList.forEach(con ->{
			ServerSender.getInstance().send(con.socket, updateRoomListrequestBodyDto);
		});			//List에 있는 모든 방을 client에게 전송
	}
	
	private void join(String requestBody) {
		String roomName = (String) gson.fromJson(requestBody, RequestBodyDto.class).getBody();
		
		SimpleGUIServer.roomList.forEach(room -> {
			if(room.getRoomName().equals(roomName)) {
				room.getUserList().add(this);
				
				List<String> usernameList = new ArrayList<>();
				
				room.getUserList().forEach(con -> {
					usernameList.add(con.username);
				}); //스레드들마다의 username만 새로 리스트에 담음
				
				room.getUserList().forEach(connnectedSocket ->{
					RequestBodyDto<List<String>> updateUserListDto = new RequestBodyDto<List<String>>("updateUserList", usernameList);
					RequestBodyDto<String> joinMessageDto = new RequestBodyDto<String>("showMessage", username + "님이 들어왔습니다.");
					
					ServerSender.getInstance().send(connnectedSocket.socket, updateUserListDto);
					try {
						Thread.sleep(100);		//스레드 두개가 동시 동작할 수 있으므로 현재 스레드 0.1초 쉬게 함
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					ServerSender.getInstance().send(connnectedSocket.socket, joinMessageDto);
				});
				
			}
		});
	}
	
	private void sendMessage(String requestBody) {
//		SendMessage sendMessage = (SendMessage) requestBodyDto.getBody();
		TypeToken<RequestBodyDto<SendMessage>> typeToken = new TypeToken<>() {};
		
		RequestBodyDto<SendMessage> requestBodyDto = gson.fromJson(requestBody, typeToken.getType());
		SendMessage sendMessage = requestBodyDto.getBody();
		
		SimpleGUIServer.roomList.forEach(room -> {
			if(room.getUserList().contains(this)) {		//방에 속한 자신인 connectedSocket은 1개 이기 때문에 자신이 속한 방을 찾음
				room.getUserList().forEach(connnectedSocket -> {
				
//				List<String> usernameList = new ArrayList<>();
			
				RequestBodyDto<String> dto = new RequestBodyDto<String>("showMessage", sendMessage.getFromUsername() 
						+ ": " + sendMessage.getMessageBody());
				ServerSender.getInstance().send(connnectedSocket.socket, dto);
				});
			}
		/*
		SimpleGUIServer.connectedSocketList.forEach(connectedSocket -> {
			RequestBodyDto<String> dto = new RequestBodyDto<String>("showMessage", sendMessage.getFromUsername() 
					+ ": " + sendMessage.getMessageBody());
			
			ServerSender.getInstance().send(connectedSocket.socket, dto);
		});*/
		});
	}
}
