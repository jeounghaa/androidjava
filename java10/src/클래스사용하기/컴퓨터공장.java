package 클래스사용하기;

import 클래스만들기.컴퓨터;

public class 컴퓨터공장 {

	public static void main(String[] args) {
		// 객체생성시 같은 패키지 내에서 일단 찾음
		// 없으면 다른 패키지에서 찾게 됨
		// 다른 패키지에 있는 객체를 사용하는 경우는 
		// import로 경로를 명시해 주어야 한다.
		// 자동 import: 1)자동완성   2)마우스를 올리고 F2 선택
		//			  3)Ctrl + Shift + o
		컴퓨터 com1 = new 컴퓨터();
		// com1은 주소가 들어감. 주소로 가르키는 변수는 3개
		// new를 하면 멤버변수가 복사, 멤버변수는 자동 초기화
		// 글로벌 변수는 자동 초기화
		com1.price = 100;
		com1.company = "APPLE";
		com1.size = 30;
		컴퓨터 com2 = new 컴퓨터();
		com2.price = 200;
		com2.company = "BANANA";
		com2.size = 20;
		
		System.out.println("com1의 가격은 " + com1.price);
		System.out.println("com1의 회사는 " + com1.company);
		System.out.println("com1의 모니터 크기는 " + com1.size);
		
		System.out.println("\ncom2의 가격은 " + com2.price);
		System.out.println("com2의 회사는 " + com2.company);
		System.out.println("com2의 모니터 크기는 " + com2.size);
	}

}
