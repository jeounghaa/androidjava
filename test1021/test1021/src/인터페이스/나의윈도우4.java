package 인터페이스;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class 나의윈도우4 extends JFrame {

	JButton b1, b2, b3;
	
	public 나의윈도우4() {
		setTitle("인터페이스 사용해보자");
		setSize(200, 300);
		setLayout(new FlowLayout());

		b1 = new JButton("Button1");
		b2 = new JButton("Button2");
		b3 = new JButton("결과가 나타나는 버튼!");
		
		add(b1);
		add(b2);
		add(b3);
		
		// 익명클래스 객체를 생성
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				b3.setText("버튼1을 눌렀음");
			}
		});
		
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				b3.setText("버튼2를 눌렀음");
			}
		});
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new 나의윈도우4();
	
	}

}
