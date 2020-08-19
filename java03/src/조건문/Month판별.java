package 조건문;

public class Month판별 {

	public static void main(String[] args) {
		int month = 9;
		// 정수(byte, short, int), 문자, 문자열(String), 실수-불가능
		switch (month) {
		case 2:
			System.out.println("28일까지 있습니다.");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("30일까지 있습니다.");
			break;
		default:
			System.out.println("31일까지 있습니다.");
			break;
		}
	}

}
