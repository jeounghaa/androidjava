package EXAM;

import java.util.Scanner;


public class Exam3 {

	public static void main(String[] args) {
		// 스캐너로 입력을 받기 위해 선언
		Scanner sc = new Scanner(System.in);
		// 잔고를 0으로 초기화
		int money = 0;
		while (true) {
			System.out.println("-------------------------");
			System.out.println("           은행 입출금 시스템");
			System.out.println("-------------------------");
			System.out.println("1)입금  2)출금  3)잔고  4)종료");
			// 스캐너로 선택 받음
			System.out.print("선택>> ");
			int choice = sc.nextInt();
			// 4 종료를 선택할 시
			if (choice == 4) {
				// 시스템 종료
				System.out.println("시스템을 종료합니다.");
				break;
			// 1 입금을 선택할 시
			} else if (choice == 1) {
				// 스캐너로 입금액을 입력받음
				System.out.print("입금액 입력>> ");
				int plus = sc.nextInt();
				// 잔고에 입금액 더함
				money += plus;
			// 2 출금을 선택할 시
			} else if (choice == 2) {
				// 스캐너로 출금액을 입력받음
				System.out.print("출금액 입력>> ");
				int minus = sc.nextInt();
				// 잔고에 출금액을 뺌
				money -= minus;
			// 3 잔고를 선택할 시
			} else if (choice == 3) {
				// 잔고를 출력
				System.out.println("잔고는 " + money + "원");
			// 1, 2, 3, 4 이외의 것들을 입력할 시
			} else {
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
			}
		}// while end
	}// main end
}// class end
