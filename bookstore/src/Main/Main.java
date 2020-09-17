package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Book.BookDetail;
import Book.BookList;
import DB.BookDAO;
import DB.BookVO;
import Order.Cart;
import Order.OrderCon;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	String field;

	public static void main(String[] args) {
		new Main();
	}

	public Main() {
		getContentPane().setBackground(new Color(95, 158, 160));
		setTitle("BookStore");
		JLabel l0 = new JLabel("도서구매");
		l0.setBounds(47, 101, 177, 41);
		l0.setFont(new Font("굴림", Font.PLAIN, 40));
		JButton b1 = new JButton("장바구니");
		b1.setBackground(new Color(250, 250, 210));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Cart();
				// 이동하면서 현재 창 비활성화
				setVisible(false);
			}
		});
		b1.setBounds(580, 218, 119, 31);
		b1.setFont(new Font("굴림", Font.PLAIN, 20));
		JButton b2 = new JButton("주문배송");
		b2.setBackground(new Color(250, 250, 210));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new OrderCon();
				// 이동하면서 현재 창 비활성화
				setVisible(false);
			}
		});
		b2.setBounds(717, 217, 119, 33);
		b2.setFont(new Font("굴림", Font.PLAIN, 20));
		JButton b3 = new JButton("베스트설러");
		b3.setBackground(new Color(250, 250, 210));
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BookList(b3.getText().substring(0, 2));
				// 이동하면서 현재 창 비활성화
				setVisible(false);
			}
		});
		b3.setFont(new Font("굴림", Font.PLAIN, 20));
		b3.setBounds(168, 319, 154, 118);
		JButton b4 = new JButton("국내도서");
		b4.setBackground(new Color(250, 250, 210));
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BookList(b4.getText().substring(0, 2));
				// 이동하면서 현재 창 비활성화
				setVisible(false);
			}
		});
		b4.setFont(new Font("굴림", Font.PLAIN, 20));
		b4.setBounds(375, 319, 154, 118);
		JButton b5 = new JButton("국외도서");
		b5.setBackground(new Color(250, 250, 210));
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BookList(b5.getText().substring(0, 2));
				// 이동하면서 현재 창 비활성화
				setVisible(false);
			}
		});
		b5.setFont(new Font("굴림", Font.PLAIN, 20));
		b5.setBounds(567, 319, 154, 118);

		JButton b6 = new JButton();

		b6.setBackground(new Color(0, 0, 0));
		b6.setBounds(75, 614, 160, 202);
		JButton b7 = new JButton();

		b7.setBackground(new Color(0, 0, 0));
		b7.setBounds(260, 614, 160, 202);
		JButton b8 = new JButton();

		b8.setBackground(new Color(0, 0, 0));
		b8.setBounds(444, 614, 160, 202);
		JButton b9 = new JButton();

		b9.setBackground(Color.BLACK);
		b9.setBounds(627, 614, 160, 202);

		JLabel l1 = new JLabel("이 달의 책");
		l1.setFont(new Font("굴림", Font.PLAIN, 25));
		l1.setBounds(29, 540, 112, 41);

		JLabel l2 = new JLabel("유저이름", SwingConstants.RIGHT);
		l2.setFont(new Font("굴림", Font.PLAIN, 20));
		l2.setBounds(652, 119, 184, 41);
		getContentPane().add(l2);
		// 로그인한 유저의 아이디
		l2.setText(Login.Login.userid + "님");

		// 이 달의 책 이미지
		// 재고가 많이 남은 순으로
		BookDAO bookdao = new BookDAO();
		ImageIcon images[] = new ImageIcon[4]; // 이미지배열
		int bookcode[] = new int[4]; // 책코드배열

		try {
			ArrayList<BookVO> list = bookdao.month();
			for (int i = 0; i < images.length; i++) {
				BookVO bag = list.get(i);
				images[i] = new ImageIcon("src/BookImage/" + bag.getImage());
				bookcode[i] = bag.getBookcode();
			}

			b6.setIcon(new ImageIcon(images[0].getImage().getScaledInstance(150, 200, Image.SCALE_SMOOTH)));
			b7.setIcon(new ImageIcon(images[1].getImage().getScaledInstance(150, 200, Image.SCALE_SMOOTH)));
			b8.setIcon(new ImageIcon(images[2].getImage().getScaledInstance(150, 200, Image.SCALE_SMOOTH)));
			b9.setIcon(new ImageIcon(images[3].getImage().getScaledInstance(150, 200, Image.SCALE_SMOOTH)));

			// 이 달의 책 누르면 해당 책의 세부사항으로 이동
			b6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new BookDetail(bookcode[0]);
					// 이동하면서 현재 창 비활성화
					setVisible(false);
				}
			});

			b7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new BookDetail(bookcode[1]);
					// 현재 창 비활성화
					setVisible(false);
				}
			});

			b8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new BookDetail(bookcode[2]);
					// 이동하면서 현재 창 비활성화
					setVisible(false);
				}
			});

			b9.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new BookDetail(bookcode[3]);
					// 이동하면서 현재 창 비활성화
					setVisible(false);
				}
			});
		} catch (Exception e1) {
			System.out.println("이 달의 책 가져오다가 에러");
			e1.printStackTrace();
		}

		setSize(900, 1000);
		getContentPane().setLayout(null);

		getContentPane().add(l0);
		getContentPane().add(b1);
		getContentPane().add(b2);
		getContentPane().add(b3);
		getContentPane().add(b4);
		getContentPane().add(b5);
		getContentPane().add(l1);
		getContentPane().add(b6);
		getContentPane().add(b7);
		getContentPane().add(b8);
		getContentPane().add(b9);

		setVisible(true);
	}

}
