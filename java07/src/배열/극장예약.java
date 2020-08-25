package 배열;

import java.util.Scanner;

public class 극장예약 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		// 좌석마다 예매상황을 저장할 공간들
		int[] seat = new int[10];

		while (true) {
			System.out.println("--------------------------------------------");
			for (int i = 0; i < seat.length; i++) {
				System.out.print("   " + (i + 1));
			}
			System.out.println();
			System.out.println("--------------------------------------------");

			for (int i = 0; i < seat.length; i++) {
				System.out.print("   " + seat[i]);
			}
			System.out.println();
			System.out.print("원하시는 좌석번호를 입력하세요(종료는 -1): ");
			choice = sc.nextInt();
			
			if (choice == -1) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else if (seat[choice - 1] == 0) {
				seat[choice - 1] = 1;
				System.out.println("예약되었습니다.");
			} else {
				System.out.println("이미 예약된 좌석입니다.");
			}

		}

	}

}
