package 배열정리;

public class 이차원배열 {

	public static void main(String[] args) {
		int[][] seat = new int[3][5];
		// 배열을 선언하는 순간 공간이 할당
		// seat: 참조형변수(주소)
		// int[3][5]: 기본형 변수(값)
		// 배열은 자동 초기화 int -> 0
		System.out.println(seat);
		//   0 1 2 3 4
		// 0 0 0 0 0 0
		// 1 0 0 0 0 0 
		// 2 0 0 0 0 0
		seat[0][0] = 1;
		seat[0][4] = 1;
		seat[2][4] = 1;
		System.out.println("행의 개수: " + seat.length);
		for (int i = 0; i < seat.length; i++) {// 행 0 1 2
			for (int j = 0; j < seat[i].length; j++) {
				System.out.print(seat[i][j]);
			}
			System.out.println();
		}
	}

}
