package 형변환Casting;

import java.util.ArrayList;

public class 참조형형변환 {

	public static void main(String[] args) {
		// 상속관계에서만 형변환(Casting, 캐스팅) 가능
		// Car(부모, 수퍼클래스), Truck(자식, 서브클래스)
		// 클래스간의 대소비교할 때는 개념적으로 접근
		// 부모클래스가 크고, 자식클래스가 작다
		ArrayList list = new ArrayList();
		// 모든 타입을 묶을 수 있음. 크기가 유동적
		list.add("홍길동");
		// Object(큰) <- String(작): 자동형변환
		// 업캐스팅
		list.add(100);
		// Object <--upcasting-- Integer <--auto boxing-- int
		list.add(11.22);
		list.add(true);
		list.add('A');
		list.add(new VO());
		System.out.println("목록내용: " + list);
		// 업캐스팅(자동형변환)으로 String을 Object으로 형변환하여 넣은 것은 
		// 꺼냈을 때 Object으로 거내면 String에서 추가된 기능을 쓸 수 없다.
		// 꺼낼 때, String으로 형변환하여 꺼내야 한다.
		// 강제형변환, down casting(다운캐스팅)
		String name = (String) list.get(0);
		int age = (int) list.get(1); // (Integer)로 써도 상관x
		// 기본형 <--auto unboxing-- Integer <--down casting-- Object
	}

}
