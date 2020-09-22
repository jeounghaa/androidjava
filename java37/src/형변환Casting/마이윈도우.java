package 형변환Casting;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class 마이윈도우 {

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setTitle("나의 윈도우");
		f.setSize(400, 400);
		
		JButton b = new JButton("나는 버튼");
		JLabel l = new JLabel("나는 라벨");
		JPanel p = new JPanel();
		p.setBackground(Color.yellow);
		f.setLayout(new FlowLayout());
		f.add(p);
		f.add(l);
		f.add(b);
		Font font = new Font("바탕", Font.BOLD, 50);
		b.setFont(font);
		l.setFont(font);
		
		f.setVisible(true);
	}

}
