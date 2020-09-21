package 스레드;

public class CounterThread extends Thread {
	@Override
	public void run() {
		for (int i = 500; i > 0; i--) {
			System.out.println("카운터: " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
//	public void view() {
//		run();
//		System.out.println("내용을 프린트");
//	}
}
