package Login;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Start extends JFrame {
	public Start() {
		getContentPane().setBackground(new Color(95, 158, 160));
		setTitle("BookStore");;
		setSize(500, 500);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("BookStore");
		lblNewLabel.setBounds(135, 104, 211, 47);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 40));
		getContentPane().add(lblNewLabel);

		JButton b1 = new JButton("로그인");
		b1.setBackground(new Color(250, 250, 210));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 로그인 창으로 이동
				new Login();
				// 이동하면서 현재 창 비활성화
				setVisible(false);
			}
		});
		b1.setFont(new Font("굴림", Font.BOLD, 35));
		b1.setBounds(140, 210, 200, 80);
		getContentPane().add(b1);

		JButton b2 = new JButton("회원가입");
		b2.setBackground(new Color(250, 250, 210));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 회원가입 창으로 이동
				new Register();
				// 이동하면서 현재 창 비활성화
				setVisible(false);
			}
		});
		b2.setFont(new Font("굴림", Font.BOLD, 35));
		b2.setBounds(140, 311, 200, 80);
		getContentPane().add(b2);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Start();
	}
}
