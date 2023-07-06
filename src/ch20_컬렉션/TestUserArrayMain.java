package ch20_컬렉션;

public class TestUserArrayMain {
	public static void main(String[] args) {
		TestUser[] testUsers = new TestUser[3];
		
		testUsers[0] = TestUser.builder().username("aaa").password("1234").build();
		testUsers[1] = TestUser.builder().username("bbb").password("1111").build();
		testUsers[2] = TestUser.builder().username("ccc").password("2222").build();
		
	}
	
}
