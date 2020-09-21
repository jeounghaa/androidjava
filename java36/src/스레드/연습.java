package 스레드;

import java.util.Random;

public class 연습 {

	public static void main(String[] args) {
		Random r = new Random();
		for (int i = 0; i < 10; i++) {
			System.out.println(r.nextInt(1000)-1000);
		}
	}

}
