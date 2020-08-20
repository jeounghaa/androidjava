package 그래픽;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class 나의그래픽 {

	public static void main(String[] args) {
		// 자바는 부품조립식 코드 -> 객체지향형 프로그래밍(OOP)
		// ctrl + shift + o: 자동 import

		JFrame f = new JFrame(); // new는 복사의 의미
		JButton b1 = new JButton();
		JButton b2 = new JButton();
		JButton b3 = new JButton();
		ImageIcon img = new ImageIcon("sky.PNG");
		FlowLayout flow = new FlowLayout();

		f.setSize(800, 700);
		b1.setText("누르세요");
		b2.setText("누르세요");
		b3.setIcon(img);
		f.getContentPane().setLayout(flow);

		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(f, "버튼 1 입니다.");
			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(f, "버튼 2 입니다.");
			}
		});
		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(f, "하늘 사진입니다.");
			}
		});

		f.getContentPane().add(b1);
		f.getContentPane().add(b2);
		f.getContentPane().add(b3);

		f.setVisible(true);
	}

}
