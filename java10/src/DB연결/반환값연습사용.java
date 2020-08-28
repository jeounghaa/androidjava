package DB연결;

import java.util.Date;

public class 반환값연습사용 {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		반환값연습 ex = new 반환값연습();
		// 오버로딩 = 다형성
		int test1 = ex.add(10, 20);
		System.out.println(test1);
		
		double test2 = ex.add(10.5, 20);
		System.out.println(test2);
		
		
		int[] test3 = ex.add(1);
		for (int i : test3) {
			System.out.print(i + "  ");
		}
		
		String test4 = ex.add("\n테스트", 2020);
		System.out.println(test4);
		
		Date date = ex.add("흠");
		System.out.print(date.getDate() + " ");
		System.out.print(date.getHours());
		
		System.out.println();
		
		boolean test6 = ex.add(true);
		System.out.println(test6);
	}
	
}
