package db연결;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BbsUI {
	private static JTextField t1;
	private static JTextField t2;
	private static JTextField t3;

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(400, 600);
		f.getContentPane().setLayout(null);

		JLabel no = new JLabel("NO");
		no.setFont(new Font("굴림", Font.BOLD, 20));
		no.setBounds(36, 51, 62, 18);
		f.getContentPane().add(no);

		JLabel lblTitle = new JLabel("TITLE");
		lblTitle.setFont(new Font("굴림", Font.BOLD, 20));
		lblTitle.setBounds(36, 167, 62, 18);
		f.getContentPane().add(lblTitle);

		JLabel lblContent = new JLabel("CONTENT");
		lblContent.setFont(new Font("굴림", Font.BOLD, 20));
		lblContent.setBounds(36, 220, 100, 18);
		f.getContentPane().add(lblContent);

		JLabel lblWriter = new JLabel("WRITER");
		lblWriter.setFont(new Font("굴림", Font.BOLD, 20));
		lblWriter.setBounds(36, 108, 80, 18);
		f.getContentPane().add(lblWriter);

		t1 = new JTextField();
		t1.setFont(new Font("굴림", Font.BOLD, 20));
		t1.setBounds(156, 40, 180, 40);
		f.getContentPane().add(t1);
		t1.setColumns(10);

		t2 = new JTextField();
		t2.setFont(new Font("굴림", Font.BOLD, 20));
		t2.setColumns(10);
		t2.setBounds(156, 97, 180, 40);
		f.getContentPane().add(t2);

		t3 = new JTextField();
		t3.setFont(new Font("굴림", Font.BOLD, 20));
		t3.setColumns(10);
		t3.setBounds(156, 156, 180, 40);
		f.getContentPane().add(t3);

		JTextArea t4 = new JTextArea();
		t4.setFont(new Font("굴림", Font.BOLD, 18));
		t4.setRows(5);
		t4.setTabSize(50);
		t4.setBounds(36, 250, 303, 171);
		f.getContentPane().add(t4);

		JButton create = new JButton("CREATE");
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int no = Integer.parseInt(t1.getText());
				String writer = t2.getText();
				String title = t3.getText();
				String content = t4.getText();

				BbsVO bag = new BbsVO();
				bag.setNo(no);
				bag.setWriter(writer);
				bag.setTitle(title);
				bag.setContent(content);

				BbsDAO dao = new BbsDAO();
				try {
					dao.create(bag);
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		create.setFont(new Font("굴림", Font.BOLD, 18));
		create.setBounds(36, 449, 120, 35);
		f.getContentPane().add(create);
		
		JButton select = new JButton("SELECT");
		select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int no = Integer.parseInt(t1.getText());
				BbsDAO dao = new BbsDAO();
				try {
					BbsVO vo = dao.select(no);
					t2.setText(vo.getWriter());
					t3.setText(vo.getTitle());
					t4.setText(vo.getContent());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		select.setFont(new Font("굴림", Font.BOLD, 18));
		select.setBounds(186, 449, 120, 35);
		f.getContentPane().add(select);
		
		JButton update = new JButton("UPDATE");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int no = Integer.parseInt(t1.getText());
				BbsDAO dao = new BbsDAO();
				try {
					dao.update(no);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		update.setFont(new Font("굴림", Font.BOLD, 18));
		update.setBounds(36, 496, 120, 35);
		f.getContentPane().add(update);
		f.setVisible(true);
	}
}
