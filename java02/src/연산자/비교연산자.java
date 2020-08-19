package 연산자;

public class 비교연산자 {

	public static void main(String[] args) {
//		비교연산자 결과가 boolean(논리형)
		int x = 200;
		int y = 100;
		
		System.out.println("동일한가요? " + (x == y));
		System.out.println("다른가요? " + (x != y));
		System.out.println("x가 더 큰가요? " + (x >= y));
		System.out.println("x가 더 큰가요? " + (x > y));
	}

}
