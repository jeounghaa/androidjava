package 컬렉션;

import java.util.ArrayList;

public class 문제1 {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("박소정");
		list.add("김정민");
		list.add("소지현");
		list.add("김개념");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i+1 + "등: " + list.get(i));
		}
		System.out.println("--------------------");
		// 2등이 반칙하여 탈락
		list.remove(1);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i+1 + "등: " + list.get(i));
		}
	}

}
