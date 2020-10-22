package 인터페이스;

public class 액션처리클래스 implements MyAction {

	@Override
	public void click() {
		System.out.println("ㅇ");
	}

	@Override
	public void doubleClick() {
		System.out.println("s");
	}

}
