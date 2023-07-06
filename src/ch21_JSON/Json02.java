package ch21_JSON;

import com.google.gson.Gson;

public class Json02 {
	public static void main(String[] args) {
		Gson gson = new Gson();
		
		JsonUser jsonUser = JsonUser.builder()
				.username("aaa")
				.password("bbb")
				.build();
		System.out.println(jsonUser);
		
		String jsonData = gson.toJson(jsonUser);
		System.out.println(jsonData);
		
		JsonUser jsonUser2 = gson.fromJson(jsonData, JsonUser.class);
		System.out.println(jsonUser2);
	}
	
}
