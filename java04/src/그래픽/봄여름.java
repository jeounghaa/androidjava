package 그래픽;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class 봄여름 {

	public static void main(String[] args) {
		JFrame f = new JFrame();
		JButton spring = new JButton();
		JButton summer = new JButton();
		Font font = new Font("궁서", Font.BOLD, 90);
		FlowLayout flow = new FlowLayout();

		spring.setText("봄");
		summer.setText("여름");

		spring.setBackground(Color.yellow);
		summer.setBackground(Color.pink);

		spring.setForeground(Color.blue);
		summer.setForeground(Color.green);
		spring.setFont(font);
		summer.setFont(font);
		
		spring.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(f, "선선해요");
			}
		});
		
		summer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(f, "더워요");
			}
		});

		f.setLayout(flow);
		f.setSize(300, 300);
		f.add(spring);
		f.add(summer);
		f.setVisible(true);
	}

}
