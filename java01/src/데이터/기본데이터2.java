package 데이터;

public class 기본데이터2 {

	public static void main(String[] args) {
//		기본 데이터 4가지: 정수, 실수, 문자, 논리
//		기호 -> 연산자
		int age = 100;
		double height = 122.2;
//		한 글자일때 String 사용하면 감점
		char gender = '여';
		boolean food = true;
		System.out.println("오늘은 월요일입니다.");
		System.out.println(age + "세"); // 결합연산자
//		글자들: 문자+문자+문자...(여러글자, 문자열, String, 실)
		System.out.println("키: " + height);
		System.out.println("성별: " + gender);
		System.out.println("점심은 먹었나요? " + food);
		
	}

}
