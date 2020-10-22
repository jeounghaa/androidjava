package 인터페이스;

public class BananaCar implements Car {

	@Override
	public void fast() {
		System.out.println("많이 빠릅니다.");
	}

	@Override
	public void run() {
		System.out.println("잘 달립니다.");
	}

}
