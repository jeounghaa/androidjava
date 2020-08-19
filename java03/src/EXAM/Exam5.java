package EXAM;

import java.util.Scanner;


public class Exam5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 스티커 개수, 가격
		int stic = 0;
		int stic_p = 0;
		// 노트 개수, 가격
		int note = 0;
		int note_p = 0;
		
		// 스티커 개수, 가격, 노트 개수, 가격을 입력받음
		System.out.print("스티커 개수: ");
		stic += sc.nextInt();
		System.out.print("스티커 가격: ");
		stic_p += sc.nextInt();
		System.out.print("노트 개수: ");
		note += sc.nextInt();
		System.out.print("노트 가격: ");
		note_p += sc.nextInt();
		
		// 스티커의 총 가격
		int stic_s = stic*stic_p;
		// 노트의 총 가격
		int note_s = note*note_p;
		
		System.out.println();
		System.out.println("스티커 총 가격: " + stic_s + "원");
		System.out.println("노트 총 가격: " + note_s + "원");
		System.out.println("---------------------------");
		// 총 결제 금액
		int sum = stic_s + note_s;
		// 총 결제 금액이 25000이상일 시 3000원 할인
		if (sum >= 25000) {
			System.out.println("총 결제금액 25000원 이상이므로 3000원 할인하여");
			System.out.println("=> " + (sum-3000) + "원");
		// 25000원 이하일 시 그냥 출력
		} else {
			System.out.println("총 결제금액: " + sum + "원");
		}
	}// main end
}// class end
