package 배열정리;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.SwingConstants;

public class 영화앨범 {
	// 현재 위치를 체크할 수 있는 변수
	static int now = 2;

	public static void main(String[] args) {
		// 영화제목목록, 이미지 목록, 감독목록, 평점목록
		String[] titles = {"나의 소녀시대", "테넷", "다만 악에서 구하소서", "오케이 마담", "남매의 여름밤"};
		String[] images = {"05.jpg", "01.jpg", "02.jpg", "03.jpg", "04.jpg"};
		String[] directors = {"프랭키 첸", "크리스토퍼 놀란", "홍원찬", "이철하", "윤단비"};
		String[] rates = {"8.84", "8.63", "7.79", "6.61", "9.09"};
		
		
		JFrame f = new JFrame();
		f.getContentPane().setFont(new Font("Dialog", Font.BOLD, 18));
		f.getContentPane().setBackground(SystemColor.activeCaption);
		
		f.setTitle("나의 영화앨범");
		f.setSize(400, 400);
		f.getContentPane().setLayout(null);
		
		JLabel title = new JLabel(titles[now]);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("굴림", Font.BOLD, 30));
		title.setBounds(12, 10, 360, 78);
		f.getContentPane().add(title);
		
		JLabel lblNewLabel_2 = new JLabel("감독");
		lblNewLabel_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel_2.setBounds(200, 109, 172, 24);
		f.getContentPane().add(lblNewLabel_2);
		
		
		JLabel img = new JLabel("");
		// 이미지 크기 변경
		ImageIcon oriIcon1 = new ImageIcon("C:\\Users\\Administrator\\Desktop\\" + images[now]);
		Image oriImg1 = oriIcon1.getImage();
		Image chimg1 = oriImg1.getScaledInstance(127, 171, Image.SCALE_SMOOTH);
		ImageIcon i1 = new ImageIcon(chimg1);
		
		img.setIcon(i1);
		img.setBounds(38, 77, 127, 214);
		f.getContentPane().add(img);
		
		JLabel dir = new JLabel(directors[now]);
		dir.setForeground(new Color(255, 255, 0));
		dir.setFont(new Font("Dialog", Font.BOLD, 18));
		dir.setBounds(200, 134, 172, 34);
		f.getContentPane().add(dir);
		
		JLabel rate = new JLabel(rates[now]);
		rate.setForeground(new Color(255, 255, 0));
		rate.setFont(new Font("Dialog", Font.BOLD, 18));
		rate.setBounds(200, 218, 172, 34);
		f.getContentPane().add(rate);
		
		JLabel lblNewLabel_2_1 = new JLabel("평점");
		lblNewLabel_2_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_1.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel_2_1.setBounds(200, 193, 172, 24);
		f.getContentPane().add(lblNewLabel_2_1);
		
		JButton btnNewButton = new JButton("이전");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 인덱스 감소
				now--;
				// 인덱스가 -1이되면 4로 가게
				if (now == -1) {
					now = 4;
				}
				// 영화이름 변경
				title.setText(titles[now]);
				// 이미지 크기 변경
				ImageIcon oriIcon1 = new ImageIcon("C:\\Users\\Administrator\\Desktop\\" + images[now]);
				Image oriImg1 = oriIcon1.getImage();
				Image chimg1 = oriImg1.getScaledInstance(127, 171, Image.SCALE_SMOOTH);
				ImageIcon i1 = new ImageIcon(chimg1);
				img.setIcon(i1);
				// 감독이름 변경
				dir.setText(directors[now]);
				// 평점 변경
				rate.setText(rates[now]);
			}
		});
		btnNewButton.setBounds(75, 307, 97, 23);
		f.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("다음");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 인덱스 증가
				now++;
				// 인덱스가 5가되면 0으로 가게
				if (now == 5) {
					now = 0;
				}
				// 영화이름 변경
				title.setText(titles[now]);
				//이미지 크기 변경
				ImageIcon oriIcon1 = new ImageIcon("C:\\Users\\Administrator\\Desktop\\" + images[now]);
				Image oriImg1 = oriIcon1.getImage();
				Image chimg1 = oriImg1.getScaledInstance(127, 171, Image.SCALE_SMOOTH);
				ImageIcon i1 = new ImageIcon(chimg1);
				img.setIcon(i1);
				// 감독이름 변경
				dir.setText(directors[now]);
				// 평점 변경
				rate.setText(rates[now]);
			}
		});
		btnNewButton_1.setBounds(216, 307, 97, 23);
		f.getContentPane().add(btnNewButton_1);
		
		f.setVisible(true);
	}
}
