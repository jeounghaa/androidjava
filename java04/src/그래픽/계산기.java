package 그래픽;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class 계산기 {

	public static void main(String[] args) {
		
		JFrame f = new JFrame();
		f.getContentPane().setBackground(Color.ORANGE);
		JLabel l1 = new JLabel();
		JLabel l2 = new JLabel();
		l2.setFont(new Font("굴림", Font.PLAIN, 63));
		JLabel l3 = new JLabel();
		l3.setFont(new Font("굴림", Font.PLAIN, 63));
		JTextField t1 = new JTextField();
		t1.setForeground(Color.WHITE);
		t1.setBackground(Color.LIGHT_GRAY);
		t1.setColumns(6);
		t1.setFont(new Font("굴림", Font.PLAIN, 63));
		JTextField t2 = new JTextField();
		t2.setForeground(Color.WHITE);
		t2.setBackground(Color.LIGHT_GRAY);
		t2.setColumns(6);
		t2.setFont(new Font("굴림", Font.PLAIN, 63));
		JLabel result = new JLabel();
		result.setForeground(Color.RED);
		result.setBackground(Color.WHITE);
		result.setFont(new Font("굴림", Font.PLAIN, 79));
		
		JTextField text = new JTextField();
		text.setBackground(SystemColor.textHighlight);
		text.setFont(new Font("굴림", Font.PLAIN, 36));
		text.setColumns(10);
		JButton plus = new JButton("+");
		plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s1 = t1.getText();
				String s2 = t2.getText();
				
				int n1 = Integer.parseInt(s1);
				int n2 = Integer.parseInt(s2);
				
				System.out.println("t1: " + s1);
				System.out.println("t2: " + s2);
				
				int sum = n1 + n2;
				
				//처리한 결과를 사용자에게 보여줌
				String sum2 = String.valueOf(sum);
				result.setText(sum2);
				
				if (n1 > n2) {
					text.setText("숫자 1이 더 큽니다.");
				} else if (n1 < n2) {
					text.setText("숫자2가 더 큽니다.");
				} else {
					text.setText("두 수가 같습니다.");
				}
			}
		});
		plus.setFont(new Font("굴림", Font.PLAIN, 63));
		
		
		FlowLayout flow = new FlowLayout();
		ImageIcon img = new ImageIcon("cal.png");
		

		f.setSize(400, 900);
		
		f.getContentPane().setLayout(flow);
		l1.setIcon(img);
		l2.setText("숫자1");
		l3.setText("숫자2");
		
		f.getContentPane().add(l1);
		f.getContentPane().add(l2);
		f.getContentPane().add(t1);
		f.getContentPane().add(l3);
		f.getContentPane().add(t2);
		f.getContentPane().add(plus);
		
		JButton min = new JButton("-");
		min.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s1 = t1.getText();
				String s2 = t2.getText();
				
				int n1 = Integer.parseInt(s1);
				int n2 = Integer.parseInt(s2);
				
				System.out.println("t1: " + s1);
				System.out.println("t2: " + s2);
				
				int sum = n1 - n2;
				
				//처리한 결과를 사용자에게 보여줌
				String sum2 = String.valueOf(sum);
				result.setText(sum2);
				
				if (n1 > n2) {
					text.setText("숫자 1이 더 큽니다.");
				} else if (n1 < n2) {
					text.setText("숫자2가 더 큽니다.");
				} else {
					text.setText("두 수가 같습니다.");
				}
			}
		});
		min.setFont(new Font("굴림", Font.PLAIN, 63));
		f.getContentPane().add(min);
		
		JButton mul = new JButton("*");
		mul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s1 = t1.getText();
				String s2 = t2.getText();
				
				System.out.println("t1: " + s1);
				System.out.println("t2: " + s2);
				
				//산술연산을 하려면 숫자로 변환
				int n1 = Integer.parseInt(s1);
				int n2 = Integer.parseInt(s2);
				
				int sum = n1 * n2;
				
				//처리한 결과를 사용자에게 보여줌
				String sum2 = String.valueOf(sum);
				result.setText(sum2);
				
				if (n1 > n2) {
					text.setText("숫자 1이 더 큽니다.");
				} else if (n1 < n2) {
					text.setText("숫자2가 더 큽니다.");
				} else {
					text.setText("두 수가 같습니다.");
				}
			}
		});
		mul.setFont(new Font("굴림", Font.PLAIN, 63));
		f.getContentPane().add(mul);
		
		JButton div = new JButton("/");
		div.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s1 = t1.getText();
				String s2 = t2.getText();
				
				int n1 = Integer.parseInt(s1);
				int n2 = Integer.parseInt(s2);
				
				System.out.println("t1: " + s1);
				System.out.println("t2: " + s2);
				
				int sum = n1 / n2;
				
				//처리한 결과를 사용자에게 보여줌
				String sum2 = String.valueOf(sum);
				result.setText(sum2);
				
				if (n1 > n2) {
					text.setText("숫자 1이 더 큽니다.");
				} else if (n1 < n2) {
					text.setText("숫자2가 더 큽니다.");
				} else {
					text.setText("두 수가 같습니다.");
				}
			}
		});
		div.setFont(new Font("굴림", Font.PLAIN, 63));
		f.getContentPane().add(div);
		f.getContentPane().add(result);
		f.getContentPane().add(text);
		

		f.setVisible(true);
	}

}
