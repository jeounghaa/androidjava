package EXAM;

import java.util.Scanner;

public class q1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 스캐너로 숫자 1, 2, 연산기호를 입력받음
		System.out.print("숫자1을 입력해주세요. ");
		int num1 = sc.nextInt();
		System.out.print("숫자2을 입력해주세요. ");
		int num2 = sc.nextInt();
		System.out.print("연산기호를 입력해주세요. ");
		char operator = sc.next().charAt(0);
		
		if (operator == '+') {
			// 받아온 기호 값이 +일 경우 숫자 1, 2를 더함
			System.out.println(num1 + num2);
		} else if (operator == '-') {
			// 받아온 기호 값이 -일 경우 숫자 1, 2를 뺌
			System.out.println(num1 - num2);
		} else if (operator == '*') {
			// 받아온 기호 값이 *일 경우 숫자 1, 2를 곱함
			System.out.println(num1 * num2);
		} else if (operator == '/') {
			// 받아온 기호 값이 /일 경우 숫자 1, 2를 나눔
			System.out.println(num1 / num2);
		} else {
			System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
		}
	}

}
