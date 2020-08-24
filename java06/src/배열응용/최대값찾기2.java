package 배열응용;

import java.util.Random;

public class 최대값찾기2 {

	public static void main(String[] args) {
		Random r = new Random();
		int[] num = new int[1000];

		for (int i = 0; i < num.length; i++) {
			num[i] = r.nextInt(1000) - 1000 ;
		}
		
		int max = num[0];
		int min = num[0];
		
		int count = 0;

		for (int i = 1; i < num.length; i++) {
			if (num[i] <= min) {
				System.out.println(i + "번째 min: " + min);
				min = num[i];
			}
			if (num[i] > max) {
				max = num[i];
				System.out.println(i + "번째 max: " + max);
				count++;
			} 

		}
		for (int i = 0; i < num.length; i++) {
			if (max == num[i]) {
				System.out.println("max는 " + i + "번째에 있어요");
			}
		}
		System.out.println();
		System.out.println("max값: " + max);
		System.out.println("max값의 개수: " + count);
		System.out.println("min값: " + min);
	}

}
