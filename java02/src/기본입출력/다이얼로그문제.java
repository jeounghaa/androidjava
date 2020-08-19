package 기본입출력;

import javax.swing.JOptionPane;

public class 다이얼로그문제 {

	public static void main(String[] args) {
		// 1. 2개의 숫자를 입력받아서 사칙연산을 해보세요.
		String n1 = JOptionPane.showInputDialog("숫자 1을 입력해주세요.");
		String n2 = JOptionPane.showInputDialog("숫자 2를 입력해주세요.");
		int in1 = Integer.parseInt(n1);
		int in2 = Integer.parseInt(n2);
		System.out.println("합: " + (in1 + in2) + ", 뺄: " + (in1 - in2));
		System.out.println("곱: " + (in1 * in2) + ", 나: " + (in1 / in2));
		System.out.println("-------------------------------------------------");

		// 2. 숫자 입력 2개 받아서
		// 시작 값 5, 1000이면 5~1000까지 프린트
		String x = JOptionPane.showInputDialog("시작 값을 입력해주세요.");
		String y = JOptionPane.showInputDialog("종료 값을 입력해주세요.");
		int ix = Integer.parseInt(x);
		int iy = Integer.parseInt(y);
		for (int i = ix; i <= iy; i++) {
			System.out.println(i);
		}
		System.out.println("-------------------------------------------------");

		// 3. 숫자 1개를 입력받고 문자 1개를 입력받아서 입력한 숫자 개수만큼 문자를 프린트
		String num = JOptionPane.showInputDialog("반복하고자하는 횟수를 입력해주세요");
		String sha = JOptionPane.showInputDialog("반복하고자하는 문자를 입력해주세요");
		int inum = Integer.parseInt(num);
		System.out.println("횟수: " + inum);
		for (int i = 0; i < inum; i++) {
			System.out.println(sha);
		}
	}

}
