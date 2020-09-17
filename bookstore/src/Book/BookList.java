package Book;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import DB.BookDAO;
import DB.BookVO;
import Main.Main;

public class BookList extends JFrame {
	// 스크롤바, 패널 생성
	JScrollPane js;
	JPanel jp;
	// 초기 리스트 생성
	public static String original = "국내";

	public BookList(String find) {
		setTitle(find);
		getContentPane().setBackground(new Color(95, 158, 160));
		getContentPane().setLayout(null);
		setSize(900, 1000);
		// 스크롤 넣을 패널 생성
		jp = new JPanel();
		jp.setBackground(new Color(95, 158, 160));
		FlowLayout flowLayout = (FlowLayout) jp.getLayout();
		flowLayout.setVgap(30);
		flowLayout.setHgap(0);
		// 스크롤 생성
		js = new JScrollPane(jp);
		Dimension size = new Dimension();
		size.setSize(800, 4000);
		jp.setPreferredSize(size);
		js.getVerticalScrollBar().setUnitIncrement(30);
		// 스크롤 추가, 사이즈 조절
		js.setViewportView(jp);
		js.setBounds(0, 100, 880, 860);

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

		// 패널배열 생성, 10개
		try {
			JPanel[] p = new JPanel[10];
			BookDAO dao = new BookDAO();
			// 국내/외,베스트셀러도서 구분해서 정보 가져오기
			ArrayList<BookVO> list = null;
			if (find.equals("베스")) {
				list = dao.best(find);
			} else {
				list = dao.all(find);
			}
			// 구분 각 패널에 넣을 요소들 반복 삽입
			for (int i = 0; i < p.length; i++) {
				BookVO bag = list.get(i);
				// db데이터 가져와서 입력
				p[i] = new JPanel();
				p[i].setBackground(new Color(255, 250, 250));
				p[i].setSize(870, 350);

				jp.add(p[i]);
				// 이미지 아이콘 받아오기
				ImageIcon img1 = new ImageIcon("src/BookImage/" + bag.getImage());
				// 이미지 아이콘을 이미지로 변환
				Image img2 = img1.getImage();
				// 이미지 사이즈 조정
				Image img3 = img2.getScaledInstance(225, 325, java.awt.Image.SCALE_SMOOTH);
				ImageIcon img = new ImageIcon(img3); // 이미지로 이미지아이콘 생성

				// 패널 격자 구성
				GridBagLayout gbl_p = new GridBagLayout();
				gbl_p.columnWidths = new int[] { 350, 100, 160, 100, 160, 0 };
				gbl_p.rowHeights = new int[] { 100, 50, 50, 50, 100, 0 };
				gbl_p.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
				gbl_p.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };

				JLabel j1 = new JLabel();
				j1.setIcon(img);
				GridBagConstraints gbc_j1 = new GridBagConstraints();
				gbc_j1.gridheight = 5;
				gbc_j1.insets = new Insets(0, 0, 0, 5);
				gbc_j1.gridx = 0;
				gbc_j1.gridy = 0;

				JLabel j2 = new JLabel();
				j2.setFont(new Font("굴림", Font.PLAIN, 32));
				// db에서 타이틀 가져오기
				j2.setText(bag.getTitle());
				GridBagConstraints gbc_j2 = new GridBagConstraints();
				gbc_j2.anchor = GridBagConstraints.WEST;
				gbc_j2.gridwidth = 4;
				gbc_j2.insets = new Insets(0, 0, 5, 5);
				gbc_j2.gridx = 1;
				gbc_j2.gridy = 0;

				JLabel j3 = new JLabel();
				j3.setFont(new Font("굴림", Font.BOLD, 20));
				j3.setText("작가");
				GridBagConstraints gbc_j3 = new GridBagConstraints();
				gbc_j3.anchor = GridBagConstraints.WEST;
				gbc_j3.insets = new Insets(0, 0, 5, 5);
				gbc_j3.gridx = 1;
				gbc_j3.gridy = 1;

				JLabel j4 = new JLabel("New label");
				j4.setFont(new Font("굴림", Font.PLAIN, 20));
				// db에서 작가 가져오기
				j4.setText(bag.getWriter());
				GridBagConstraints gbc_j4 = new GridBagConstraints();
				gbc_j4.gridwidth = 3;
				gbc_j4.anchor = GridBagConstraints.WEST;
				gbc_j4.insets = new Insets(0, 0, 5, 5);
				gbc_j4.gridx = 2;
				gbc_j4.gridy = 1;

				JLabel j5 = new JLabel();
				j5.setFont(new Font("굴림", Font.BOLD, 20));
				j5.setText("출판사");
				GridBagConstraints gbc_j5 = new GridBagConstraints();
				gbc_j5.anchor = GridBagConstraints.WEST;
				gbc_j5.insets = new Insets(0, 0, 5, 5);
				gbc_j5.gridx = 1;
				gbc_j5.gridy = 2;

				JLabel j6 = new JLabel("New label");
				j6.setFont(new Font("굴림", Font.PLAIN, 20));
				// db에서 출판사 가져오기
				j6.setText(bag.getPublisher());
				GridBagConstraints gbc_j6 = new GridBagConstraints();
				gbc_j6.gridwidth = 3;
				gbc_j6.anchor = GridBagConstraints.WEST;
				gbc_j6.insets = new Insets(0, 0, 5, 5);
				gbc_j6.gridx = 2;
				gbc_j6.gridy = 2;

				JLabel j7 = new JLabel();
				j7.setFont(new Font("굴림", Font.BOLD, 20));
				j7.setText("가격");
				GridBagConstraints gbc_j7 = new GridBagConstraints();
				gbc_j7.anchor = GridBagConstraints.WEST;
				gbc_j7.insets = new Insets(0, 0, 5, 5);
				gbc_j7.gridx = 1;
				gbc_j7.gridy = 3;

				// 가격표기 형식 변환 ex)256123=>256,123
				DecimalFormat formatter = new DecimalFormat("###,###");

				JLabel j8 = new JLabel("New label");
				j8.setFont(new Font("굴림", Font.PLAIN, 20));
				// db에서 가격 받아와서 가격표기 형식을 바꿔서 출력
				j8.setText(formatter.format(bag.getPrice()));
				GridBagConstraints gbc_j8 = new GridBagConstraints();
				gbc_j8.anchor = GridBagConstraints.WEST;
				gbc_j8.insets = new Insets(0, 0, 5, 5);
				gbc_j8.gridx = 2;
				gbc_j8.gridy = 3;

				// 상세 도서 페이지 버튼
				JButton b2 = new JButton();
				b2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// 상세 도서 페이지 연결
						new BookDetail(bag.getBookcode());
						// 이동하면서 현재 창 비활성화
						setVisible(false);
					}
				});
				b2.setFont(new Font("굴림", Font.PLAIN, 16));
				b2.setText("자세히");
				b2.setBackground(new Color(250, 250, 210));
				GridBagConstraints gbc_b2 = new GridBagConstraints();
				gbc_b2.gridwidth = 2;
				gbc_b2.insets = new Insets(0, 0, 5, 0);
				gbc_b2.gridx = 3;
				gbc_b2.gridy = 3;

				JLabel j9 = new JLabel();
				j9.setFont(new Font("굴림", Font.PLAIN, 16));
				// db에서 받아온 인트로 글자수 조절
				j9.setText(bag.getIntro().substring(0, 36) + "......");
				GridBagConstraints gbc_j9 = new GridBagConstraints();
				gbc_j9.insets = new Insets(0, 0, 0, 5);
				gbc_j9.anchor = GridBagConstraints.WEST;
				gbc_j9.gridwidth = 4;
				gbc_j9.gridx = 1;
				gbc_j9.gridy = 4;
				// 페널에 이미지, 버튼, 라벨 삽입
				p[i].setLayout(gbl_p);
				p[i].add(j1, gbc_j1);
				p[i].add(j2, gbc_j2);
				p[i].add(j3, gbc_j3);
				p[i].add(j4, gbc_j4);
				p[i].add(j5, gbc_j5);
				p[i].add(j6, gbc_j6);
				p[i].add(j7, gbc_j7);
				p[i].add(j8, gbc_j8);
				p[i].add(b2, gbc_b2);
				p[i].add(j9, gbc_j9);
			} // for

		} catch (Exception e) {

		} // try-catch

		getContentPane().add(js);
		setVisible(true);
	}

	public static void main(String[] args) {
		new BookList(original);
	}// main

}
