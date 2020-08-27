package 배열정리;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class 음식배열 {

	static int count = 0;
	static int money = 0;
	
	public static void main(String[] args) {
		
		JFrame f = new JFrame();
		
		JLabel l1 = new JLabel("개수입력");
		l1.setBounds(371, 14, 57, 15);
		f.getContentPane().add(l1);
		
		// 몇개를 선택했는지 나타냄
		JTextField tf = new JTextField();
		tf.setText("0개");
		tf.setBounds(429, 11, 116, 21);
		f.getContentPane().add(tf);
		tf.setColumns(10);
		
		// 이미지를 넣을 변수
		JLabel l2 = new JLabel("New label");
		l2.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\f1.png"));
		l2.setBounds(25, 54, 534, 325);
		f.getContentPane().add(l2);
		
		JLabel lblNewLabel_1 = new JLabel("지불할 총 금액");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1.setBounds(94, 400, 193, 28);
		f.getContentPane().add(lblNewLabel_1);
		
		// 총 얼마를 지불해야하는지 나타냄
		JLabel price = new JLabel("0원");
		price.setForeground(new Color(128, 0, 0));
		price.setFont(new Font("굴림", Font.BOLD, 20));
		price.setBounds(276, 400, 193, 28);
		f.getContentPane().add(price);
		
		f.setSize(600, 500);
		f.getContentPane().setLayout(null);
		
		
		JButton f1 = new JButton("짬뽕");
		f1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 버튼을 선택하면 이미지 변경
				ImageIcon icon = new ImageIcon("C:\\Users\\Administrator\\Desktop\\f1.png");
				l2.setIcon(icon);
				// 선택변수 1증가
				count++;
				// 선택횟수변수 값 변경
				tf.setText(count + "개");
				// 가격변수 증가
				money += 4000;
				// 가격변수 값 변경
				price.setText(money + "원");
			}
		});
		f1.setBounds(12, 10, 97, 23);
		f.getContentPane().add(f1);
		
		JButton f2 = new JButton("우동");
		f2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 버튼을 선택하면 이미지 변경
				ImageIcon icon = new ImageIcon("C:\\Users\\Administrator\\Desktop\\f2.jpg");
				l2.setIcon(icon);
				// 선택횟수변수 1증가
				count++;
				// 선택횟수변수 값 변경
				tf.setText(count + "개");
				// 가격변수 증가
				money += 4500;
				// 가격변수 값 변경
				price.setText(money + "원");
			}
		});
		f2.setBounds(121, 10, 97, 23);
		f.getContentPane().add(f2);
		
		JButton f3 = new JButton("짜장");
		f3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 버튼을 선택하면 이미지 변경
				ImageIcon icon = new ImageIcon("C:\\Users\\Administrator\\Desktop\\f3.jpg");
				l2.setIcon(icon);
				// 선택횟수변수 1증가
				count++;
				// 선택횟수변수 값 변경
				tf.setText(count + "개");
				// 가격변수 증가
				money += 5000;
				// 가격변수 값 변경
				price.setText(money + "원");
			}
		});
		f3.setBounds(229, 10, 97, 23);
		f.getContentPane().add(f3);
		
		f.setVisible(true);
	}
}
