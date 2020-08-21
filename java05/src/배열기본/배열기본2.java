package 배열기본;

import java.util.Scanner;


public class 배열기본2 {

	public static void main(String[] args) {
		// 일주일간 온도를 넣을 공간을 만들어서
		// 데이터를 넣고 전체 출력
		
		// 배열은 일반적으로 같은 타입을 묶을 때 사용
		// 다양한 타입을 묶을 때는 배열을 쓰지 않음
		// 배열은 고정된 크기를 가진다.
		// -> 크기조절 불가능
		Scanner sc = new Scanner(System.in);
		double[] temp = new double[7];
		for (int i = 0; i < temp.length; i++) {
			System.out.print("온도를 입력해주세요.  ");
			temp[i] = sc.nextDouble();
		}
		for (int i = 0; i < temp.length; i++) {
			System.out.println(i + "번째 날: " + temp[i]);
		}
	}

}
