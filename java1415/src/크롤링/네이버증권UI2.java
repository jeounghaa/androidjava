package 크롤링;

import java.io.FileWriter;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class 네이버증권UI2 {

	public static void main(String[] args) {
		// 주식코드
		String[] codes = {"238090", "293490", "005930", "009830", "047820"};
		// 주식이름
//		String[] names = {"앤디포스", "카카오게임즈", "삼성전자", "한화솔루션", "초록뱀"};
		
		JFrame f = new JFrame();
		f.getContentPane().setBackground(new Color(32, 178, 170));
		f.getContentPane().setFont(new Font("Dialog", Font.PLAIN, 35));
		f.setSize(500, 900);
		f.getContentPane().setLayout(null);
		
		네이버증권크롤링2 naver = new 네이버증권크롤링2();
		// codes를 하나씩 빼서 크롤링
		for (int i = 0; i < codes.length; i++) {
			// list에 가져온 값들을 넣음
			String[] list = naver.crawl(codes[i]);
			try {
				// list에 있는 값들을 파일에 저장
				FileWriter file = new FileWriter("src/크롤링/User/" + list[0] + ".txt");
				file.write("회사이름: " + list[0] + "\n"); // 이름
				file.write("회사코드: " + list[1] + "\n"); // 코드
				file.write("현재가: " + list[2] + "\n"); // 현재가
				file.write("어제와의 차이: " + list[3] + "\n"); // 어제와의 차이
				file.write("증감비율: " + list[4] + "\n"); // 증감비율
				file.write("고가: " + list[5] + "\n"); // 고가
				file.write("거래량: " + list[6] + "\n"); // 거래량
				file.close();
			} catch (Exception e) {
				System.out.println("파일 저장 에러");
			}
		}
		
		
		JLabel text = new JLabel("CODE:");
		text.setForeground(new Color(255, 255, 255));
		text.setFont(new Font("굴림", Font.BOLD, 34));
		text.setBounds(32, 426, 120, 40);
		f.getContentPane().add(text);
		
		JTextField id = new JTextField();
		id.setForeground(new Color(255, 255, 255));
		id.setBackground(new Color(169, 169, 169));
		id.setText("코드");
		id.setFont(new Font("굴림", Font.BOLD, 33));
		id.setBounds(156, 412, 294, 69);
		f.getContentPane().add(id);
		id.setColumns(10);
		
		JTextArea result = new JTextArea();
		result.setText("결과값");
		result.setFont(new Font("Monospaced", Font.PLAIN, 30));
		result.setForeground(new Color(255, 255, 255));
		result.setBackground(new Color(169, 169, 169));
		result.setBounds(32, 614, 418, 227);
		f.getContentPane().add(result);
		JButton b1 = new JButton("앤디포스");
		b1.setForeground(new Color(255, 255, 255));
		b1.setBackground(new Color(0, 128, 128));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] list = naver.crawl(codes[0]);
				id.setText(list[1]);
				
			}
		});
		b1.setFont(new Font("Dialog", Font.PLAIN, 35));
		b1.setBounds(55, 32, 358, 64);
		f.getContentPane().add(b1);
		
		JButton b2 = new JButton("카카오게임즈");
		b2.setForeground(new Color(255, 255, 255));
		b2.setBackground(new Color(0, 128, 128));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] list = naver.crawl(codes[1]);
				id.setText(list[1]);
			}
		});
		b2.setFont(new Font("Dialog", Font.PLAIN, 35));
		b2.setBounds(55, 108, 358, 64);
		f.getContentPane().add(b2);
		
		JButton b3 = new JButton("삼성전자");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] list = naver.crawl(codes[2]);
				id.setText(list[1]);
			}
		});
		b3.setForeground(new Color(255, 255, 255));
		b3.setBackground(new Color(0, 128, 128));
		b3.setFont(new Font("Dialog", Font.PLAIN, 35));
		b3.setBounds(55, 184, 358, 64);
		f.getContentPane().add(b3);
		
		JButton b4 = new JButton("한화솔루션");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] list = naver.crawl(codes[3]);
				id.setText(list[1]);
			}
		});
		b4.setForeground(new Color(255, 255, 255));
		b4.setBackground(new Color(0, 128, 128));
		b4.setFont(new Font("Dialog", Font.PLAIN, 35));
		b4.setBounds(55, 260, 358, 64);
		f.getContentPane().add(b4);
		
		JButton b5 = new JButton("초록뱀");
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] list = naver.crawl(codes[4]);
				id.setText(list[1]);
			}
		});
		b5.setForeground(new Color(255, 255, 255));
		b5.setBackground(new Color(0, 128, 128));
		b5.setFont(new Font("Dialog", Font.PLAIN, 35));
		b5.setBounds(55, 336, 358, 64);
		f.getContentPane().add(b5);
		
		JButton start = new JButton("크롤링 시작");
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String code = id.getText();
				for (int i = 0; i < codes.length; i++) {
					String[] list = naver.crawl(code);
					result.setText("현재가: " + list[2] + "\n" + "어제와의 차이: " + list[3] + "\n"
							+ "증감비율: " + list[4] + "\n" + "고가: " + list[5] + "\n"
							+ "거래량: " + list[6] + "\n");
				}
			}
		});
		start.setForeground(Color.WHITE);
		start.setFont(new Font("Dialog", Font.PLAIN, 35));
		start.setBackground(new Color(65, 105, 225));
		start.setBounds(55, 507, 358, 64);
		f.getContentPane().add(start);
		
		
		f.setVisible(true);
		
	}
}
