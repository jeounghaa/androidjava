package 연산자;

public class 기본형형변환 {

	public static void main(String[] args) {
//		큰 <- 작: 자동 형변환
		int x = 100; // 4바이트
		byte y = 120; // -128 ~ 127, 1바이트

		x = y;
		System.out.println("x: " + x);
//		작 <- 큰: 강제 형변환 (타입)소괄호 사용
		int z = 127;
		byte w = (byte) z;

		int q = 1000;
//		byte t = q;
//		강제 형변환하는 경우는 강제로 변환하고자하는 타입범위에
//		값이 들어가야한다

	}

}
