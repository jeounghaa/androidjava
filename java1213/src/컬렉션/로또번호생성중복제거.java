package 컬렉션;

import java.util.HashSet;
import java.util.Random;

public class 로또번호생성중복제거 {

	public static void main(String[] args) {
		Random r = new Random();
		HashSet list = new HashSet();
//		while (true) {
//			list.add(r.nextInt(45)+1);
//			if (list.size() == 6) {
//				break;
//			}
//		}
//		while (list.size() < 6) {
//			list.add(r.nextInt(45)+1);
//		}
//		for (int i = 0; i < 6; i++) {
//			int num = r.nextInt(45) + 1;
//			System.out.println(num);
//			System.out.println(list.contains(num));
//			list.add(num);
//		}
		for (int i = 0; i < 6; i++) {
			int num = r.nextInt(45) + 1;
			System.out.println(num);
			if (list.contains(num)) {
				i--;
			} else {
				list.add(num);
			}
		}
		System.out.println(list);
	}

}
