package ch12_상속;

public class Product {
	private String model;
	private int price;
	
//	public Product() {
//		System.out.println("상품 객체 생성");
//	}
	
	public Product(String model, int price) {
		super();
		this.model = model;
		this.price = price;
	}

	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	
}
