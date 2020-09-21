package 스레드;

public class PlusThread extends Thread {
	@Override
	public void run() {
		for (int i = 1; i < 1000; i++) {
			System.out.println("증가: " + i);
		}	
	}
}
