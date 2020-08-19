package EXAM;

public class q5 {
	// 연습문제 5번
	public static void main(String[] args) {
		for (int i = 1; i < 6; i++) {
			for (int j = 5; j > i ; j--) {
				System.out.print(" ");
			}
			for (int j = 0; j < i; j++) {
				System.out.print(" *");
			}
			System.out.println("");
		}
		for (int i = 1; i < 5; i++) {
			for (int j = 0; j < i ; j++) {
				System.out.print(" ");
			}
			for (int j = 5; j > i; j--) {
				System.out.print(" *");
			}
			System.out.println("");
		}
	}

}
