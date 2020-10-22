package 인터페이스;

public class CookManager {
	
	ICook cook;
	// 밑의 food - cookmain에서 받아온 값
	public CookManager(String food) {
		// 받아온 값이 한식일 경우
		if (food.equals("한식")) {
			// koreancook보다 큰 icook에 koreancook을 넣음
			// icook대신 koreancook을 넣으면 값을 변경해야할 경우 하나하나씩 변경해야하므로 번거로움 
			cook = new KoreanCook();
		} else {
			// 받아온 값이 한식이 아닐 경우 chinesecook
			cook = new IndianCook();
		}
	}
	
	public void soup() {
		// cook이 korean일 경우 koreancook의 값들 반환
		// chinese일 경우 chinesecook의 값들 반환
		cook.soup();
	}
	
	public void salad() {
		cook.salad();
	}
}
