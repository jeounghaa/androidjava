package 클래스만들기;

public class 계산기2 {
	public void add(int x, int y) {
		// x, y변수는 add 메서드 지역에서만 쓸 수 있는 지역변수
		// local변수, 로컬변수
		// 지역변수는 자동초기화 되지 않음
		// 메소드의 입력값으로 잠깐 저장할 용도로 선언된 변수, 
		// 메소드의 사용과 처리의 중간 다리역할을 하는 변수
		// 		: 매개변수(parameter:파라메터)
		int result = x+y;
		System.out.println(result);
	}
	public void minus(int x, int y) {
		int result = x-y;
		System.out.println(result);
	}
	public int mul(int x, int y) {
		int result = x*y;
		return result;
	}
	public void div(int x, int y) {
		int result = x/y;
		System.out.println(result);
	}
}
