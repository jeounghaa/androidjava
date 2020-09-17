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
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import DB.BookDAO;
import DB.BookOrderDAO;
import DB.BookOrderVO;
import DB.BookVO;
import Login.Login;
import Main.Main;

public class OrderDetails extends JFrame {
	JTable table;
	JScrollPane js;
	DefaultTableModel model;
	ImageIcon oriIcon1;

	String acode = null;
	int alltotal = 0;
	int allprice = 0;
	public static int craditcode = 17;

	public OrderDetails(int craditcode) {

		setTitle("주문상세");
		getContentPane().setBackground(new Color(95, 158, 160));
		getContentPane().setLayout(null);

		// 테이블생성
		String col[] = { "결제일", "도서제목", "가격", "수량", "합계" };
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

		BookOrderDAO orderdao = new BookOrderDAO();
		BookDAO bookdao = new BookDAO();
		String codes = "";

		try {
			ArrayList<BookOrderVO> list = orderdao.readcradit(craditcode);

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

				String day = bag.getDay();

				// 결제된 제품만
				if (paycheck == true) {
					// 예정일은 결제한 날짜 + 3일
					Object data[] = { day, title, price, total, price * total };
					model.addRow(data);
					// 주문코드 값 확인
					codes = codes + " " + paycode;
				} else {
					// paycheck가 true이면 결제를 했다는 것이므로 출력X
				}

			}
		} catch (Exception e) {
			System.out.println("전체목록 가져오다가 에러");
			e.printStackTrace();
		}

		// 테이블에서 값을 추출하여 총 갯수, 금액을 가져오는 부분
		for (int i = 0; i < table.getRowCount(); i++) {
			// 전체 갯수 추출
			alltotal = alltotal + (int) table.getValueAt(i, 3);
			// 전체 가격 추출
			allprice = allprice + (int) table.getValueAt(i, 3) * (int) table.getValueAt(i, 2);
		}
		// 가격 형식 표기 변환
		DecimalFormat formatter = new DecimalFormat("###,###");

		JPanel p1 = new JPanel();
		p1.setBounds(17, 438, 850, 200);
		p1.setBackground(new Color(255, 250, 250));
		JPanel p2 = new JPanel();
		p2.setBounds(17, 641, 850, 200);
		p2.setBackground(new Color(255, 250, 250));

		getContentPane().add(p1);
		getContentPane().add(p2);
		GridBagLayout gbl_p1 = new GridBagLayout();
		gbl_p1.columnWidths = new int[] { 300, 150, 50, 150, 100, 100, 0 };
		gbl_p1.rowHeights = new int[] { 200, 0 };
		gbl_p1.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_p1.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		p1.setLayout(gbl_p1);

		JLabel l2 = new JLabel();
		l2.setFont(new Font("굴림", Font.BOLD, 20));
		l2.setText("총 수량 : ");
		GridBagConstraints gbc_l2 = new GridBagConstraints();
		gbc_l2.insets = new Insets(0, 0, 0, 5);
		gbc_l2.gridx = 1;
		gbc_l2.gridy = 0;
		p1.add(l2, gbc_l2);

		JLabel l3 = new JLabel();
		l3.setFont(new Font("굴림", Font.BOLD, 20));
		// 총 갯수 출력 형식 변환
		l3.setText(formatter.format(alltotal));
		GridBagConstraints gbc_l3 = new GridBagConstraints();
		gbc_l3.insets = new Insets(0, 0, 0, 5);
		gbc_l3.gridx = 2;
		gbc_l3.gridy = 0;
		p1.add(l3, gbc_l3);

		JLabel l4 = new JLabel();
		l4.setFont(new Font("굴림", Font.BOLD, 20));
		l4.setText("총 금액 : ");
		GridBagConstraints gbc_l4 = new GridBagConstraints();
		gbc_l4.insets = new Insets(0, 0, 0, 5);
		gbc_l4.gridx = 3;
		gbc_l4.gridy = 0;
		p1.add(l4, gbc_l4);

