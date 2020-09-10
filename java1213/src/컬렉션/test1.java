package 컬렉션;

import java.util.ArrayList;

public class test1 {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("박스키");
		list.add("송스키");
		list.add("김스키");
		list.add("정스키");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i+1 + "등: " + list.get(i));
		}
		System.out.println();
		// 2등이 반칙하여 탈락
		list.remove(1);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i+1 + "등: " + list.get(i));
		}
	}

}
