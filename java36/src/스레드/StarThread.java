package 스레드;

public class StarThread extends Thread {
	// 멤버변수, 멤버메서드
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("★");
		}
	}

}
