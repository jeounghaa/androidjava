package 연산자;

import javax.swing.JOptionPane;

public class 기본입출력2 {

	public static void main(String[] args) {
//		ctrl + alt + ↓ : 복사
		String num1  = JOptionPane.showInputDialog("숫자1을 입력해주세요.");
		String num2  = JOptionPane.showInputDialog("숫자2을 입력해주세요.");
		
		int n1 = Integer.parseInt(num1);
		int n2 = Integer.parseInt(num2);
//		연산자: CPU
		int sum = n1 + n2;
		
		System.out.println("입력하신 두 수의 합은 " + sum + "입니다.");
	}

}
