package 인터페이스;

import java.util.ArrayList;

public class 캐스팅확인 {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		// Objebt(크) -- String(작), 맨, 수퍼맨
		// 자동형변환(upcasting)
		list.add(10);
		list.add(new 맨());
		list.add(new 수퍼맨());
		
		// String(작) <-- Object(큰)
		// 강제형변환(downcasting)
		String l1 = (String) list.get(0);
		맨 m1 = (맨)list.get(1);
		수퍼맨 m2 = (수퍼맨)list.get(2);
		m2.eat();
		m2.run();
		m2.sky();
		
		Object m3 = list.get(2);
		// 다운캐스팅하지 않으면 부모클래스로 접근할 수 있는
		// 메소드가 부모클래스가 상속한 메서드로 제약을 받음
	}

}
