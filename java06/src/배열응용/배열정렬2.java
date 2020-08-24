package 배열응용;

import java.util.Arrays;

public class 배열정렬2 {

	public static void main(String[] args) {
		int[] age = {99, 10, 100, 88, 33, 24, 10, 77};
		// 배열 복사할때는 clone()함수 사용
		// 깊은 복사, 배열은 깊은 복사를 해야한다.
		// 깊은 복사를 해야 배열은 따로 따로 만들어진다.
		int[] age2 = age.clone();
		// 파괴함수, 비파괴함수
		for (int i : age) {
			System.out.print(i + " ");
		}
		System.out.println();
		for (int i : age2) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("------------------------------");
		Arrays.sort(age);
		for (int i : age) {
			System.out.print(i + " ");
		}
	}

}
