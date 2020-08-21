package 배열기본;

public class 값이정해져있는경우2 {

	public static void main(String[] args) {
		// 이름, 나이, 성별, 아침, 몸무게 배열 만들어서 프린트
		String[] names = {"김", "이", "박"};
		int[] age = {20, 21, 25};
		char[] gender = {'여', '남', '여'};
		boolean[] breakf = {false, true, true};
		double[] weight = {60.0, 70.0, 80.0};

		for (int i = 0; i < names.length; i++) {
//			System.out.println("이름: " + names[i]);
//			System.out.println("나이: " + age[i]);
//			System.out.println("성별: " + gender[i]);
//			System.out.println("아침여부: " + breakf[i]);
//			System.out.println("몸무게: " + weight[i]);
//			System.out.println();
		}
		for (String n : names) {
			System.out.print(n + "   ");
		}
		System.out.println();
		for (int a : age) {
			System.out.print(a + "   ");
		}
		System.out.println();
		for (char g : gender) {
			System.out.print(g + "   ");
		}
		System.out.println();
		for (boolean b : breakf) {
			System.out.print(b + "   ");
		}
		System.out.println();
		for (double d : weight) {
			System.out.print(d + "   ");
		}
	}

}
