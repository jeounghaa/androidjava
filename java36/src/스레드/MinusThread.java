package 스레드;

public class MinusThread extends Thread {
	@Override
	public void run() {
		for (int i = 1000; i > 1; i--) {
			System.out.println("감소: " + i);
		}	
	}
}
