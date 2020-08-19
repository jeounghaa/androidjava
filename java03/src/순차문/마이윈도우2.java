package 순차문;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Label;
import javax.swing.JLabel;

public class 마이윈도우2 {
	private static JTextField textField;

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(500, 500);
		
		JButton btnNewButton = new JButton("누르세요");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(f, "누르셨습니다.");
			}
		});
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 18));
		f.getContentPane().add(btnNewButton, BorderLayout.EAST);
		
		textField = new JTextField();
		f.getContentPane().add(textField, BorderLayout.CENTER);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("확인");
		f.getContentPane().add(btnNewButton_1, BorderLayout.SOUTH);
		
		JLabel lblNewLabel = new JLabel("흠");
		f.getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		
		JButton btnNewButton_2 = new JButton("New button");
		f.getContentPane().add(btnNewButton_2, BorderLayout.WEST);
		f.setVisible(true);
	}

}
