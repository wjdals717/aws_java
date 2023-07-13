package ch25_socket.simpleGUI.Server.entity;

import java.util.List;

import ch25_socket.simpleGUI.Server.ConnectedSocket;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Room {
	private String roomName;
	private String owner;		//방장
	private List<ConnectedSocket> userList;
	
}
