package ch25_socket.simpleGUI.Server.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class RequestBodyDto<T> {
	private String resource;	//처리내용 //명령
	private T Body;
}
