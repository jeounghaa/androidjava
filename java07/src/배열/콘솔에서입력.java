package 배열;

import java.util.Scanner;

public class 콘솔에서입력 {

	public static void main(String[] args) {
		// 현재 키 입력: 150.5
		// 내년 키는 170.5
		Scanner sc = new Scanner(System.in);
		
		System.out.print("현재 키를 입력해주세요.");
		double height = sc.nextDouble();
		System.out.println("내년 키는 " + (height + 20));
		// 밖에 비가 오나: true
		// true면 우산을 가지고 가자
		// flase면 우산을 놓고 가자
		
		
		
		System.out.print("밖에 비가 오나요?");
		boolean rain = sc.nextBoolean();
		if (rain == true) {
			System.out.println("우산을 가지고 가자");
		} else {
			System.out.println("우산을 놓고 가자");
		}
		System.out.print("당신의 목표는>> ");
		sc.nextLine();
		String life = sc.nextLine(); // 엔터치기까지의 문장
		System.out.println("목표는 " + life);
		
	}

}
