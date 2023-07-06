package ch20_컬렉션;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListAndMapMain {
	public static void main(String[] args) {
		List<TestUser> testUsers = new ArrayList<>();
		testUsers.add(TestUser.builder().username("aaa").password("1234").build());
		testUsers.add(TestUser.builder().username("bbb").password("1234").build());
		testUsers.add(TestUser.builder().username("ccc").password("1234").build());
		testUsers.add(TestUser.builder().username("ddd").password("1234").build());
		testUsers.add(TestUser.builder().username("eee").password("1234").build());
		
		
//		Map<String, List<?>> responseData = new HashMap<>();
		Map<String, Object> responseData = new HashMap<>();
		responseData.put("testUserList", testUsers);	//리스트만 들어올 수 있음
		responseData.put("statusCode", "OK");
		
		for(TestUser testUser : (List<TestUser>) responseData.get("testUserList")) {	//testUserList가 object로 업캐스팅 됨 -> 다운캐스팅 필요
			System.out.println(testUser);
		}
		
		System.out.println(testUsers);
		
	}
}
