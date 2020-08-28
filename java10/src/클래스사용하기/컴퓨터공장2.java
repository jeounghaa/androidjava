package 클래스사용하기;

import 클래스만들기.컴퓨터;

public class 컴퓨터공장2 {

	public static void main(String[] args) {
		컴퓨터 com1 = new 컴퓨터();
		com1.price = 100;
		com1.company = "APPLE";
		com1.size = 30;
		System.out.println(com1);
		
		컴퓨터 com2 = new 컴퓨터();
		com2.price = 200;
		com2.company = "BANANA";
		com2.size = 20;
		System.out.println(com2);
		
		System.out.println("com1의 가격은 " + com1.price);
		System.out.println("com1의 회사는 " + com1.company);
		System.out.println("com1의 모니터 크기는 " + com1.size);
		
		System.out.println("\ncom2의 가격은 " + com2.price);
		System.out.println("com2의 회사는 " + com2.company);
		System.out.println("com2의 모니터 크기는 " + com2.size);
	}

}
