package ch19_제네릭;

import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@ToString(callSuper = true)
public class UpdateUser extends AccountUser {
	private String address;
	private String phone;
}
