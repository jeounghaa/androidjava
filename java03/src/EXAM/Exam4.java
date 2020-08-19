package EXAM;

import java.util.Scanner;


public class Exam4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 투표횟수
		int count = 0;
		// 1번 투표 
		int cho1 = 0;
		// 2번 투표
		int cho2 = 0;
		// 3번 투표
		int cho3 = 0;
		// 투표 횟수를 5번
		while (count < 5) {
			System.out.println("-------------------------");
			System.out.println("                 투표시스템");
			System.out.println("-------------------------");
			System.out.println("1)아이유  2)유재석  3)방탄  4)종료");
			// 사용자의 투표를 입력받음
			System.out.print("선택>> ");
			int choice = sc.nextInt();
			// 투표 횟수 1증가
			count++;
			// 4종료를 입력할 경우
			if (choice == 4) {
				System.out.println("프로그을 종료합니다.");
				// 무한루프를 끝냄
				break;
			// 1번을 입력할 경우
			}	else if (choice == 1) {
				System.out.println("1번을 아이유를 선택하셨습니다.");
				// 1번 투표 수 증가
				cho1++;
			// 2번을 입력할 경우
			} else if (choice == 2) {
				System.out.println("2번 유재석을 선택하셨습니다.");
				// 2번 투표 수 증가
				cho2++;
			// 3번을 입력할 경우
			} else if (choice == 3) {
				System.out.println("3번 방탄을 선택하셨습니다.");
				// 3번 투표 수 증가
				cho3++;
			// 1, 2, 3, 4 이외의 것들을 입력할 경우
			} else {
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
			}
		}// while end
		// 1, 2, 3 투표 수 출력
		System.out.println("1)아이유: " + cho1 + "표, 2)유재석: " + cho2 
				+ "표, 3)방탄: " + cho3 + "표");
	}// main end
}// class end
