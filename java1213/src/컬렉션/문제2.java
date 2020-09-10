package 컬렉션;

import java.util.HashMap;

public class 문제2 {

	public static void main(String[] args) {
		HashMap hm = new HashMap();
		hm.put(100, "김데이");
		hm.put(200, "김사전");
		hm.put(300, "김구조");
		hm.put(400, "김자료");
		System.out.println(hm);
		// 200번의 고객은 탈퇴
		hm.remove(200);
		System.out.println(hm);
		// 300번의 고객은 개명
		hm.put(300, "김충성");
		System.out.println(hm);
	}

}
