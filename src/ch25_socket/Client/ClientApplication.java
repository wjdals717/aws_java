package ch25_socket.Client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ClientApplication extends JFrame {

	private Socket socket;
	
	private JPanel mainPanel;
	private JTextField ipTextField;
	private JTextField portTextField;
	private JTextField MessageTextField;
	private JButton MessageSendButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientApplication frame = new ClientApplication();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClientApplication() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 470);
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(mainPanel);
		mainPanel.setLayout(null);
		
		/*<<< 채팅 내용 >>>*/
		JScrollPane chatTextAreaScrollPane = new JScrollPane();
		chatTextAreaScrollPane.setBounds(12, 10, 374, 360);
		mainPanel.add(chatTextAreaScrollPane);
		
		JTextArea chatTextArea = new JTextArea();
		chatTextArea.setEditable(false);
		chatTextAreaScrollPane.setRowHeaderView(chatTextArea);
		
		/*<<< 채팅 연결 >>>*/
		ipTextField = new JTextField();
		ipTextField.setBounds(398, 10, 134, 21);
		mainPanel.add(ipTextField);
		ipTextField.setColumns(10);
		
		portTextField = new JTextField();
		portTextField.setBounds(398, 41, 134, 21);
		mainPanel.add(portTextField);
		portTextField.setColumns(10);
		
		JButton connectionButton = new JButton("접속");
		connectionButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String serverIp = ipTextField.getText();
				String serverPort = portTextField.getText();
				
				if(serverIp.isBlank() || serverPort.isBlank()) {
					JOptionPane.showMessageDialog(mainPanel
							, "IP와 PORT번호를 입력해주세요"
							, "접속오류"
							, JOptionPane.ERROR_MESSAGE);
					return;
				}
				try {
					socket = new Socket(serverIp, Integer.parseInt(serverPort));
					//연결되고 나면 textfield, button비활성화 풀어줌
					JOptionPane.showMessageDialog(mainPanel, 
							"서버와의 연결에 성공하였습니다.",
							"접속 완료",
							JOptionPane.PLAIN_MESSAGE);
					MessageTextField.setEditable(true);		//수정 불가 해제
					MessageSendButton.setEnabled(true);		//사용 불가 해제
					
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (UnknownHostException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		connectionButton.setBounds(398, 72, 134, 21);
		mainPanel.add(connectionButton);
		
		/*<<< 접속자 >>>*/
		JScrollPane connectedUserListScrollPane = new JScrollPane();
		connectedUserListScrollPane.setBounds(398, 103, 134, 267);
		mainPanel.add(connectedUserListScrollPane);
		 
		JList connectedUserList = new JList();
		connectedUserListScrollPane.setColumnHeaderView(connectedUserList);
		
		/*<<< 메세지 입력 및 전송>>>*/
		MessageTextField = new JTextField();
		MessageTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					System.out.println("전송");
				}
			}
		});
		MessageTextField.setBounds(12, 380, 432, 43);
		MessageTextField.setEditable(false);
		mainPanel.add(MessageTextField);
		MessageTextField.setColumns(10);
		
		MessageSendButton = new JButton("New button");
		MessageSendButton.setBounds(456, 380, 76, 43);
		MessageSendButton.setEnabled(false);
		mainPanel.add(MessageSendButton);
	}
}
