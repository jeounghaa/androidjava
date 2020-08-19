package 제어문;

import javax.swing.JOptionPane;

public class 조건문연습문제 {

	public static void main(String[] args) {
		// 먹고싶은 음식: 아이스크림
		// 아이스크림이면 뚜레주르로 가요
		// 아이스커피이면 이디야로 가요
		// 다른 것이면 물마셔요

		String food = JOptionPane.showInputDialog("먹고싶은 음식은?");
		String result = "";
		if (food.equals("아이스크림")) {
			result = "뚜레주르";
		} else if (food.equals("아이스커피")) {
			result = "이디야";
		} else {
			result = "물";
		}
		System.out.println(result);
	}

}
