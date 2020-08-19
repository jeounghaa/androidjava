package EXAM;

public class q3 {
	// 연습문제 3
	public static void main(String[] args) {
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				// 단보다 곱하는 수가 작거나 같은 경우에만 출력
				if (i >= j) {
					System.out.println(i + " * " + j + " = " + j * i);
				} else {
					// 나머지가 0이 아니면 스킵
					continue;
				}
			}
			System.out.println("");
		}
	}

}
