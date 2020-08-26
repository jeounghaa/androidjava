package java08;

import java.util.Scanner;
import java.util.regex.Pattern;

public class 신체검사등급 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 점수
		int score = 0;
		
		// 주민번호 정규 표현
		String ssn_pa = "\\d{6}\\-[1-4]\\d{6}";
		
		System.out.print("주민번호를 입력해주세요 >> ");
		String ssn = sc.next();
		
		// 주민번호 정규표현과 입력한 주민번호가 맞는지 확인
		boolean ssn_ch = Pattern.matches(ssn_pa, ssn);
		if (ssn_ch == false) {
			// 입력한 주민번호가 형식에 맞지 않는 경우
			System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
		} else {
			// 주민번호, 키, 몸무게, 시력, 병명을 입력받음
			System.out.print("키를 입력해주세요 >> ");
			double height = sc.nextDouble();
			System.out.print("몸무게를 입력해주세요 >> ");
			double weight = sc.nextDouble();
			System.out.print("시력을 입력해주세요 >> ");
			double eye = sc.nextDouble();
			System.out.print("병명  1:없음  2:평발  3:고혈압>> ");
			int li = sc.nextInt();
			
			// bmi 계산식 = 몸무게(kg)/키(m)²
			double bmi = weight/((height/100)*(height/100));
			if(height < 150.0 || height > 190.0 || bmi >= 30 || eye <= 0.0){
				// 면제 대상자에 해당하는 경우
				System.out.println("면제대상자1");
			} else {
				// 면제 대상에 해당하지 않는 키일 경우 점수 +20점
				score += 20;
				// 35kg이상이면서 100kg이하인 몸무게일 경우 점수 +20점
				if (weight >= 35 || weight <= 100) {
					score += 20;
				}
				// 시력이 0.0보다 높을 경우
				if (eye >= 1.0) {
					score += 30;
				} else if (eye >= 0.5) {
					score +=20;
				} else if (eye >= 0.1) {
					score += 10;
				} else {
					System.out.println("면제대상자2");
				}
				
				if (li == 1) {
					// 병명이 없을 경우
					score += 30;
				} else if (li == 2) {
					// 병명이 평발인 경우
					score += 20;
				} else {
					// 병명이 고혈압인 경우
					score += 10;
				}
				// 점수 출력
				System.out.println("점수: " + score);
				// 점수가 40점 이상일 경우 현역, 미만일 경우 면제
				if (score >= 40) {
					System.out.println("현역대상자");
				} else {
					System.out.println("면제대상자3");
				}
			}
		}
		
		
	}

}