		JLabel l5 = new JLabel();
		l5.setFont(new Font("굴림", Font.BOLD, 20));
		// 총 금액 출력 형식 변환
		l5.setText(formatter.format(allprice));
		GridBagConstraints gbc_l5 = new GridBagConstraints();
		gbc_l5.insets = new Insets(0, 0, 0, 5);
		gbc_l5.gridx = 4;
		gbc_l5.gridy = 0;
		p1.add(l5, gbc_l5);

		GridBagLayout gbl_p2 = new GridBagLayout();
		gbl_p2.columnWidths = new int[] { 50, 100, 700, 0 };
		gbl_p2.rowHeights = new int[] { 30, 30, 30, 30, 30, 30, 0, 0 };
		gbl_p2.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_p2.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		p2.setLayout(gbl_p2);

		JLabel l6 = new JLabel();
		l6.setFont(new Font("굴림", Font.BOLD, 16));
		l6.setText("주문코드 : ");
		GridBagConstraints gbc_l6 = new GridBagConstraints();
		gbc_l6.anchor = GridBagConstraints.WEST;
		gbc_l6.insets = new Insets(0, 0, 5, 5);
		gbc_l6.gridx = 1;
		gbc_l6.gridy = 1;
		p2.add(l6, gbc_l6);

		JLabel l7 = new JLabel();
		l7.setFont(new Font("굴림", Font.PLAIN, 16));
		// 테이블에 있는 주문코드 받아와서 출력
		l7.setText(codes);
		GridBagConstraints gbc_l7 = new GridBagConstraints();
		gbc_l7.anchor = GridBagConstraints.WEST;
		gbc_l7.insets = new Insets(0, 0, 5, 0);
		gbc_l7.gridx = 2;
		gbc_l7.gridy = 1;
		p2.add(l7, gbc_l7);

		JLabel l8 = new JLabel();
		l8.setFont(new Font("굴림", Font.BOLD, 16));
		l8.setText("수령자 : ");
		GridBagConstraints gbc_l8 = new GridBagConstraints();
		gbc_l8.anchor = GridBagConstraints.WEST;
		gbc_l8.insets = new Insets(0, 0, 5, 5);
		gbc_l8.gridx = 1;
		gbc_l8.gridy = 2;
		p2.add(l8, gbc_l8);

		JLabel l9 = new JLabel();
		l9.setFont(new Font("굴림", Font.PLAIN, 16));
		// 로그인때 가져온 배송받을사람 표기
		l9.setText(Login.username);
		GridBagConstraints gbc_l9 = new GridBagConstraints();
		gbc_l9.anchor = GridBagConstraints.WEST;
		gbc_l9.insets = new Insets(0, 0, 5, 0);
		gbc_l9.gridx = 2;
		gbc_l9.gridy = 2;
		p2.add(l9, gbc_l9);

		JLabel l10 = new JLabel();
		l10.setFont(new Font("굴림", Font.BOLD, 16));
		l10.setText("배송지 : ");
		GridBagConstraints gbc_l10 = new GridBagConstraints();
		gbc_l10.anchor = GridBagConstraints.WEST;
		gbc_l10.insets = new Insets(0, 0, 5, 5);
		gbc_l10.gridx = 1;
		gbc_l10.gridy = 3;
		p2.add(l10, gbc_l10);

		JLabel l11 = new JLabel();
		l11.setFont(new Font("굴림", Font.PLAIN, 16));
		// 로그인때 가져온 배송받을주소 표기
		l11.setText(Login.postadd);
		GridBagConstraints gbc_l11 = new GridBagConstraints();
		gbc_l11.anchor = GridBagConstraints.WEST;
		gbc_l11.insets = new Insets(0, 0, 5, 0);
		gbc_l11.gridx = 2;
		gbc_l11.gridy = 3;
		p2.add(l11, gbc_l11);

