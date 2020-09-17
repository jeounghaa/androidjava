package Order;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import Book.BookDetail;
import DB.BookDAO;
import DB.BookOrderDAO;
import DB.BookOrderVO;
import DB.BookVO;
import Login.Login;
import Main.Main;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class OrderCon extends JFrame {

	String col[] = { "결제일", "도서제목", "가격", "수량", "합계", "결제수단", "결제" };
	Object rows[][] = new Object[0][6];
	JTable table;
	JScrollPane js;
	DefaultTableModel model;
	
	public OrderCon() {
		setTitle("주문확인");
		// 주문확인
		getContentPane().setBackground(new Color(95, 158, 160));
		getContentPane().setLayout(null);

		JLabel l1 = new JLabel("주문확인");
		l1.setFont(new Font("굴림", Font.PLAIN, 40));
		l1.setBounds(349, 152, 160, 41);

		// 테이블 생성
		model = new DefaultTableModel(rows, col);
		table = new JTable(model);
		js = new JScrollPane(table);
		js.setBounds(17, 218, 850, 674);

		// 테이블 height지정
		table.setRowHeight(30);
		// 테이블 width 지정
		TableColumnModel tcm = table.getColumnModel();
		tcm.getColumn(1).setPreferredWidth(230);

		getContentPane().setLayout(null);
		getContentPane().add(l1);
		getContentPane().add(js);
		setSize(900, 1000);
		setVisible(true);

		// 테이블 행 가운데 정렬
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tc = table.getColumnModel();
		for (int i = 0; i < col.length; i++) {
			if (i != 1) {
				tc.getColumn(i).setCellRenderer(dtcr);
			}
		}

		// 뒤로가기 버튼
		JLabel l7 = new JLabel("<");
		l7.setFont(new Font("굴림", Font.PLAIN, 40));
		l7.setBounds(25, 25, 62, 43);
		l7.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// 전 화면으로 이동
				new Main();
				// 이동하면서 현재 창 비활성화
				setVisible(false);
			}
		});
		getContentPane().add(l7);

		BookOrderDAO orderdao = new BookOrderDAO();
		BookDAO bookdao = new BookDAO();

		// 로그인한 회원
		String user = Login.userid;

		try {
			ArrayList<BookOrderVO> list = orderdao.readAll(user);
			for (int i = 0; i < list.size(); i++) {
				// list값 bag에 하나씩 넣음
				BookOrderVO bag = list.get(i);

				int paycode = bag.getPaycode();
				int bookcode = bag.getBookcode();
				int total = bag.getTotal();
				boolean paycheck = bag.getPaycheck();
				String day = bag.getDay();
				String payment = bag.getPayment();
				String pay = "";
				
				// 구매한 책에대한 책 정보
				BookVO book = bookdao.read(bookcode);
				String title = book.getTitle();
				int price = book.getPrice();
				
				// paycheck가 true인 값들만 가져와야 함
				if (paycheck) { 
					pay = "결제완료";
					Object data[] = { day, title, price, total, price * total, payment, pay };
					model.addRow(data); // 테이블에 행 추가
				}
				
			}
			
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
//						super.mouseClicked(e);
					table = (JTable)e.getComponent();
					
					// 선택한 테이블 행 번호번째 db를 가져옴
					BookOrderVO bag = list.get(table.getSelectedRow());
					// 책번호를 가져옴
					int bookcode = bag.getBookcode();
					int paycode = bag.getPaycode();
					
					if (table.getSelectedColumn() != 1) {
						// 주문확인 상세 페이지로 이동, 책번호 넘겨줌
						new OrderDetails(paycode);
						setVisible(false);
					} else {
						new BookDetail(bookcode);
					}
				}
			});
			
		} catch (Exception e) {
			System.out.println("전체목록 가져오다가 에러");
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		new OrderCon();
	}

}
