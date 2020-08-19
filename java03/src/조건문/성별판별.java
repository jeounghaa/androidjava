package 조건문;

public class 성별판별 {

	public static void main(String[] args) {
		String ssn = "880115-1056512";
		// 프로그램 언어로 문자를 char로 받을 수 있는 방법은 없다
		// String으로 입력을 받아서, 원하는 char만 추출을 함
		char gender = ssn.charAt(7);
		// 위치를 가지고 특정한 문자 한개를 추출하면 됨
		// 위치 = index, 인덱스
		// 인덱스는 0부터 시작
//		System.out.println(gender);
		switch (gender) {
		case '2':
		case '4':
			System.out.println("여자");
			break;
		case '1':
		case '3':
			System.out.println("남자");
			break;
		default:
			System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
			break;
		}
	}

}
