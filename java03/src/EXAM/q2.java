package EXAM;

public class q2 {

	public static void main(String[] args) {
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				// 2로 나누었을 때 나머지가 0이면 출력됨(2의 배수)
				if (i % 2 == 0) {
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