		JLabel l12 = new JLabel();
		l12.setFont(new Font("굴림", Font.BOLD, 16));
		l12.setText("결제수단 : ");
		GridBagConstraints gbc_l12 = new GridBagConstraints();
		gbc_l12.anchor = GridBagConstraints.WEST;
		gbc_l12.insets = new Insets(0, 0, 5, 5);
		gbc_l12.gridx = 1;
		gbc_l12.gridy = 4;
		p2.add(l12, gbc_l12);

		JLabel l13 = new JLabel();
		l13.setFont(new Font("굴림", Font.PLAIN, 16));
		// 주문시 선택한 버튼으로 정보 가져오기
		l13.setText(OrderPay.credits);
		GridBagConstraints gbc_l13 = new GridBagConstraints();
		gbc_l13.anchor = GridBagConstraints.WEST;
		gbc_l13.insets = new Insets(0, 0, 5, 0);
		gbc_l13.gridx = 2;
		gbc_l13.gridy = 4;
		p2.add(l13, gbc_l13);

		JLabel l14 = new JLabel();
		l14.setFont(new Font("굴림", Font.BOLD, 16));
		l14.setText("총 금액 : ");
		GridBagConstraints gbc_l14 = new GridBagConstraints();
		gbc_l14.anchor = GridBagConstraints.WEST;
		gbc_l14.insets = new Insets(0, 0, 5, 5);
		gbc_l14.gridx = 1;
		gbc_l14.gridy = 5;
		p2.add(l14, gbc_l14);

		JLabel l15 = new JLabel();
		l15.setFont(new Font("굴림", Font.PLAIN, 16));
		// 총 금액 출력(형식 변환)
		l15.setText(formatter.format(allprice));
		GridBagConstraints gbc_l15 = new GridBagConstraints();
		gbc_l15.insets = new Insets(0, 0, 5, 0);
		gbc_l15.anchor = GridBagConstraints.WEST;
		gbc_l15.gridx = 2;
		gbc_l15.gridy = 5;
		p2.add(l15, gbc_l15);

		// 뒤로가기 버튼
		JLabel l16 = new JLabel("<");
		l16.setFont(new Font("굴림", Font.PLAIN, 40));
		l16.setBounds(25, 25, 62, 43);
		l16.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// 메인으로 이동
				new OrderCon();
				// 이동하면서 현재 창 비활성화
				setVisible(false);
			}
		});
		getContentPane().add(l16);

		// 결제 상세 내역 저장
		JButton b1 = new JButton("저장");
		b1.setBackground(new Color(250, 250, 210));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 라벨에 있는 정보 저장
				String[] saves = { l6.getText(), l7.getText(), l8.getText(), l9.getText(), l10.getText(), l11.getText(),
						l12.getText(), l13.getText(), l14.getText(), l15.getText(), };
				try {
					FileWriter file = new FileWriter("src/UserOrder/" + saves[3] + saves[1] + ".txt");
					file.write(saves[0] + saves[1] + "\n");
					file.write(saves[2] + saves[3] + "\n");
					file.write(saves[4] + saves[5] + "\n");
					file.write(saves[6] + saves[7] + "\n");
					file.write(saves[8] + saves[9] + "\n");
					file.close();
					// 주문확인 페이지로 이동
					new OrderCon();
					// 이동하면서 현재 창 비활성화
					setVisible(false);
				} catch (IOException e1) {
					System.out.println("저장중 에러 발생.");
				}

			}
		});
		b1.setFont(new Font("굴림", Font.PLAIN, 30));
		b1.setBounds(760, 860, 105, 50);
		getContentPane().add(b1);
		getContentPane().add(js);

		JLabel l17 = new JLabel("주문상세");
		l17.setFont(new Font("굴림", Font.PLAIN, 40));
		l17.setBounds(361, 79, 160, 43);
		getContentPane().add(l17);
		setSize(900, 1000);
		setVisible(true);
	}

	public static void main(String[] args) {
		new OrderDetails(craditcode);
	}

}
