package ch16_lombok;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
//@Setter
//@EqualsAndHashCode
//@ToString
@Data
public class Slave {
	private final String name;	//@RequiredArgsConstructor를 쓰려면 final필요
	@Getter						//@getter를 변수에 지정할 수도 있음  
	private int age;
}
