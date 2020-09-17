package Order;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;

public class Cart extends JFrame{

	JTable table;
	JScrollPane js;
	DefaultTableModel model;

	public Cart() {
		// 장바구니
		setTitle("장바구니");
		getContentPane().setBackground(new Color(95, 158, 160));
		getContentPane().setLayout(null);

		JLabel l1 = new JLabel("장바구니");
		l1.setFont(new Font("굴림", Font.PLAIN, 40));
		l1.setBounds(346, 132, 160, 57);

		String col[] = { "도서제목", "가격", "수량", "", "합계", "예정일", "" };
		Object rows[][] = new Object[0][6];
		model = new DefaultTableModel(rows, col);
		table = new JTable(model);
		js = new JScrollPane(table);
		js.setBounds(12, 224, 860, 428);

		// 테이블 height지정
		table.setRowHeight(30);

		// 테이블 width 지정
		TableColumnModel tcm = table.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(300);
		tcm.getColumn(3).setPreferredWidth(40);
		tcm.getColumn(6).setPreferredWidth(40);

		getContentPane().setLayout(null);

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

		// 테이블 행 가운데 정렬
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tc = table.getColumnModel();
		for (int i = 0; i < col.length; i++) {
			if (i != 0) {
				tc.getColumn(i).setCellRenderer(dtcr);
			}
		}

		BookOrderDAO orderdao = new BookOrderDAO();
		BookDAO bookdao = new BookDAO();

		// 로그인한 유저
		String user = Login.userid;

		try {
			// 로그인한 유저의 장바구니DB 출력
			ArrayList<BookOrderVO> list = orderdao.readAll(user);
			int[] b = new int[list.size()];
			for (int i = 0; i < list.size(); i++) {
				// bookorder테이블 가져오기
				BookOrderVO order = list.get(i);
				// paycode, bookcode, total, paycheck, usercode

				int paycode = order.getPaycode();
				int bookcode = order.getBookcode();
				int total = order.getTotal();
				boolean paycheck = order.getPaycheck();

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
					Object data[] = { title, price, total, "변경", price * total, due_Day, "삭제" };
					model.addRow(data);
				}
				if (list.size() == 0) {
					JOptionPane.showMessageDialog(null, "장바구니가 비었어요!");
				}
			}
			
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
//					super.mouseClicked(e);
					table = (JTable)e.getComponent();
					
					// 선택한 테이블 행 번호번째 db를 가져옴
					BookOrderVO bag = list.get(table.getSelectedRow());
					// 책번호를 가져옴
					int bookcode = bag.getBookcode();
					int paycode = bag.getPaycode();
					
					
					System.out.println(bookcode);
					try {
						if (table.getSelectedColumn() == 3) {
							// 변경을 선택할 경우
							int num = Integer.parseInt(JOptionPane.showInputDialog("변경하실 수량을 입력해주세요."));
							orderdao.upTotal(bookcode, num);
							setVisible(false);
							// 변경된 값으로 다시 창 열기
							new Cart();
						} else if (table.getSelectedColumn() == 6) {
							// 삭제를 선택할 경우
							int result = JOptionPane.showConfirmDialog(null, "정말 삭제하시겠습니까?");
							if (result == JOptionPane.YES_OPTION) {
								try {
									orderdao.delete(paycode);
									setVisible(false);
									// 변경된 값으로 다시 창 열기
									new Cart();
								} catch (Exception e1) {
									e1.printStackTrace();
								}
							}
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
				}
			});

			
		} catch (Exception e) {
			System.out.println("전체목록 가져오다가 에러");
			e.printStackTrace();
		}

		// 주문확인
		BookOrderDAO dao = new BookOrderDAO();

		// 주문하기 버튼
		JButton b = new JButton("주문하기");
		b.setBackground(new Color(250, 250, 210));
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 주문하기페이지로 이동
				new OrderPay();
				// 이동하면서 현재 창 비활성화
				setVisible(false);
			}
		});
		b.setBounds(699, 730, 173, 48);
		getContentPane().add(b);
		getContentPane().add(l1);
		getContentPane().add(js);
		setSize(900, 1000);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Cart();
	}
}
