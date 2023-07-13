package ch25_socket.simpleGUI.Server.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SendMessage {
	private String fromUsername;
	private String toUsername;	
	private String messageBody;
}
