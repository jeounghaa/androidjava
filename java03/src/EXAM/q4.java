package EXAM;

public class q4 {
	// 연습문제 4
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
		
	}

}
