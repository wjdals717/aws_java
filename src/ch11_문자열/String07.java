				package ch11_문자열;

public class String07 {
	public static void main(String[] args) {
		String name = "변정민";
		String address = "부산 연제구";
		
		System.out.println(name.concat(" " + address));	//concat() : 문자열을 합침
		System.out.println(name.concat(" ".concat(address)));	//+연산자를 사용하지 않고도 가능
		
	}
}
