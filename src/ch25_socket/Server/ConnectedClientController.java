package ch25_socket.Server;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

public class ConnectedClientController {
	private static ConnectedClientController instance;
	
	@Getter
	private List<ConnectedSocket> connectedSockets; //변수 위에 getter달면 변수에만 getter 생성
	
	private ConnectedClientController() {			//싱글톤이니까 생성은 한 번만 함
		connectedSockets = new ArrayList<>();
	}
	
	public static ConnectedClientController getInstance() {
		if(instance == null) {
			instance = new ConnectedClientController();
		}
		return instance;
	}
}
