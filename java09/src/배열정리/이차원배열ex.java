package 배열정리;

public class 이차원배열ex {

	public static void main(String[] args) {
		int[][] test = new int[4][];
		int[] kor = {50, 60, 70, 80, 90};
		int[] math = {66, 77, 88};
		int[] eng = {90, 80, 70, 60};
		int[] sci = {77, 100};
		
		test[0] = kor;
		test[1] = math;
		test[2] = eng;
		test[3] = sci;
		
		for (int i = 0; i < test.length; i++) {
			for (int j = 0; j < test[i].length; j++) {
				System.out.print(test[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
