package 그래픽;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class 카운터 {

	static int count = 0;
	
	public static void main(String[] args) {
		
		JFrame f = new JFrame();
		JButton minus = new JButton();
		JButton plus = new JButton();
		JLabel l = new JLabel("0");
		FlowLayout flow = new FlowLayout();
		Font font = new Font("궁서", Font.BOLD, 40);
		Font font2 = new Font("궁서", Font.BOLD, 80);
		
		
		minus.setText("마이너스");
		plus.setText("플러스");
		
		
		minus.setFont(font);
		l.setFont(font2);
		plus.setFont(font);
		minus.setBackground(Color.orange);
		plus.setBackground(Color.yellow);
		
		
		minus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				count--;
				System.out.println("count: " + count);
				String t = String.valueOf(count);
				l.setText(t);
			}
		});
		
		plus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				count++;
				System.out.println("count: " + count);
				String t = String.valueOf(count);
				l.setText(t);
			}
		});
//		String n = Integer.toString(count);
//		l.setText(n);
		f.setSize(200, 300);
		f.add(minus);
		f.add(l);
		f.add(plus);
		f.setLayout(flow);
		
		f.setVisible(true);
	}

}
