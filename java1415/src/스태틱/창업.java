package 스태틱;

public class 창업 {

	public static void main(String[] args) {
		직원 e1 = new 직원("홍길동", "여자", 20);
		직원 e2 = new 직원("김길동", "여자", 30);
		직원 e3 = new 직원("박길동", "남자", 40); 
		System.out.println("총 " + 직원.count + "명"); // 직원 수 합계
		// 직원 나이 합계를 활용하여 평균 나이 구함
		System.out.println("평균 나이는 " + 직원.sum/직원.count + "세");
		System.out.println(e1); // 직원1 출력
		System.out.println(e2); // 직원2 출력
		System.out.println(e3); // 직원3 출력
	}

}
