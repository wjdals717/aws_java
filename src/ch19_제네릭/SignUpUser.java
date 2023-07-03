package ch19_제네릭;

import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@ToString(callSuper = true)
public class SignUpUser extends AccountUser {
	private String username;
	private String password;
	private String name;
	private String email;
}
