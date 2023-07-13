package ch24_쓰레드;

public class 분신 extends Thread{
	private static int number;
	private int num;
	
	public 분신() {
		number += 1;	//스태틱이라서 공유해버려서 안 됨
		num = number;	//멤버 변수에 옮김
	}
	
	@Override
	public void run() {
		System.out.println(num + "분신 실행");
		while(true) { 
			System.out.println(num + "분신 반복");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
