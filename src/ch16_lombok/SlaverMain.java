package ch16_lombok;

public class SlaverMain {
	public static void main(String[] args) {
		Slave slave = new Slave("박지영", 25);
		
		System.out.println(slave);
		System.out.println(slave.getAge());
		new Slave(null);
		
		
	}
}
