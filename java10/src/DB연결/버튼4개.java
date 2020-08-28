package DB연결;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class 버튼4개 {

	public static void main(String[] args) {
		JFrame f = new JFrame();
		
		DB처리전담 db = new DB처리전담();
		
		
		JButton btnCreate = new JButton("CREATE");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				db.create(f);
			}
		});
		btnCreate.setFont(new Font("굴림", Font.BOLD, 17));
		btnCreate.setBounds(82, 111, 120, 50);
		f.getContentPane().add(btnCreate);
		
		JButton btnRead = new JButton("READ");
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				db.read();
			}
		});
		btnRead.setFont(new Font("굴림", Font.BOLD, 17));
		btnRead.setBounds(279, 111, 120, 50);
		f.getContentPane().add(btnRead);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				db.update();
			}
		});
		btnUpdate.setFont(new Font("굴림", Font.BOLD, 17));
		btnUpdate.setBounds(82, 272, 120, 50);
		f.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				db.delete();
			}
		});
		btnDelete.setFont(new Font("굴림", Font.BOLD, 17));
		btnDelete.setBounds(279, 272, 120, 50);
		f.getContentPane().add(btnDelete);
		
		
		
		f.setSize(500, 500);
		f.getContentPane().setLayout(null);
		f.setVisible(true);
	}
}
