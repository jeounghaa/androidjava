package 제어문;

public class 반복문2 {

	public static void main(String[] args) {
		// 정해진 횟수만큼 반복
		int start = 1; // ㅣ시작 값
		int end = 5; // 끝 값
		int add = 1; // 증가 값
		
		while (start <= end) {
			System.out.println(start);
			start += add;
		}
		
	}

}
