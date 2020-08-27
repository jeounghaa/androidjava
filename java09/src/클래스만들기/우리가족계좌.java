package 클래스만들기;

public class 우리가족계좌 {

	public static void main(String[] args) {
		계좌 a1 = new 계좌();
		a1.name = "홍길동";
		a1.acc = "튼튼적금";
		a1.money = 1000;
		
		계좌 a2 = new 계좌();
		a2.name = "박길동";
		a2.acc = "튼튼예금";
		a2.money = 2000;
		
		계좌 a3 = new 계좌();
		a3.name = "홍기사";
		a3.acc = "다음적금";
		a3.money = 3000;
		
		System.out.print(a1.name + "(아버지)는 ");
		a1.plus();
		System.out.print(a3.name + "(딸)은 ");
		a1.minus();
		
	}

}
