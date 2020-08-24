package 배열응용;


public class EXAM3 {

	public static void main(String[] args) {
		int[] num = {11, 22, 33, 44};
		for (int i = 0; i < num.length; i++) {
			if (num[i] == 33) {
				System.out.println("33은 " + i + "번째 입니다.");
			}
		}
	}

}
