package 배열응용;

import java.util.Random;

public class 문제 {

	public static void main(String[] args) {
		// 문제1000문제
		// 원래 답안지 0~3까지 중 1000개 만드세요
		// 내 답안지 0~3까지 중 1000개를 만드세요
		// 채점
		Random r = new Random();
		

		int[] co = new int[1000];
		int[] me = new int[1000];
		System.out.println("문항     정답     나      처리");
		
		int count = 0;
		for (int i = 0; i < co.length; i++) {
			co[i] = r.nextInt(4); 
			me[i] = r.nextInt(4);
			System.out.print(i + "   " + co[i] + "   " + me[i] + "   ");
			if (co[i] == me[i]) {
				count++;
				System.out.println("O");
			} else {
				System.out.println("X");
			}
		}
		System.out.println();
		System.out.println("맞은 문제 수: " + count);
	}

}
