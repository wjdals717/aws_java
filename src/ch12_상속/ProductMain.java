package ch12_상속;

public class ProductMain {
	public static void main(String[] args) {
		Computer computer = new Computer("삼성 컴퓨터", 1000, "데스크탑");
		Clothes clothes = new Clothes("상의", 2000, "L", "black");
//		System.out.println(computer.getModel());
		
		Product product = computer; //clothes는 불가
//		Product product =  new Product("상품", 300);	//메모리 주소가 2개 밖에 없어 메모리 공간 부족으로 캐스팅이 불가
		
//		System.out.println(product.ge); //업캐스팅 이후에는 getter, setter 사용 불가
		Computer computer2 = (Computer) product;
		System.out.println(computer2.getType());
		
	}
}
