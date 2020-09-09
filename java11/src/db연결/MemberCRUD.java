package db연결;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;

public class MemberCRUD {

	public static void main(String[] args) {
		MemberDAO db = new MemberDAO();
		
		JFrame f = new JFrame();
		f.getContentPane().setFont(new Font("Dialog", Font.BOLD, 20));
		f.getContentPane().setBackground(SystemColor.activeCaption);
		
		JTextField t1 = new JTextField();
		t1.setBounds(160, 64, 160, 41);
		
		JTextField t2 = new JTextField();
		t2.setBounds(160, 117, 160, 41);
		
		JTextField t3 = new JTextField();
		t3.setBounds(160, 166, 160, 41);
		
		JTextField t4 = new JTextField();
		t4.setBounds(160, 221, 160, 41);
		
		JButton create = new JButton("CREATE");
		create.setBackground(new Color(135, 206, 235));
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = t1.getText();
				String pw = t2.getText();
				String name = t3.getText();
				String tel = t4.getText();
				// 생성버튼
				try {
					db.create(id, pw, name, tel);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		create.setFont(new Font("굴림", Font.BOLD, 18));
		create.setBounds(45, 287, 125, 40);
		
		JButton read = new JButton("READ");
		read.setBackground(new Color(135, 206, 235));
		read.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 조회버튼
				String id = t1.getText();
				MemberDAO db = new MemberDAO();
				try {
					int result = db.read(id);
					if (result == 1) {
						t2.setText("");
						t3.setText("");
						t4.setText("");
						t1.setBackground(Color.WHITE);
						t2.setBackground(Color.WHITE);
						t3.setBackground(Color.WHITE);
						t4.setBackground(Color.WHITE);
					} else {
						t1.setText("없음");
						t2.setText("없음");
						t3.setText("없음");
						t4.setText("없음");
						t1.setBackground(Color.gray);
						t2.setBackground(Color.gray);
						t3.setBackground(Color.gray);
						t4.setBackground(Color.gray);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		read.setFont(new Font("굴림", Font.BOLD, 18));
		read.setBounds(206, 287, 125, 40);
		
		JButton update = new JButton("UPDATE");
		update.setBackground(new Color(135, 206, 235));
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//수정버튼
				String id = t1.getText();
				String tel = t4.getText();
				try {
					db.update(tel, id);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		update.setFont(new Font("굴림", Font.BOLD, 18));
		update.setBounds(45, 364, 125, 40);
		
		JButton delete = new JButton("DELETE");
		delete.setBackground(new Color(135, 206, 235));
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//삭제버튼
				String id = t1.getText();
				try {
					db.delete(id);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		delete.setFont(new Font("굴림", Font.BOLD, 18));
		delete.setBounds(206, 364, 125, 40);
		Font font = new Font("굴림", Font.BOLD, 15);
		f.getContentPane().setLayout(null);
		
		JLabel id = new JLabel("ID");
		id.setFont(new Font("굴림", Font.BOLD, 18));
		id.setBounds(56, 64, 62, 38);
		f.getContentPane().add(id);
		f.getContentPane().add(t1);
		
		JLabel pw = new JLabel("PW");
		pw.setFont(new Font("굴림", Font.BOLD, 18));
		pw.setBounds(56, 117, 62, 38);
		f.getContentPane().add(pw);
		f.getContentPane().add(t2);
		
		JLabel name = new JLabel("NAME");
		name.setFont(new Font("굴림", Font.BOLD, 18));
		name.setBounds(56, 166, 62, 40);
		f.getContentPane().add(name);
		f.getContentPane().add(t3);
		
		JLabel tel = new JLabel("TEL");
		tel.setFont(new Font("굴림", Font.BOLD, 18));
		tel.setBounds(56, 229, 62, 18);
		f.getContentPane().add(tel);
		f.getContentPane().add(t4);
		
		f.getContentPane().add(create);
		f.getContentPane().add(read);
		f.getContentPane().add(update);
		f.getContentPane().add(delete);
		t1.setFont(new Font("Dialog", Font.BOLD, 20));
		t2.setFont(new Font("Dialog", Font.BOLD, 20));
		t3.setFont(new Font("Dialog", Font.BOLD, 20));
		t4.setFont(new Font("Dialog", Font.BOLD, 20));
		
		f.setSize(400, 500);
		
		f.setVisible(true);
	}
}
