package 클래스연습;

public class 쥬시Shop {

	public static void main(String[] args) {
		계산기 cal = new 계산기();
		cal.color = "빨강";
		cal.price = 5000;
		cal.size = 11;
		int 쥬스count = 5;
		int 커피count = 3;
		
		int sum = cal.더하다(5, 3); 
		// 주소를 가지고 메서드를 쓸 수 있음
		// 한잔에 3000원 -> 전체 금액 계산
		int sum2 = sum * 3000;
		System.out.println("당신의 지불할 금액은 " + sum2 + "원");
		
		int 쥬스가격 = cal.곱하다(쥬스count, 3000);
		int 커피가격 = cal.곱하다(커피count, 2000);
		
		System.out.println("쥬스가격은 " + 쥬스가격 + "원");
		System.out.println("커피가격은 " + 커피가격 + "원");
		
		int 차이 = cal.빼다(쥬스가격, 커피가격);
		System.out.println("두 음료간 차이는  " + 차이 + "원");
	}

}
