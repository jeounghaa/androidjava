package 배열응용;

import java.util.Random;


public class 입력해서넣어보자5 {

	public static void main(String[] args) {
		// 임의의 값 100개를 만들어서
		// 배열에 넣고 
		// 전체를 출력
		// 첫번째 값과 마지막값을 더함
		
		Random r = new Random(); // 아무거나 만들어주는 클래스
		int[] data = new int[100];
		
		for (int i = 0; i < 100; i++) {
			data[i] = r.nextInt(100);
		}
		
		for (int x : data) {
			System.out.println(x);
		}
		System.out.println("첫번째값과 마지막값을 더한 값은 " + (data[0] + data[data.length-1]));
	}

}
