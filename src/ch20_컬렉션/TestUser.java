package ch20_컬렉션;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@Data
public class TestUser {
	private String username;
	private String password;
}
