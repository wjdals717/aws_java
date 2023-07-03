package ch07_클래스.overloading;

public class Phone {
	public void send() {
		System.out.println("전송");
	}
	public void send(String message) {
		System.out.println("전송내용: " + message);
	}
	public void send(String number, String message) {
		System.out.println(number + "애게" + message + " 내용 전송 ");
	}
	public void send(String message, int count) {
		System.out.println(message + "내용" + count + "번 전송");
	}
}

