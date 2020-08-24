package 배열응용;

import java.util.Arrays;

public class 배열정렬 {

	public static void main(String[] args) {
		int[] age = {99, 10, 100, 88, 33, 24, 10, 77};
		Arrays.sort(age); // 파괴함수
		// 파괴함수, 비파괴함수
		for (int i : age) {
			System.out.println(i);
		}
	}

}
