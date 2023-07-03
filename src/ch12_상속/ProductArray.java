package ch12_상속;

public class ProductArray {
	public static void main(String[] args) {
		Product[] products = new Product[5];
		
		products[0] = new Computer("삼성 컴퓨터", 1000, "데스크탑");
		products[1] = new Clothes("하의", 1000, "L", "red");
		products[2] = new Computer("맥북", 2000, "랩탑");
		products[3] = new Clothes("상의", 5000, "M", "black");
		products[4] = new Computer("그램", 3000, "랩탑");
		
		
		for(int i = 0; i< products.length; i++) {
			System.out.println("모델명 : " + products[i].getModel());
			System.out.println("가격 : " + products[i].getPrice());
			if(products[i] instanceof Computer) {
				System.out.println("컴퓨터임");
				Computer computer = (Computer) products[i]; //다운캐스팅
				System.out.println("종류: " + computer.getType());
			}else if(products[i] instanceof Clothes) {
				System.out.println("옷임");
				Clothes clothes = (Clothes) products[i];
				System.out.println("사이즈: " + clothes.getSize());
				System.out.println("색상: " + clothes.getColor());
			}
			System.out.println("===========================");
		}
	}
}
