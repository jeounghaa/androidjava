package ����ȯCasting;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ���������� {

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setTitle("���� ������");
		f.setSize(400, 400);
		
		JButton b = new JButton("���� ��ư");
		JLabel l = new JLabel("���� ��");
		JPanel p = new JPanel();
		p.setBackground(Color.yellow);
		f.setLayout(new FlowLayout());
		f.add(p);
		f.add(l);
		f.add(b);
		Font font = new Font("����", Font.BOLD, 50);
		b.setFont(font);
		l.setFont(font);
		
		f.setVisible(true);
	}

}
