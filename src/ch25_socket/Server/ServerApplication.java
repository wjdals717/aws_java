package ch25_socket.Server;

import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ServerApplication {
	
	public static ServerSocket serverSocket;
	public static int port = 0;
	
	
	
	public static void main(String[] args) {
		Thread connetionThread = null;
		
		System.out.println("[ 서버 프로그램 실행 ]");
		while(true) {
			Scanner scanner = new Scanner(System.in);

			int selectedMenu = 0;
			System.out.println("1. 서버켜기");
			System.out.println("2. 서버끄기");
			System.out.print("선택: ");
			
			//입력 부분 -> 숫자가 아닐 시(문자열 등) 예외 처리
			try {
				selectedMenu = scanner.nextInt();
			}catch(InputMismatchException e) {	//숫자가 아닌 예외 처리
				System.out.println("숫자만 입력 가능합니다.");
				continue;	//다시 while 조건으로 이동 -> 다시 입력 가능하도록 함
			}
			
			//입력 처리
			switch (selectedMenu) {
				case 1:
					if(serverSocket != null) {	//소켓 객체가 생성이 되어있는지 확인(서버는 딱 하나만 생성되어야 함)
						System.out.println("이미 서버가 실행 중입니다.");
						break;					//switch에 break -> 다시 while문으로 돌아감
					}
					System.out.print("포트 번호를 입력하세요: ");
					try {
						port = scanner.nextInt();
					} catch (InputMismatchException e) {
						System.out.println("숫자만 입력 가능합니다.");
						continue;
					}
//					람다식 → 새로운 클래스의 메소드이기 때문에 원래 존재하던 변수를 가져다 사용할 수 없음
//					⇒ ServerSocket serverSocket; 를 public static으로 선언해 어디서든 접근 가능하도록 변경
//					스레드 생성 -> 다른 클라이언트의 접속을 기다림, 다른 클래스로 따로 빼도 상광없음
					connetionThread = new Thread(() ->{ //생성한다고 실행되지 않음 -> 정의만 한 거임
						try {
							
							serverSocket = new ServerSocket(port);	//서버를 실행시키면서 포트번호를 할당함
							
							while(!Thread.interrupted()) {
								//Thread.interrupted() = true이면 not이므로 false가 되어 accept를 하지 않음 -> 스레드가 실행되지 않음
								Socket socket = serverSocket.accept();
								//ClientApplication이 실행될 수 있도록 소켓 열고 대기 -> 값이 들어오면 접속됨
								
								ConnectedSocket connectedSocket = new ConnectedSocket(socket);	//접속이 실행될 때마다 스레드를 하나씩 만듦
								connectedSocket.start();
								ConnectedClientController.getInstance()
									.getConnectedSockets().add(connectedSocket);		//ArrayList에 add
								//새로운 소켓이 들어올 때마다 실행시기키고 List에 담음 -> List에서 각각 동작하고 있음
								
								System.out.println("접속!!");
								System.out.println(socket.getInetAddress().getHostAddress());
							}
						} catch (BindException e) {		//포트 번호 예외, 같은 번호의 포트 번호를 열면...
							System.out.println("이미 사용 중인 포트번호입니다.");
						} catch (SocketException e) {	//소켓을 강제 종료했을 때 예외...
							System.out.println("서버 연결이 종료되었습니다.");
						} catch (IOException e) {		//입출력 예외
							e.printStackTrace();		//예외 발생 시 호출 스택에 있던 메소드의 정보와 예외 결과를 화면에 출력함
						}
					},"connetionThread");
					
					connetionThread.start();			//이 때부터 스레드 실행, 이전까지는 정의이고 스레드는 실행되지 않음
					break;
					
				case 2:
					if(serverSocket == null) {			//서버가 열려있지 않으면 종료도 불가능
						System.out.println("서버가 실행 중이지 않습니다.");
						break;
					}
					//서버가 열려 있는 경우 
					try {
						serverSocket.close();			//소켓 객체(열려있는 상태)를 닫음
					}catch(IOException e) {}			//소켓은 예외가 항상 발생할 수 있음...걍 예외 처리
					
					connetionThread.interrupt();		//스레드를 강제 종료 시킴
						
					try {
						connetionThread.join();
						//스레드는 누가 먼저 실행될지 모르기 때문에 connetionThread가 종료될 때까지 기다리고 프로그램(main) 종료
					}
					catch (InterruptedException e){
						e.printStackTrace();			//무슨 예외가 발생했는지 예외 결과를 화면에 출력
					}
//					connetionThread.stop();				//메모리에 남아있을 수 있으므로 강제 종료 후 main과 같이 종료시킴
					System.out.println("프로그램 종료");
					return;								//프로그램 종료
				default:
					System.out.println("다시 선택하세요.");	//다른 숫자 입력시 다시 선택하도록 break를 걸어주지 않음
			}
			
			//메인이 실행되고 스레드가 실행되기 때문에 출력될 때까지 main이 실행 안 되고 대기시켜줌
			if(serverSocket == null) {
				try{
					connetionThread.join(500);		//그냥 조인을 하면 2번 스레드가 전부 실행될 때까지 1번 스레드가 기다림
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			/*
			if(selectedMenu == 1 ) {
				try {
					serverSocket = new ServerSocket(8000);	//서버를 실행시키면서 포트번호를 할당함			
					while(true) {
						Socket socket = serverSocket.accept();
						System.out.println("접속!!");
						System.out.println(socket.getInetAddress().getHostAddress());
					}
				} catch (BindException e) {
					System.out.println("이미 사용 중인 포트번호입니다.");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else if(selectedMenu == 2) {
				
			}else {
				System.out.println("다시 선택하세요.");
			}*/
		}
		
		
	}
}
