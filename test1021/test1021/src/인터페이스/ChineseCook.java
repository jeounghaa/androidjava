package 인터페이스;

public class ChineseCook implements ICook {

	@Override
	public void soup() {
		System.out.println("토마토계란탕을 만들다.");
	}

	@Override
	public void salad() {
		System.out.println("고추잡채를 만들다.");
	}

}
