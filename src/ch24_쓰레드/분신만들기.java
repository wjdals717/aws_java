package ch24_쓰레드;

public class 분신만들기 {
	public static void main(String[] args) {
		분신 분신1 = new 분신();
		분신 분신2 = new 분신();
		분신 분신3 = new 분신();
		분신 분신4 = new 분신();
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				while(true) { 
					System.out.println("Runnable");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		Thread thread1 = new Thread(runnable);
		
		Runnable runnable2 = () -> {
			while(true) { 
				System.out.println("Runnable2");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		Thread thread2 = new Thread(runnable2);
		
		Thread thread3 = new Thread(()->{
			while(true) { 
				System.out.println("Runnable3");
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		분신1.start();
		분신2.start();
		분신3.start();
		분신4.start();
		thread1.start();
		thread2.start();
		thread3.start();
	}
}
