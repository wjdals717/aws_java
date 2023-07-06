package ch25_GUI;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class GUIMain1 extends JFrame {
	private final String ADMIN_USERNAME = "admin";	//바뀌면 안 됨 -> final지정
	private final String ADMIN_PASSWORD = "1234";	

	private JPanel mainCardPane;
	private JTextField usernameTextField;
	private JPasswordField PasswordTextField;
	private CardLayout maincardLayout;
	private JPanel mainPanel;
	private JPanel LoginPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIMain1 frame = new GUIMain1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
//		GUIMain1 frame = new GUIMain1();
//		frame.setVisible(true);				//false이면 화면에 보여지지 않음
	}

	/**
	 * Create the frame.
	 */
	public GUIMain1() {	//생성자만 호출이 되어지면 실행됨
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//창닫기
		setBounds(100, 100, 450, 300);						//화면 크기
		
		/* <<<< mainCardPane >>>> */
		mainCardPane = new JPanel();							//JPanel 객체 생성
		maincardLayout = new CardLayout(0, 0);
		
		mainCardPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainCardPane.setLayout(maincardLayout);

		setContentPane(mainCardPane);
		
		/* <<<< mainPanel >>>> */
		mainPanel = new JPanel();
		mainCardPane.add(mainPanel, "panel");
		mainPanel.setLayout(null);
		
		/* <<<< usernameTextField >>>> */
		usernameTextField = new JTextField();
		usernameTextField.setBounds(143, 44, 134, 21);
		mainPanel.add(usernameTextField);
		usernameTextField.setColumns(10);
		
		/* <<<< PasswordTextField >>>> */
		PasswordTextField = new JPasswordField();
		PasswordTextField.setBounds(143, 80, 134, 21);
		PasswordTextField.setColumns(10);
		mainPanel.add(PasswordTextField);
		
		/* <<<< signinBtn >>>> */
		JButton signinBtn = new JButton("Login");
		signinBtn.addMouseListener(new MouseAdapter() {	//메소드를 전부 구현해야 함 -> 추상클래스는 implement해서 내가 원하는 메소드에 대해서만 재정의
			@Override
			public void mouseClicked(MouseEvent e) {
				String username = usernameTextField.getText();
				String password = PasswordTextField.getText();	//취소선 : jdk의 다음 버전에는 없어질 수도 있는 메소드
				if(!username.equals(ADMIN_USERNAME) || !password.equals(ADMIN_PASSWORD)) { //데이터 비교했을 때 불일치할 경우를 if문으로 구현해주는 것이 좋음
					JOptionPane.showMessageDialog(mainCardPane, "aaa", "bbb", JOptionPane.ERROR_MESSAGE);
					System.out.println("사용자 정보가 일치하지 않습니다.");
					return;
				}
				JOptionPane.showMessageDialog(mainCardPane, "환영합니다", "로그인 성공", JOptionPane.PLAIN_MESSAGE);
				maincardLayout.show(mainCardPane, "LoginPanel");
			}
		});
		signinBtn.setBounds(168, 114, 88, 23);
		mainPanel.add(signinBtn);
		
		/* <<<< loginPanel >>>> */
		LoginPanel = new JPanel();
		mainCardPane.add(LoginPanel, "LoginPanel");
		LoginPanel.setLayout(null);
	}
}
