package ch12_상속;

public class Clothes extends Product{
	private String size;
	private String color;
	
	public Clothes(String model, int price, String size, String color) {
		super(model, price);
		this.size = size;
		this.color = color;
	}
	
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
}
