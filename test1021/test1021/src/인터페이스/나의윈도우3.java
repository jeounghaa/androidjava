package 인터페이스;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class 나의윈도우3 extends JFrame implements ActionListener{

	JButton b1, b2, b3;
	
	public 나의윈도우3() {
		setTitle("인터페이스 사용해보자");
		setSize(300, 300);
		setLayout(new FlowLayout());

		b1 = new JButton("Button1");
		b2 = new JButton("Button2");
		b3 = new JButton("결과가 나타나는 버튼!");
		
		add(b1);
		add(b2);
		add(b3);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new 나의윈도우3();
	
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		String result = "";
		if (a.getSource() == b1) {
			result = "버튼1";
		} else {
			result = "버튼2";
		}
		b3.setText(result + "을 눌렀음");
	}

}
