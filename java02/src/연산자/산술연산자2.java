package 연산자;

public class 산술연산자2 {

	public static void main(String[] args) {
		int x = 200;
		int y = 100;
		int sum = x + y;
//		자바에서는 int끼리의 계산은 무조건 int 
		System.out.println("두 수의 합은 " + sum);
		double div = y / x;
//		8바이트 double <- 4바이트 int
		System.out.println("두 수의 나눗셈은 " + div); 
//		자바에서는 하나라도 double이면 무조건 double
//		하나만 강제로 정수를 실수로 변환해서 계산시 사용할 수 있다
//		강제로 타입을 바꾸는 것: 타입변환(형변환)
		double div2 = (double) y / x;
		System.out.println("두 수의 나눗셈2는 " + div2);
		
		double div3 = (double) (y/x);
		System.out.println("두 수의 나눗셈3은 " + div3);
		
	}

}
