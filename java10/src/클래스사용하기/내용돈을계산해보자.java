package 클래스사용하기;

import 클래스만들기.용돈계산기;

class 내용돈을계산해보자 {

	public static void main(String[] args) {
		용돈계산기 my = new 용돈계산기();
		
		int per = 6; // 기간
		int money = 100000; // 한달 용돈 금액
		
		int myMoney = my.mul(per, money);// 기간*한달용돈
		
		// 기간*한달용돈 한 값이 50만원이 넘으면
		if (myMoney >= 500000) { 
			// 그냥 출력
			System.out.println(myMoney + "원"); 
		} else {
			// 적으면 15만원을 더 줌
			System.out.println("15만원 더 줌 -> " + (myMoney+1500000) + "원");
		}
		
		int 상반기 = 600000; // 상반기 받은 용돈 금액
		int 하반기 = 500000; // 하반기 받은 용돈 급액
		
		int year = my.add(상반기, 하반기); // 상반기+하반기
		// 일년 동안 받은 용돈 값 출력
		System.out.println("일년 동안 받은 용돈은 " + year + "원");
		
	}

}
