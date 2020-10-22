package 인터페이스;

public class KoreanCook implements ICook {

	@Override
	public void soup() {
		System.out.println("한국...?");
	}

	@Override
	public void salad() {
		System.out.println("음,,,,");
	}

}
