package 인터페이스;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class 나의윈도우2 extends JFrame {

	public 나의윈도우2() {
		setTitle("인터페이스 사용해보자");
		setSize(300, 300);
		setLayout(new FlowLayout());

		JButton b1 = new JButton("Button1");
		JButton b2 = new JButton("Button2");
		JButton b3 = new JButton("결과가 나타나는 버튼!");
		add(b1);
		add(b2);
		add(b3);
		
		b1.addActionListener(new 이벤트처리클래스());
		b2.addActionListener(new 이벤트처리클래스2());
		
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new 나의윈도우2();
	
	}

}
