package 연산자;

public class 논리연산자2 {

	public static void main(String[] args) {
		int hot = 25;
		int wind = 100;
		
		// hot이 30이상이거나, wind가 88이하이거나하면
		// 양산을 들고 가겠다
		if (hot >= 30 || wind <= 88) {
			System.out.println("양산을 들고간다");
		} else {
			System.out.println("양산을 안들고간다");
		}
	}

}
