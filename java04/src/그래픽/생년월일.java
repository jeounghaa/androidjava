package 그래픽;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class 생년월일 {

	public static void main(String[] args) {
		JFrame f = new JFrame();
		JLabel lname = new JLabel("이름");
		lname.setFont(new Font("굴림", Font.PLAIN, 22));
		JTextField name = new JTextField();
		name.setFont(new Font("굴림", Font.PLAIN, 22));
		name.setColumns(10);
		JLabel lbir = new JLabel("생년월일");
		lbir.setFont(new Font("굴림", Font.PLAIN, 22));
		JTextField bir = new JTextField();
		bir.setFont(new Font("굴림", Font.PLAIN, 22));
		bir.setColumns(10);
		JLabel text = new JLabel();
		text.setForeground(new Color(128, 0, 0));
		text.setFont(new Font("굴림", Font.PLAIN, 22));
		JButton result = new JButton("결과");
		result.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String b = bir.getText();
				String na = name.getText();
				String bir = b.substring(0, 2);
				int n = Integer.parseInt(bir);
				if ((n >= 00 && n <= 03) || (n >= 21 && n <= 99)) {
					text.setText(na + "은 성인입니다.");
				} else {
					text.setText(na + "은 미성년입니다.");
				}
			}
		});
		result.setFont(new Font("굴림", Font.PLAIN, 22));
		FlowLayout flow = new FlowLayout();

		f.setSize(300, 200);
		f.getContentPane().add(lname);
		f.getContentPane().add(name);
		f.getContentPane().add(lbir);
		f.getContentPane().add(bir);
		f.getContentPane().add(result);
		f.getContentPane().setLayout(flow);
		f.getContentPane().add(text);

		f.setVisible(true);
	}

}
