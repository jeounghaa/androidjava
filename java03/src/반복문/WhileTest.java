package 반복문;

import javax.swing.JOptionPane;

public class WhileTest {

	public static void main(String[] args) {
		// 계속 반복하고자 하는 경우
		while (true) {
			System.out.println("계속 반복");
			String choice = JOptionPane.showInputDialog("계속 하실래요?(yes / no)");
			if (choice.equals("no") || choice.equals("n")) {
				System.out.println("프로그램을 종료합니다.");
//				break;
				// while 반복문을 종료, while아래에 있는 것들은 계속 실행
				System.exit(0); 
			}
		}
		// 제한된 횟수를 반복하고자 하는 경우
		// 위에있는 코드가 무한반복이어서 밑 코드가 에러 발생
		// 밑 코드가 돌아갈 수 없기때문
//		int i = 0;
//		
//		while (i < 10) {
//			System.out.println("10번만 반복");
//			i++;
//		}
	}

}
