package exam;

import exam.Order.OrderBuilder;

class Order {
	private int orderId;
	private String productName;
	private String consumerName;
	private int price;
	private int stock;

	public Order(int orderId, String productName, String consumerName, int price, int stock) {
		super();
		this.orderId = orderId;
		this.productName = productName;
		this.consumerName = consumerName;
		this.price = price;
		this.stock = stock;
	}
	
	public static OrderBuilder builder() {
		return new OrderBuilder();
	}
	
	public static class OrderBuilder{
		private int orderId;
		private String productName;
		private String consumerName;
		private int price;
		private int stock;
		
		public Order build() {
			return new Order(orderId, productName, consumerName, price, stock);
		}
		
		public OrderBuilder orderId(int orderId) {
			this.orderId = orderId;
			return this;
		}
		public OrderBuilder productName(String productName) {
			this.productName = productName;
			return this;
		}
		public OrderBuilder consumerName(String consumerName) {
			this.consumerName = consumerName;
			return this;
		}
		public OrderBuilder price(int price) {
			this.price = price;
			return this;
		}
		public OrderBuilder stock(int stock) {
			this.stock = stock;
			return this;
		}
	}
	public void showOrderInfo() {
		System.out.println("주문번호: " + orderId + "\n상품명: " + productName + "\n구매자: " + consumerName
				+ "\n가격: " + price + "\n수량: " + stock);
	}
}
public class OrderMain {
	public static void main(String[] args) {
		Order order = Order.builder()
				.orderId(100)
				.productName("Samsung GalaxyBook2 Pro")
				.consumerName("홍길동")
				.price(1450000)
				.stock(2)
				.build(); 
		order.showOrderInfo();
	}
}
