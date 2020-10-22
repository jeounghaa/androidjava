package 인터페이스;

public class AppleCar implements Car {

	@Override
	public void fast() {
		System.out.println("조금 빠릅니다.");
	}

	@Override
	public void run() {
		System.out.println("움직입니다.");
	}

}
