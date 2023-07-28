package ch25_socket.simpleGUI.Client;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.Socket;
import java.util.Objects;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ch25_socket.simpleGUI.Client.dto.RequestBodyDto;
import ch25_socket.simpleGUI.Client.dto.SendMessage;
import lombok.Getter;

@Getter
public class SimpleGUIClient extends JFrame {
	
	private static SimpleGUIClient instance;
	public static SimpleGUIClient getInstance() {
		if(instance == null) {
			instance = new SimpleGUIClient();
		}
		return instance;
	}

	private String username;	//채팅하는 사람의 이름
	private Socket socket;
	
	private CardLayout mainCardLayout;
	private JPanel mainCardPanel;
	
	private JPanel chattingRoomPanel;
	private JScrollPane roomListScrollPanel;
	private DefaultListModel<String> roomListModel;
	private JList roomList;
	
	private JPanel chattingRoomListPanel;

	private JTextField messageTextField;
	private JTextArea chattingtextArea;
	
	private JScrollPane userListScrollPane;
	private DefaultListModel<String> userListModel;
	private JList userList;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleGUIClient frame = SimpleGUIClient.getInstance();
					frame.setVisible(true);
					
					ClientReciever clientReciever = new ClientReciever();
					//socket은 private변수이기 때문에 frame의 변수로 가져올 수 있다 ->frame.socket
					clientReciever.start();
					
					RequestBodyDto<String> requestBodyDto = new RequestBodyDto<String>("connection", frame.username);
					ClientSender.getInstance().send(requestBodyDto);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private SimpleGUIClient() {
		
		username = JOptionPane.showInputDialog(chattingRoomPanel, "아이디를 입력하세요");
		
		if(Objects.isNull(username)) {
			System.exit(0);
		}
		try {
			socket = new Socket("127.0.0.1", 8000);	//server에서 Socket socket = serverSocket.accept();이 반응함
//			RequestBodyDto<String> requestBodyDto = new RequestBodyDto<String>("join", username);
//			ClientSender.getInstance().send(requestBodyDto);
			
			/*
			//서버에 뿌린 데이터를 버퍼에서 읽어서 출력
			Thread inputThread = new Thread(()->{
				try {
					while(true) {
						BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));	//위 세 줄과 같음
						String requestBody = bufferedReader.readLine();
						textArea.append(requestBody + "\n");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			inputThread.start();
			 */
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		mainCardLayout = new CardLayout();
		mainCardPanel = new JPanel();
		mainCardPanel.setLayout(mainCardLayout);
		setContentPane(mainCardPanel);
		
		chattingRoomListPanel = new JPanel();
		chattingRoomListPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		chattingRoomListPanel.setLayout(null);
		mainCardPanel.add(chattingRoomListPanel, "chattingRoomListPanel");
		
		JButton createRoomButton = new JButton("방만들기");
		createRoomButton.setBounds(10, 10, 100, 30);
		createRoomButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String roomName = JOptionPane.showInputDialog(chattingRoomListPanel, "방제목을 입력하세요");
				//입력되지 않을 경우, 종료
				if(Objects.isNull(roomName)) {
					return;
				}
				//빈칸이 있을 경우, 실패
				if(roomName.isBlank()) {
					JOptionPane.showMessageDialog(chattingRoomListPanel, "방제목을 입력하세요", "방만들기 실패", JOptionPane.ERROR_MESSAGE);
					return;
				}
				//이미 존재하는 방의 경우, 실패
				for(int i = 0; i < roomListModel.size(); i++) {
					if(roomListModel.get(i).equals(roomName)) {
						JOptionPane.showMessageDialog(chattingRoomListPanel, "이미 존재하는 방제목입니다.", "방만들기 실패", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				
				RequestBodyDto<String> requestBodyDto = new RequestBodyDto<String>("createRoom", roomName);
				ClientSender.getInstance().send(requestBodyDto);
				
				mainCardLayout.show(mainCardPanel, "chattingRoomPanel");
				requestBodyDto = new RequestBodyDto<String>("join", roomName);
				ClientSender.getInstance().send(requestBodyDto);
				
			}
		});
		chattingRoomListPanel.add(createRoomButton);
		
		roomListScrollPanel = new JScrollPane();
		roomListScrollPanel.setBounds(12, 47, 412, 206);
		chattingRoomListPanel.add(roomListScrollPanel);
		
		roomListModel = new DefaultListModel<String>();
		roomList = new JList(roomListModel);
		roomList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {	//더블클릭을 했을 때
					String roomName = roomListModel.get(roomList.getSelectedIndex());
					
					mainCardLayout.show(mainCardPanel, "chattingRoomPanel");
					RequestBodyDto<String> requestBodyDto = new RequestBodyDto<String>("join", roomName);
					ClientSender.getInstance().send(requestBodyDto);
				}
			}
		});
		roomListScrollPanel.setViewportView(roomList);
		
		chattingRoomPanel = new JPanel();
		chattingRoomPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		chattingRoomPanel.setLayout(null);
		mainCardPanel.add(chattingRoomPanel, "chattingRoomPanel");
		
		JScrollPane chattingTextAreascrollPane = new JScrollPane();
		chattingTextAreascrollPane.setBounds(12, 10, 282, 203);
		chattingRoomPanel.add(chattingTextAreascrollPane);
		
		chattingtextArea = new JTextArea();
		chattingTextAreascrollPane.setViewportView(chattingtextArea);
		
		messageTextField = new JTextField();
		messageTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {	//엔터키가 입력되면
					SendMessage sendMessage = SendMessage.builder()
							.fromUsername(username)
							.messageBody(messageTextField.getText())
							.build();
					
					RequestBodyDto<SendMessage> requestBodyDto = new RequestBodyDto("sendMessage", sendMessage);
					
					ClientSender.getInstance().send(requestBodyDto);
					messageTextField.setText("");
					
					/*try {	//소켓에서 읽어들이고 값을 출력
						//PrintWriter : client와 server의 통로 역할
						PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
						printWriter.println(username + ": " + textField.getText());
					} catch (IOException e1) {
						e1.printStackTrace();
					} finally {
						textField.setText("");	//엔터를 친 후에 전송되고 텍스트는 지워짐
					}*/
				}
			}
		});
		messageTextField.setBounds(12, 223, 412, 30);
		chattingRoomPanel.add(messageTextField); 
		messageTextField.setColumns(10);
		
		userListScrollPane = new JScrollPane();
		userListScrollPane.setBounds(306, 10, 118, 203);
		chattingRoomPanel.add(userListScrollPane);
		
		userListModel = new DefaultListModel<>();
		userList = new JList(userListModel);
		userListScrollPane.setViewportView(userList);
		
	}
}
