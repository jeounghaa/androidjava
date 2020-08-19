package 연산자;

public class 형변환문제 {

	public static void main(String[] args) {
		
		byte a = 100;
		int b = a;
//		자동 형변환
		
		int c = 300;
//		byte d = c;
//		불가능: byte범위에 들어가지 않는다
		
		double e = 400; // double 8바이트
		int f = (int)e;
//		강제 형변환
		
		int h = 400; 
		double i = h;
//		자동 형변환
		
	}

}
