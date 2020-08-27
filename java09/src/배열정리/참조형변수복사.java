package 배열정리;

public class 참조형변수복사 {

	public static void main(String[] args) {
		int[] x = {1, 2, 3, 4, 5};
		//int[] y = x; // 주소복사(얕은 복사)
		
		// 주소가 가르키는 값의 리스트를 복사
		// 참조형 변수는 깊은 복사를 해야함
		int[] y = x.clone(); // 주소복사(깊은 복사)
		
		System.out.print("X: ");
		for (int i : x) {
			System.out.print(i + " ");
		}
		System.out.print("\ny: ");
		for (int i : y) {
			System.out.print(i + " ");
		}
		System.out.println("\n------------");
		
		x[0] = 9;
		
		System.out.print("X: ");
		for (int i : x) {
			System.out.print(i + " ");
		}
		System.out.print("\ny: ");
		for (int i : y) {
			System.out.print(i + " ");
		}
		
		
	}

}
