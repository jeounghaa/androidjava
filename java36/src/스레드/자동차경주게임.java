package 스레드;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class 자동차경주게임 extends JFrame {

	public 자동차경주게임() {
		setTitle("자동차 경주");
		setSize(1400, 600);
		setLayout(null); // absolute layout
		
		// 내부 클래스
		Car car1 = new Car("car01.png", 100, 0);
		Car car2 = new Car("car02.png", 100, 150);
		Car car3 = new Car("car03.png", 100, 300);
		
		car1.start();
		car2.start();
		car3.start();
		
		setVisible(true);
	}
	
	// 내부 클래스
	public class Car extends Thread{
		int x, y;
		JLabel label;
		
		public Car(String file, int x, int y) {
			ImageIcon icon = new ImageIcon(file);
			label = new JLabel(icon); // 라벨 만듦
			this.x = x; // x축 위치
			this.y = y; // y축 위치
			label.setBounds(x, y, 150, 150); // 위치, 라벨크기
			add(label); // 프레임에 라벨 붙임
		}
		
		@Override
		public void run() {
			Random r = new Random();
			for (int i = 0; i < 200; i++) {
				int move = r.nextInt(50)+1; // 1~50
				x = x + move;
				// 다시 넣어주는 이유: 다시 그려서 움직이는 것처럼 보이기 위해
				label.setBounds(x, y, 150, 150);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		자동차경주게임 name = new 자동차경주게임();
	}

}
