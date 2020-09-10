package db연결;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class BbsUI {
	private static JTextField t1;
	private static JTextField t2;
	private static JTextField t3;

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.getContentPane().setFont(new Font("Dialog", Font.BOLD, 18));
		f.getContentPane().setBackground(new Color(204, 153, 255));
		f.setSize(814, 700);
		f.getContentPane().setLayout(null);

		JLabel no = new JLabel("NO");
		no.setFont(new Font("Dialog", Font.BOLD, 18));
		no.setBounds(36, 51, 62, 18);
		f.getContentPane().add(no);

		JLabel lblTitle = new JLabel("TITLE");
		lblTitle.setFont(new Font("Dialog", Font.BOLD, 18));
		lblTitle.setBounds(36, 167, 62, 18);
		f.getContentPane().add(lblTitle);

		JLabel lblContent = new JLabel("CONTENT");
		lblContent.setFont(new Font("Dialog", Font.BOLD, 18));
		lblContent.setBounds(36, 220, 100, 18);
		f.getContentPane().add(lblContent);

		JLabel lblWriter = new JLabel("WRITER");
		lblWriter.setFont(new Font("Dialog", Font.BOLD, 18));
		lblWriter.setBounds(36, 108, 80, 18);
		f.getContentPane().add(lblWriter);

		t1 = new JTextField();
		t1.setBackground(new Color(255, 245, 238));
		t1.setFont(new Font("굴림", Font.BOLD, 20));
		t1.setBounds(156, 40, 180, 40);
		f.getContentPane().add(t1);
		t1.setColumns(10);

		t2 = new JTextField();
		t2.setBackground(new Color(255, 245, 238));
		t2.setFont(new Font("굴림", Font.BOLD, 20));
		t2.setColumns(10);
		t2.setBounds(156, 97, 180, 40);
		f.getContentPane().add(t2);

		t3 = new JTextField();
		t3.setBackground(new Color(255, 245, 238));
		t3.setFont(new Font("굴림", Font.BOLD, 20));
		t3.setColumns(10);
		t3.setBounds(156, 156, 180, 40);
		f.getContentPane().add(t3);

		JTextArea t4 = new JTextArea();
		t4.setBackground(new Color(255, 245, 238));
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
		create.setBounds(53, 447, 120, 35);
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
		select.setBounds(203, 447, 120, 35);
		f.getContentPane().add(select);

		JButton update = new JButton("UPDATE");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int no = Integer.parseInt(t1.getText());
				String title = t3.getText();
				String content = t4.getText();
				BbsDAO dao = new BbsDAO();

				try {
					dao.update(no, title, content);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		update.setFont(new Font("굴림", Font.BOLD, 18));
		update.setBounds(53, 494, 120, 35);
		f.getContentPane().add(update);

		JButton delete = new JButton("DELETE");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int no = Integer.parseInt(t1.getText());
				BbsDAO dao = new BbsDAO();
				try {
					dao.delete(no);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		delete.setFont(new Font("굴림", Font.BOLD, 18));
		delete.setBounds(203, 494, 120, 35);
		f.getContentPane().add(delete);

		JTextArea all = new JTextArea();
		all.setBackground(new Color(255, 245, 238));
		all.setFont(new Font("Monospaced", Font.PLAIN, 17));
		all.setBounds(376, 50, 385, 526);
		f.getContentPane().add(all);
		
		JButton read = new JButton("전체목록");
		read.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BbsDAO dao = new BbsDAO();
					ArrayList<BbsVO> list = dao.all();
					System.out.println("게시판의 개수: " + list.size());
					for (int i = 0; i < list.size(); i++) { // 속성개수
						BbsVO bag = list.get(i);
						all.append(bag.getNo() + ", " + bag.getWriter() + ", " +  bag.getTitle() 
							+ ", " + bag.getContent() + ", "  + "\n");
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		read.setFont(new Font("굴림", Font.BOLD, 18));
		read.setBounds(129, 541, 120, 35);
		f.getContentPane().add(read);

		f.setVisible(true);
	}
}
