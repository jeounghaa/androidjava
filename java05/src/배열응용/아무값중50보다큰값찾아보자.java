package 배열응용;

import java.util.Random;

public class 아무값중50보다큰값찾아보자 {

	public static void main(String[] args) {
		Random r = new Random(4);
		// 0~99까지의 값 1000개 중 50보다 큰 값들을 프린트
		int[] num = new int[1000];
		for (int i = 0; i < num.length; i++) {
			num[i] = r.nextInt(100); 
		}
		int count = 0;
		for (int i = 0; i < num.length; i++) {
			if (num[i] >= 80) {
				System.out.println(i + "번째: " + num[i]);
				count++;
			}
		}
		System.out.println("80보다 큰 값은 " + count);
	}

}
