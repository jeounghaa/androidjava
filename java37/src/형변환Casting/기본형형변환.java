package 형변환Casting;

public class 기본형형변환 {

	public static void main(String[] args) {
		// primitive(원시적인, 가공되지 않은) data: 기본형 데이터, 원시 데이터
		// <-> derived(파생된, 가공된) data: 참조형 데이터, 파생 데이터
		// 크기에 대한 것을 고려해야함
		// 정수 byte(1) - short(2) - int(4) - long(8)
		byte a = 100; // -128 ~ 127
		int b = a; // 기본형 복사
		// int(큰) <- byte(작): 자동형변환

		
		int c = 128;
		byte d = (byte) c;
		// byte(작) <- int(큰): 강제형변환
		
		
		char e = (char) c;
		char f = (char) a; 
		
		
	}

}
