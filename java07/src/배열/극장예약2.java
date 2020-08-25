package 배열;

import java.util.Scanner;

public class 극장예약2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		
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
			int choice = sc.nextInt();
			
			if (choice == -1) {
				System.out.println("프로그램을 종료합니다.");
				System.out.println("예약된 좌석: " + count);
				System.out.println("결제 금액은 " + count*10000 + "원 입니다.\n");
				break;
			} else if (seat[choice - 1] == 0) {
				seat[choice - 1] = 1;
				System.out.println("예약되었습니다.\n");
				count++;
			} else {
				System.out.println("이미 예약된 좌석입니다.");
				System.out.println("다른 좌석을 선택해주세요.\n");
			}

		}
	}

}
