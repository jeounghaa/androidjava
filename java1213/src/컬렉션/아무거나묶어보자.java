package 컬렉션;

import java.util.ArrayList;

import db연결.BbsVO;

public class 아무거나묶어보자 {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		// 집어 놓을 때는 add(집어넣을값)메서드 사용
		list.add(19);
		list.add("자바과정");
		list.add(25.5);
		list.add(false);
		list.add(new BbsVO());
		// list의 개수는 list.size()
		System.out.println(list.size() + "개 들어있음");
		// 꺼내올 때는 get(index)메서드 사용
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		// 지울때는 remove(index)메서드 사용
		list.remove(0);
		System.out.println(list.size() + "개 들어있음");
		System.out.println(list.get(0));
		// 중간에 끼워넣을 때는 add(끼워넣을 위치, 값)메서드 사용
		list.add(0, "홍길동"); // 0번 앞에 끼워넣음
		System.out.println(list.size() + "개 들어있음");
		System.out.println(list.get(0));
		// 값을 변경할 때는 set(변경할 위치, 값)메서드 사용
		list.set(0, "김길동");
		System.out.println(list.get(0));
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + ": " + list.get(i));
		}
		
	}

}
