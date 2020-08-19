package EXAM;

import javax.swing.JOptionPane;

public class Exam1 {

	public static void main(String[] args) {
		while (true) {
			String answer = JOptionPane.showInputDialog("긍정, 부정, 기타, 종료를 선택해주세요.");
			if (answer.equals("긍정")) {
				System.out.println("긍정을 선택하셨습니다.");
			} else if (answer.equals("부정")) {
				System.out.println("부정을 선택하셨습니다.");
			} else if (answer.equals("기타")) {
				System.out.println("기타를 선택하셨습니다.");
			} else if (answer.equals("종료")) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			} else {
				System.out.println("다시입력해주세요.");
			}
		}
	}

}
