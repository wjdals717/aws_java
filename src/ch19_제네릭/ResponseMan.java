package ch19_제네릭;

public class ResponseMan {
	public static void main(String[] args) {
		Response<String> response1 = new Response(200, "회원가입 성공!!");
//		System.out.println(response1);

		SignUpUser signUpUser = SignUpUser.builder().username("aaa").password("1234").name("김준일").email("aaa@naver.com")
				.build();
		Response<SignUpUser> response2 = new Response(400, signUpUser);

		AccountUser accountUser = AccountUser.builder().username("aaa").password("1234").build();

		Response<AccountUser> response3 = new Response<AccountUser>(200, accountUser);
//		response3 = response2;
		
		UpdateUser updateUser = UpdateUser.builder()
				.username("bbb")
				.password("5678")
				.address("부산")
				.phone("010-1234-5678")
				.build();
		Response<UpdateUser> response4 = new Response<UpdateUser>(300, updateUser);
//		Response<? extends AccountUser> response4 = new Response<UpdateUser>(300, updateUser);
		
		printResponse(response3);
	}
	public static Response<?> printResponse(Response<? super SignUpUser> response){
		System.out.println(response);
		return response;
	}
}
