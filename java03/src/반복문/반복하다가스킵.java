package 반복문;

public class 반복하다가스킵 {

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			// 3의 배수는 프린트는 안하고 싶음
			if (i % 3 == 0) {
				continue;
			}
			System.out.println(i);
		}
	}

}
