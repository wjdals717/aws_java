package ch25_socket.simpleGUI.Client.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SendMessage {
	private String fromUsername;
	private String toUsername;	
	private String messageBody;
	
}
