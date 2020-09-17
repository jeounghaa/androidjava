package Order;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import DB.BookDAO;
import DB.BookOrderDAO;
import DB.BookOrderVO;
import DB.BookVO;
import DB.UserDAO;
import DB.UserVO;
import Login.Login;
import Main.Main;

public class OrderPay extends JFrame {
	JTable table;
	JScrollPane js;
	DefaultTableModel model;
	ImageIcon oriIcon1;

	private ButtonGroup credit;
	public static String credits = "계좌이체";

	public OrderPay() {
		setTitle("주문하기");
		getContentPane().setBackground(new Color(95, 158, 160));
		getContentPane().setLayout(null);
		// 테이블생성
		String col[] = { "도서제목", "가격", "수량", "합계", "예정일" };
		Object rows[][] = new Object[0][6];
		model = new DefaultTableModel(rows, col);
		table = new JTable(model);
		js = new JScrollPane(table);
		js.setBounds(12, 146, 860, 282);

		// 테이블 height지정
		table.setRowHeight(30);

		// 테이블 width 지정
		TableColumnModel tcm = table.getColumnModel();
		tcm.getColumn(1).setPreferredWidth(150);
		tcm.getColumn(2).setPreferredWidth(150);

		getContentPane().setLayout(null);

		// 뒤로가기 버튼
		JLabel back = new JLabel("<");
		back.setFont(new Font("굴림", Font.PLAIN, 40));
		back.setBounds(25, 25, 62, 43);
		back.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// 전 화면으로 이동
				new Cart();
				// 이동하면서 현재 창 비활성화
				setVisible(false);
			}
		});
		getContentPane().add(back);

		BookOrderDAO orderdao = new BookOrderDAO();
		BookDAO bookdao = new BookDAO();
		UserDAO userdao = new UserDAO();
		UserVO userbag = new UserVO();
		BookOrderVO orderbag = new BookOrderVO();

		// 결제상태를 체크하기 위한 자료를 담을 컬렉션 생성
		ArrayList codes = new ArrayList();

		try {
			ArrayList<BookOrderVO> list = orderdao.readAll(Login.userid);
			for (int i = 0; i < list.size(); i++) {
				// bookorder테이블 가져오기
				BookOrderVO bag = list.get(i);
				// paycode, bookcode, total, paycheck, usercode

				int bookcode = bag.getBookcode();
				int total = bag.getTotal();
				boolean paycheck = bag.getPaycheck();
				int paycode = bag.getPaycode();

				// 구매한 책에대한 책 정보
				BookVO book = bookdao.read(bookcode);
				String title = book.getTitle();
				int price = book.getPrice();

				// 현재 날짜
				Date now = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

				// 배송예정일은 현재 날짜에서 +3일
				Calendar cal = Calendar.getInstance();
				cal.setTime(now);
				cal.add(Calendar.DATE, 3);
				String due_Day = sdf.format(cal.getTime());

				// paycheck가 false인 값들만 가져와야 함
				if (paycheck == false) {
					// 예정일은 결제한 날짜 + 3일
					Object data[] = { title, price, total, price * total, due_Day };
					model.addRow(data);
					// paycheck가 false인 paycode들을 저장
					codes.add(paycode);
				} else {
					// paycheck가 true이면 결제를 했다는 것이므로 출력X
				}
			}
		} catch (Exception e) {
			System.out.println("전체목록 가져오다가 에러");
			e.printStackTrace();
		}

		// 전체 가격 변수 생성
		int allprice = 0;
		for (int i = 0; i < table.getRowCount(); i++) {
			// 테이블에 입력된 가격 추출, 합산
			allprice = allprice + (int) table.getValueAt(i, 3) * (int) table.getValueAt(i, 2);
		}
		// 가격 형식 표기 변환
		DecimalFormat formatter = new DecimalFormat("###,###");

		JPanel p1 = new JPanel();
		p1.setBounds(17, 438, 850, 200);
		p1.setBackground(new Color(255, 250, 250));
		getContentPane().add(p1);

		JPanel p2 = new JPanel();
		p2.setLocation(17, 653);
		p2.setSize(850, 200);
		p2.setBackground(new Color(255, 250, 250));
		getContentPane().add(p2);

		// 격자 모양으로 만들기
		GridBagLayout gbl_p1 = new GridBagLayout();
		gbl_p1.columnWidths = new int[] { 50, 100, 450, 200, 50 };
		gbl_p1.rowHeights = new int[] { 30, 140, 3, 0 };
		gbl_p1.columnWeights = new double[] { 0.0, 0.0, 0.0, 4.9E-324, 0.0 };
		gbl_p1.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		p1.setLayout(gbl_p1);

		JLabel l2 = new JLabel();
		l2.setFont(new Font("굴림", Font.BOLD, 16));
		l2.setText("배송지 : ");
		GridBagConstraints gbc_l2 = new GridBagConstraints();
		gbc_l2.insets = new Insets(0, 0, 5, 5);
		gbc_l2.gridx = 1;
		gbc_l2.gridy = 1;
		p1.add(l2, gbc_l2);

		JLabel l3 = new JLabel();
		l3.setFont(new Font("굴림", Font.PLAIN, 16));
		// login에서 저장한 변수를 가져옴
		l3.setText(Login.postadd);
		GridBagConstraints gbc_l3 = new GridBagConstraints();
		gbc_l3.anchor = GridBagConstraints.WEST;
		gbc_l3.insets = new Insets(0, 0, 5, 5);
		gbc_l3.gridx = 2;
		gbc_l3.gridy = 1;
		p1.add(l3, gbc_l3);

		JButton b1 = new JButton();
		b1.setBackground(new Color(250, 250, 210));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 배송지 수정, dialog가 떠서 주소 수정를 수정하게 되면
				// text가 바뀌고 데이터 베이스에 있는 address의 주소가 바뀌어서 값이 저장
				String add = JOptionPane.showInputDialog("주소를 입력하세요");
				// null값이외의 값 판단
				if (add != null) {
					l3.setText(add);
					// login에서 저장한 변수를 가져와서 전달
					String id = Login.userid;
					JOptionPane.showMessageDialog(null, id + "의  주소값이 변경되었습니다");
					userbag.setAddresstwo(add);
					userbag.setId(id);
					// 주문 상세 화면에서 사용할 주소 저장;
					Login.postadd = add;
					try {
						// 배송지 addresstwo 업데이트
						userdao.update(userbag);
					} catch (Exception e1) {
					}
				} else {
					l3.setText(userbag.getAddress());
				}
			}
		});
		b1.setFont(new Font("굴림", Font.PLAIN, 16));
		b1.setText("배송지 수정");
		GridBagConstraints gbc_b1 = new GridBagConstraints();
		gbc_b1.insets = new Insets(0, 0, 5, 5);
		gbc_b1.fill = GridBagConstraints.BOTH;
		gbc_b1.gridx = 3;
		gbc_b1.gridy = 1;
		p1.add(b1, gbc_b1);

		// 격자 모양으로 만들기
		GridBagLayout gbl_p2 = new GridBagLayout();
		gbl_p2.columnWidths = new int[] { 200, 100, 100, 200, 200, 50 };
		gbl_p2.rowHeights = new int[] { 30, 70, 70, 30, 0 };
		gbl_p2.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 4.9E-324, 0.0 };
		gbl_p2.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		p2.setLayout(gbl_p2);

		JLabel l4 = new JLabel();
		l4.setFont(new Font("굴림", Font.BOLD, 16));
		l4.setText("결제수단 : ");
		GridBagConstraints gbc_l4 = new GridBagConstraints();
		gbc_l4.insets = new Insets(0, 0, 5, 5);
		gbc_l4.gridx = 0;
		gbc_l4.gridy = 1;
		p2.add(l4, gbc_l4);

		// 결제수단 체크 확인(라디오버튼)
		JRadioButton rb1 = new JRadioButton("신용카드");
		rb1.setFont(new Font("굴림", Font.PLAIN, 16));
		rb1.setBackground(new Color(255, 250, 250));
		GridBagConstraints gbc_rb1 = new GridBagConstraints();
		gbc_rb1.anchor = GridBagConstraints.WEST;
		gbc_rb1.insets = new Insets(0, 0, 5, 5);
		gbc_rb1.gridx = 1;
		gbc_rb1.gridy = 1;
		p2.add(rb1, gbc_rb1);
		JRadioButton rb2 = new JRadioButton("계좌이체");
		rb2.setFont(new Font("굴림", Font.PLAIN, 16));
		rb2.setBackground(new Color(255, 250, 250));
		GridBagConstraints gbc_rb2 = new GridBagConstraints();
		gbc_rb2.anchor = GridBagConstraints.WEST;
		gbc_rb2.insets = new Insets(0, 0, 5, 5);
		gbc_rb2.gridx = 2;
		gbc_rb2.gridy = 1;
		p2.add(rb2, gbc_rb2);

		// 결제 수단 그룹화
		credit = new ButtonGroup();
		credit.add(rb1);
		credit.add(rb2);

		// 현재 날짜
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String day = sdf.format(now);

		JButton b2 = new JButton();
		b2.setBackground(new Color(250, 250, 210));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 결제수단 선택 확인
				if (rb1.isSelected() || rb2.isSelected()) {
					// 테이블이 있는 수 만큼(false인 경우 = arraylist codes에 들어가있는 갯수)
					// codes에 있는 데이터를 출력해서 paycheck를 진행
					for (int i = 0; i < table.getRowCount(); i++) {
						int paycodes = (int) codes.get(i);

						orderbag.setUsercode(Login.userid);
						orderbag.setDay(day);
						orderbag.setPaycode(paycodes);

					}
					if (rb2.isSelected()) {
						JOptionPane.showMessageDialog(null, "계좌이체로 주문되었습니다.");
						// 주문상세페이지에 전달할 결제 수단 입력
						credits = "계좌이체";
						orderbag.setPayment(credits);
						// 주문확인창으로 이동
						new Main();
						setVisible(false);
					} else {
						JOptionPane.showMessageDialog(null, "신용카드로 주문되었습니다.");
						credits = "신용카드";
						orderbag.setPayment(credits);
						// 주문확인창으로 이동
						new Main();
						setVisible(false);
					}
					try {
						// paycheck가 false인 paycode를 가져가서 true로 바꿔줌
						orderdao.paycheck(orderbag);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					// 결제수단 선택이 안되었을 때
				} else {
					JOptionPane.showMessageDialog(null, "결제수단을 선택해주세요");
				}
			}
		});
		b2.setFont(new Font("굴림", Font.PLAIN, 16));
		b2.setText("결제하기");
		GridBagConstraints gbc_b2 = new GridBagConstraints();
		gbc_b2.insets = new Insets(0, 0, 5, 5);
		gbc_b2.fill = GridBagConstraints.BOTH;
		gbc_b2.gridheight = 2;
		gbc_b2.gridx = 4;
		gbc_b2.gridy = 1;
		p2.add(b2, gbc_b2);

		JLabel l5 = new JLabel();
		l5.setFont(new Font("굴림", Font.BOLD, 16));
		l5.setText("총 결제금액: ");
		GridBagConstraints gbc_l5 = new GridBagConstraints();
		gbc_l5.insets = new Insets(0, 0, 5, 5);
		gbc_l5.gridx = 0;
		gbc_l5.gridy = 2;
		p2.add(l5, gbc_l5);

		JLabel l6 = new JLabel();
		l6.setFont(new Font("굴림", Font.PLAIN, 16));
		// 총 결제 금액 형식 변환해서 표기
		l6.setText(formatter.format(allprice));
		GridBagConstraints gbc_l6 = new GridBagConstraints();
		gbc_l6.insets = new Insets(0, 0, 5, 5);
		gbc_l6.gridx = 1;
		gbc_l6.gridy = 2;
		p2.add(l6, gbc_l6);
		getContentPane().add(js);
		setSize(900, 1000);
		setVisible(true);

	}

	public static void main(String[] args) {
		new OrderPay();
	}

}
