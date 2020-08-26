package java08;

import java.util.Random;
import java.util.Scanner;

public class 가위바위보 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		// 컴퓨터가 내는 값을 랜덤으로 받음
		// 게임 횟수
		int count = 0;
		// 컴퓨터가 이긴 횟수
		int c_cou = 0;
		// 사람이 이긴 횟수
		int h_cou_0 = 0; // 가위
		int h_cou_1 = 0; // 바위
		int h_cou_2 = 0; // 보

		// 결과 값을 따로 출력하기 위한 변수
		String result = "";
		
		// 0: 가위 1: 바위 2: 보
		System.out.println("컴퓨터와 가위바위보게임");
		System.out.println("---------------------------------------");
		// 사용자가 멈추고싶을때까지 반복
		while (true) {
			// 컴퓨터 값 랜덤으로 받기
			int com = r.nextInt(3);
			System.out.println("가위 바위 보 중 입력해주세요(-1:종료  0:가위  1:바위  2:보)");
			System.out.print(">> ");
			// 사람이 내는 값을 String으로 받음('가위'나 '1'로 받을 수 있음)
			String hu = sc.next();
			// 한번 돌때마다 횟수 증가
			count++;
			// 사용자가 -1이라고 입력하는 경우 
			if (hu.equals("-1")) {
				// 무한루프 종료
				break;
			} else if (com == 0) {
			// 컴퓨터가 가위일 경우
				if (hu.equals("가위") || hu.equals("0")) {
					result = "비겼습니다.";
				}else if (hu.equals("바위") || hu.equals("1")) { 
					result = "이겼습니다.";
					// 사람이 바위로 이긴 횟수 +1
					h_cou_1++;
				} else if (hu.equals("보") || hu.equals("2")){ 
					result = "졌습니다.";
					// 컴퓨터가 이긴 횟수 +1
					c_cou++;
				} else {
					System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
				}
			} else if (com == 1) {
			// 컴퓨터가 바위일 경우
				if (hu.equals("가위") || hu.equals("0")) {
					result = "졌습니다.";
					// 컴퓨터가 이긴 횟수 +1
					c_cou++;
				}else if (hu.equals("바위") || hu.equals("1")) { // 컴퓨터 바위
					result = "비겼습니다.";
				} else if (hu.equals("보") || hu.equals("2")){ // 컴퓨터 보
					result = "이겼습니다.";
					// 사람이 보로 이긴 횟수 +1
					h_cou_2++;
				} else {
					System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
				}
			} else if (com == 2) {
			// 컴퓨터가 보일 경우
				if (hu.equals("가위") || hu.equals("0")) {
					result = "이겼습니다.";
					// 사람이 가위로 이긴 횟수 +1
					h_cou_0++;
				}else if (hu.equals("바위") || hu.equals("1")) { // 컴퓨터 바위
					result = "졌습니다.";
					// 컴퓨터가 이긴 횟수 +1
					c_cou++;
				} else if (hu.equals("보") || hu.equals("2")){ // 컴퓨터 보
					result = "비겼습니다.";
				} else {
					System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
				}
			}
			// 결과 값 출력
			System.out.println(result);
		}
		System.out.println("게임을 " + count + "회 하셨습니다.");
		System.out.println("컴퓨터는 " + c_cou + "회 이겼습니다.");
		System.out.println("사용자는 가위로" + h_cou_0 + "회 이겼습니다.");
		System.out.println("사용자는 바위로" + h_cou_1 + "회 이겼습니다.");
		System.out.println("사용자는 보로" + h_cou_2 + "회 이겼습니다.");
		
	}

}
