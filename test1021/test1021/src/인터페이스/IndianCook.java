package 인터페이스;

public class IndianCook implements ICook{

	@Override
	public void soup() {
		System.out.println("인도음식1...?");
	}

	@Override
	public void salad() {
		System.out.println("인도음식2");
	}

}
