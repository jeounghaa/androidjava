package 스레드;

public class ThreadRun2 {

	public static void main(String[] args) {
		PlusThread plus = new PlusThread();
		MinusThread minus = new MinusThread();
		plus.start();
		minus.start();
	}

}
