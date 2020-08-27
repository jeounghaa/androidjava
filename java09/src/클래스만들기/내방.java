package 클래스만들기;

public class 내방 {

	public static void main(String[] args) {
		휴대폰 p1 = new 휴대폰();
		// color, size, company 멤버변수 복사 -> 자동초기화
		// p1 변수 생성 -> 멤버변수들을 가르키는 주소가 들어감
		p1.color = "흰색";
		p1.size = 7;
		p1.company = "삼성";
		System.out.println("p1휴대폰의 색은 " + p1.color + ", 크기는" + p1.size 
				+ ", 회사는 " + p1.company);
		p1.call();

		System.out.println("--------------");

		휴대폰 p2 = new 휴대폰();
		p2.color = "빨강";
		p2.size = 11;
		p2.company = "애플";
		System.out.println("p2휴대폰의 색은 " + p2.color + ", 크기는" + p2.size 
				+ ", 회사는 " + p2.company);

		System.out.println("--------------");

		Dog d1 = new Dog();
		d1.color = "흰색";
		d1.weight = 5.5;
		System.out.println("강아지의 색은 " + d1.color + ", 몸무게는 " + d1.weight + "kg 입니다.");
		d1.walk();
		d1.bark();
		
		System.out.println("--------------");
		
		Dog d2 = new Dog();
		d2.color = "검은색";
		d2.weight = 4.5;
		System.out.println("강아지의 색은 " + d2.color + ", 몸무게는 " + d2.weight + "kg 입니다.");
		d2.walk();
		d2.bark();
	}

}
