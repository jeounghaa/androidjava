package EXAM;

import javax.swing.JOptionPane;

public class Exam2 {

	public static void main(String[] args) {
		// target = 88;
		// 입력을 받아서 정답이면 축하합니다!하고 종료
		// 정답이 아니면, 계속 입력을 받아서 확인
		// 입력받은 값이 정답보다 크면, 너무 커요!
		// 작으면, 너무 작아요!
		// 틀린횟수, 몇번만에 맞추었는지 프린트
		
		// 정답
		int target = 88;
		// 틀린 횟수
		int inco = 0;
		// 도전 횟수
		int count = 0;
		while (true) {
			// 사용자의 정답을 입력받음
			String answer = JOptionPane.showInputDialog("정답을 입력해주세요");
			// 비교 연산자는 기본형 데이타만 사용할 수 있다.
			// 도전 횟수를 1증가
			count++;
			// 사용자의 정답과 정답일 경우
			if (Integer.parseInt(answer) == 88) {
				System.out.println("정답입니다!");
				System.out.println("시스템을 종료합니다.");
				// 무한루프를 끝냄
				break;
			// 사용자의 정답이 정답이 아닐 경우
			} else{
				System.out.println("정답이 아닙니다!");
				// 틀린횟수를 1증가
				inco++;
				// 사용자의 정답이 정답보다 클 경우
				if (Integer.parseInt(answer) > target) {
					System.out.println("너무 커요!");
				// 사용자의 정답이 정답보다 작을 경우
				} else {
					System.out.println("너무 작아요!");
				}
			}// else end
		}// while end
		System.out.println(inco + "번 틀리셨습니다.");
		System.out.println(count + "번 만에 맞추셨습니다.");
	}// main end

}// class end
