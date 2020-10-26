package 제너릭프로그래밍;

import java.util.ArrayList;

public class CarTest {

	public static void main(String[] args) {
		Car<String> c1 = new Car<>("big");
		System.out.println(c1.getSize());
		
		Car<Integer> c2 = new Car<>(100);
		System.out.println(c2.getSize());
		
		Car<VO> c3 = new Car<>(new VO());
		System.out.println(c3.getSize());
		
		ArrayList<VO> list = new ArrayList<>();
		list.add(new VO());
		System.out.println(list);
	}

}
