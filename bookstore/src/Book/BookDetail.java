package Book;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import DB.BookDAO;
import DB.BookOrderDAO;
import DB.BookOrderVO;
import DB.BookVO;
import Login.Login;
import Main.Main;
import Order.Cart;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class BookDetail extends JFrame {

	public BookDetail(int bc) {
		getContentPane().setBackground(new Color(95, 158, 160));
		setSize(900, 1000);
		getContentPane().setLayout(null);

		// 도서이미지를 넣을 label
		JLabel l1 = new JLabel();
		l1.setBounds(77, 97, 241, 334);
		getContentPane().add(l1);

		JLabel l2 = new JLabel("도서제목");
		l2.setFont(new Font("굴림", Font.PLAIN, 22));
		l2.setBounds(390, 119, 397, 43);
		getContentPane().add(l2);

		JLabel l3 = new JLabel("작가");
		l3.setFont(new Font("굴림", Font.PLAIN, 22));
		l3.setBounds(390, 195, 397, 43);
		getContentPane().add(l3);

		JLabel l4 = new JLabel("출판사");
		l4.setFont(new Font("굴림", Font.PLAIN, 22));
		l4.setBounds(390, 282, 370, 43);
		getContentPane().add(l4);

		JLabel l5 = new JLabel("가격");
		l5.setFont(new Font("굴림", Font.PLAIN, 22));
		l5.setBounds(390, 373, 162, 43);
		getContentPane().add(l5);

		JLabel l6 = new JLabel("분야>");
		l6.setFont(new Font("굴림", Font.PLAIN, 22));
		l6.setBounds(77, 443, 370, 43);
		getContentPane().add(l6);

		JTextArea ta = new JTextArea();
		ta.setFont(new Font("Monospaced", Font.PLAIN, 16));
		ta.setBounds(77, 505, 729, 342);
		ta.setLineWrap(true);
		// 내용이 많을 경우 scroll되게
		JScrollPane js = new JScrollPane(ta);
		js.setBounds(77, 505, 729, 342);
		getContentPane().add(js);

		JLabel l7 = new JLabel("<");
		l7.setFont(new Font("굴림", Font.PLAIN, 40));
		l7.setBounds(25, 25, 62, 43);
		l7.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// 메인으로 이동
				new Main();
				// 이동하면서 현재 창 비활성화
				setVisible(false);
			}
		});
		getContentPane().add(l7);

		// 도서 상세 DB 가져오기
		BookDAO bookdao = new BookDAO();
		// 현재 로그인한 유저 아이디
		String usercode = Login.userid;

		try {
			// 도서번호에따른 도서정보
			BookVO vo = bookdao.read(bc);
			System.out.println(vo.getImage());
			String image = vo.getImage();
			l2.setText(vo.getTitle());
			setTitle(vo.getTitle());
			l3.setText(vo.getWriter());
			l4.setText(vo.getPublisher());
			l5.setText(Integer.toString(vo.getPrice()));
			l6.setText("분야> " + vo.getField().substring(0, 2) + "> " + vo.getField().substring(2));
			ta.setText(vo.getIntro());
			// 도서 이미지주소 string으로 가져와서 imageicon으로 넣기
			// 이미지 크기 변경
			ImageIcon oriIcon1 = new ImageIcon("src/BookImage/" + image);
			Image oriImg1 = oriIcon1.getImage();
			Image chimg1 = oriImg1.getScaledInstance(230, 300, Image.SCALE_SMOOTH);
			ImageIcon i1 = new ImageIcon(chimg1);
			l1.setIcon(i1);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		BookOrderDAO orderdao = new BookOrderDAO();

		JButton b1 = new JButton("장바구니");
		b1.setBackground(new Color(250, 250, 210));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// bookorderDB(주문확인DB)
				// : paycode, bookcode, total, paycheck, usercode, day, payment

				BookOrderVO bag = new BookOrderVO();
				bag.setBookcode(bc);
				bag.setTotal(1); // 장바구니화면에서만 개수 선택 가능
				bag.setPaycheck(false); // 결제여부 false
				bag.setUsercode(usercode);
				bag.setDay(null); // 결제한 날짜이므로 null로 들어감
				bag.setPayment(null); // 결제수단이므로 null로 들어감
				try {
					// bookorderDB 생성
					orderdao.create(bag);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "장바구니로 이동하였습니다");
				// 장바구니 이동
				new Cart();
				setVisible(false);
			}
		});
		b1.setFont(new Font("굴림", Font.PLAIN, 30));
		b1.setBounds(552, 373, 194, 43);
		getContentPane().add(b1);
		setVisible(true);
	}

	public static void main(String[] args) {
		new BookDetail(100);
	}
}
