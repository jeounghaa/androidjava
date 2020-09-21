package 스레드;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.SwingConstants;

public class ThreadRun4 extends JFrame{
	// 전역변수, 글로벌변수
	JLabel top, center, sub;
	
	public ThreadRun4() {
		getContentPane().setBackground(new Color(135, 206, 235));
		setSize(800, 300);
		
		
		top = new JLabel("1");
		top.setFont(new Font("굴림", Font.BOLD, 30));
		getContentPane().add(top, BorderLayout.NORTH);
		
		
		JLabel l1 = new JLabel();
		getContentPane().add(l1, BorderLayout.WEST);
		
		sub = new JLabel("3");
		sub.setFont(new Font("굴림", Font.BOLD, 30));
		getContentPane().add(sub, BorderLayout.SOUTH);
		
		center = new JLabel("2");
		center.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(center, BorderLayout.CENTER);
		
		JLabel l2 = new JLabel();
		getContentPane().add(l2, BorderLayout.EAST);
		setVisible(true);
		
		
		CounterThread2 counter = new CounterThread2();
		counter.start();
		
		TimerThread2 timer = new TimerThread2();
		timer.start();
		
		ImgThread2 img = new ImgThread2();		
		img.start();
	}

	// 내부클래스(inner class)
	// 변수를 다른 클래스와 공유할 목적
	// 단점: 내부클래스는 독립적으로 사용 불가
	public class CounterThread2 extends Thread {
		@Override
		public void run() {
			for (int i = 500; i > 0; i--) {
				top.setText("카운터: " + i);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public class TimerThread2 extends Thread {
		@Override // 오버라이드, 재정의
		public void run() {
			for (int i = 0; i < 300; i++) {
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String d = sdf.format(date);
				sub.setText(d);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public class ImgThread2 extends Thread {
		@Override // 재정의
		public void run() {
			String[] img = {"1.png", "2.png", "3.png", "4.png", "5.png"};
			for (int i = 0; i < img.length; i++) {
				ImageIcon img2 = new ImageIcon(img[i]);
				center.setIcon(img2);
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	
	public static void main(String[] args) {
		ThreadRun4 t = new ThreadRun4();
		
	}
	
}
