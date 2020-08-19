package 조건문;

public class Test1 {

	public static void main(String[] args) {
		String em_num = "A100EX";
		char num = em_num.charAt(0);
		String dep = "";
		switch (num) {
		case 'A':
			dep = "기획부";
			break;
		case 'B':
			dep = "총무부";
			break;
		case 'C':
			dep = "개발부";
			break;
		default:
			dep = "잘못된 입력";
			break;
		}
		System.out.println("사원부서는 " + dep + "입니다.");
		// 인덱스 1~3범위 추출이면 substring(1, 4)써줌
		// endIndex는 3보다 1큰 4를 써주어야 함
		System.out.println("사원고유 번호는 " + em_num.substring(1, 4) + "입니다.");
	}

}
