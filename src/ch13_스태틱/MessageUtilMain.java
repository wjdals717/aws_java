package ch13_스태틱;

public class MessageUtilMain {
	
	private int a;
	
	public static void main(String[] args) {
		MessageUtilMain messageUtilMain = new MessageUtilMain();
		System.out.println(messageUtilMain.a);

		MessageUtil messageUtil = new MessageUtil();
		
//		messageUtil.sendMail();
//		messageUtil.sendFile();
		
		MessageUtil.sendFile();		//객체를 생성하지 않고 클래스를 바로 사용
		
		MessageUtil.data = "안녕";	
		System.out.println(MessageUtil.data);
		System.out.println(messageUtil.data);
		
	}
}
