package ch24_쓰레드;

public class ThreadMain {
	public static void main(String[] args) {
		Thread thread1 = new Thread(()-> {
			for(int i = 0; i < 50; i++) {
				System.out.print(Thread.currentThread().getName() + " : ");
				System.out.println(i);
				try {
					Thread.sleep(1000);		//다른 스레드가 도는 동안 1초 + (다른 스레드가 점유하는 시간)쉬게 함, 예외 처리 필요
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "1번 스레드");
		
		Thread thread2 = new Thread(()->{
			System.out.println("스레드 이름 : " + Thread.currentThread().getName());
			for(int i = 0; i < 50; i++) {
				System.out.print(Thread.currentThread().getName() + " : ");
				System.out.println(i);
			}
		},"2번 스레드");
		
		//스레드로 인해 for문도 한 번에 동작하지 못함 -> 묶음으로 동작하는 것이 아니라 명령 하나하나 따로 놈
		
		Thread thread3 = new Thread(new ThreadTest(), "3번 스레드");
		Thread thread4 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.print("스레드 이름 : " + Thread.currentThread().getName()); 
				System.out.println("4번 스레드 실행");
			}
		},"4번 스레드");
		
		thread1.start();		//스레드는 순서대로 동작하는 것이 아님
		/*
		try {
			thread1.join();		//thread1이 끝날 때까지 대기
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		thread2.start();		//스레드에서 run()메소드가 실행됨
		//thread3.start();
		//thread4.start();
		
//		연산을 하는 경우 스레드로 인해 중간 결과값이 출력되는 경우가 발생함 -> 방지하려고 join()사용
	}
}
