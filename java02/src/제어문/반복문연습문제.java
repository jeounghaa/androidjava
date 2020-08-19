package 제어문;

public class 반복문연습문제 {

	public static void main(String[] args) {
//		100부터 1까지 프린트
		int start1 = 100;
//		램에 start1변수 100을 저장
		int end1 = 1;
//		램에 end1변수 1을 저장
//		int min = 1;
//		램에 add1변수 1을 저장
		while (start1 >= end1) {
//			start1과 end1을 비교하여 100인 start1이 1인 end1보다 클 경우 반복
			System.out.println(start1);
//			start1값을 반복적으로 출력
//			start1 -= min;
			start1--; // 증감연산자
//			반복할때마다 start1에 1을 빼준다
		}
		System.out.println("");
		
//		5에서 10까지 프린트
		int start2 = 5;
//		램에 start2변수 5을 저장
		int end2 = 10;
//		램에 end2변수 10을 저장
//		int add2 = 1;
//		램에 add2변수 1을 저장
		while (start2 <= end2) {
//			start2와 end2를 비교하여 5인 start2가 10인 end2보다 작을 경우 반복
			System.out.println(start2);
//			start2값을 반복적으로 출력
//			start2 += add2;
			start2++; // 증감연산자
//			반복할때마다 start2에 1을 더한다
		}
		System.out.println("");
		
//		1부터 100까지 2씩 증가하면서 프린트
		int start3 = 1;
//		램에 start3변수 1을 저장
		int end3 = 100;
//		램에 end3변수 100을 저장
		int add3 = 2;
//		램에 add3변수 2를 저장
		while (start3 <= end3) {
//			start3과 end3을 비교하여 1인 start3이 100인 end3보다 작을 경우 반복
			System.out.println(start3);
//			start3값을 반복적으로 출력
			start3 += add3;
//			반복할때마다 start3에 2를 더한다
		}
	}

}
