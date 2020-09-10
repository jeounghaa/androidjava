package 컬렉션;

import java.util.HashMap;

// uitility (유틸리티, 간단히 사용하는 필수 라이브러리)
public class 맵형태목록 {

	public static void main(String[] args) {
		HashMap phone = new HashMap();
		phone.put(1, "엄마");
		phone.put(2, "아빠");
		phone.put(3, "친구");
		System.out.println(phone);
		System.out.println(phone.get(1));
		phone.put(3, "형"); // 값변경
		System.out.println(phone);
	}

}
