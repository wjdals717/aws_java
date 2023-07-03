package ch20_컬렉션;

import java.util.HashSet;

public class HashSetMain {
	public static void main(String[] args) {
		HashSet<TestUser> testUsers = new HashSet<>();
		testUsers.add(TestUser.builder().username("aaa").password("1234").build());
		testUsers.add(TestUser.builder().username("bbb").password("5678").build());
		testUsers.add(TestUser.builder().username("ccc").password("1274").build());
		testUsers.add(TestUser.builder().username("ddd").password("9876").build());
		
//		System.out.println(testUsers);
		
		TestUser value = null;
		
		for(TestUser testUser: testUsers) {
			if(testUser.getUsername().equals("ccc")) {
				System.out.println(testUser);
				value = testUser;
				break;
			}
		}
		System.out.println(value);
	}
}
