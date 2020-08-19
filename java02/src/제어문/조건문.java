package 제어문;

public class 조건문 {

	public static void main(String[] args) {
		// 조건이 여러개일때, if- else if- else-
		// 				 if, if, if...
		int jumsu = 55;
		
		if (jumsu >= 90) {
			System.out.println("A");
		} else if (jumsu >= 80) {
			System.out.println("B");
		} else if (jumsu >= 70) {
			System.out.println("C");
		} else if (jumsu >= 60) {
			System.out.println("D");
		} else {
			System.out.println("F");
		}
		
	}

}
