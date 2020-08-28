package DB연결;

public class 계산기3 {
	// 자바에서는 메서드 이름을 동일하게 쓸 수 있다.
	// 입력값이 다 달라야 한다
	// 동일한 이름을 가진 메서드의 구분은 호출시 입력값의
	// 타입, 순서, 개수가 맞아야 한다
	public void add() {
		System.out.println("더하기 기능");
	}
	public void add(int x) {
		System.out.println(x+100);
	}
	public void add(int x, int y) {
		System.out.println(x+y);
	}
	public void add(double x, int y) {
		System.out.println(x+y);
	}
	public void add(int x, double y) {
		System.out.println(x+y);
	}
}
