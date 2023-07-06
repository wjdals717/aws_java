package ch25_GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUIMain2 extends JFrame {

	private JPanel mainCardPane;
	private CardLayout maincardLayout;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIMain2 frame = new GUIMain2();
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
	public GUIMain2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		/* <<<< mainCardPane >>>> */
		mainCardPane = new JPanel();
		maincardLayout = new CardLayout(0, 0);				//객체 생성해서 메소드를 사용할 수 있게 됨
		
		mainCardPane.setBorder(new EmptyBorder(5, 5, 5, 5));	//EmptyBorder : 테두리
		mainCardPane.setLayout(maincardLayout);				//레이아웃 지정

		setContentPane(mainCardPane);
		
		/* <<<< subPanel1 >>>> */
		JPanel subPanel1 = new JPanel();
		mainCardPane.add(subPanel1, "subPanel1");
		subPanel1.setLayout(null);
		
		JButton SubPanel2ShowBtn = new JButton("2번 페이지");
		SubPanel2ShowBtn.setBounds(319, 111, 95, 23);
		subPanel1.add(SubPanel2ShowBtn);
		
		SubPanel2ShowBtn.addMouseListener(new MouseAdapter() {	//이벤트(마우스리스터)는 마지막에 배치
			@Override
			public void mouseClicked(MouseEvent e) {
				maincardLayout.show(mainCardPane, "subPanel2");	//mainCardPane들 중 subPanel2를 보여줌
			}
		});
		
		/* <<<< subPanel2 >>>> */
		JPanel subPanel2 = new JPanel();
		mainCardPane.add(subPanel2, "subPanel2");
		subPanel2.setLayout(null);
		
		JButton subPanel1ShowBtn = new JButton("1번 페이지");
		subPanel1ShowBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				maincardLayout.show(mainCardPane, "subPanel1");
			}
		});
		subPanel1ShowBtn.setBounds(12, 118, 95, 23);
		subPanel2.add(subPanel1ShowBtn);
		
		/* <<<< subPanel3 >>>> */
		JButton subPanel3ShowBtn = new JButton("3번 페이지");
		subPanel3ShowBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				maincardLayout.show(mainCardPane, "subPanel3");
			}
		});
		subPanel3ShowBtn.setBounds(319, 118, 95, 23);
		subPanel2.add(subPanel3ShowBtn);
		
		JPanel subPanel3 = new JPanel();
		mainCardPane.add(subPanel3, "subPanel3");
		subPanel3.setLayout(null);
		
		JButton subPanel2ShowBtn2 = new JButton("2번 페이지");
		subPanel2ShowBtn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				maincardLayout.show(mainCardPane, "subPanel2");
			}
		});
		subPanel2ShowBtn2.setBounds(12, 117, 95, 23);
		subPanel3.add(subPanel2ShowBtn2);
	}
}
