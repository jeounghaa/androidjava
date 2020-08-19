package 제어문;

public class 반복문4 {

	public static void main(String[] args) {
	
		int count = 0;
		
		for (int i = 0; i < 100; i++) {
			// 4의 배수인지 아닌지 확인
//			System.out.println(i % 2);
			if (i % 4 == 0) {
				System.out.println(i);
				count++;
			}
		}
		System.out.println("100까지의 4의 배수는 " + count + "개 입니다.");
	}

}

