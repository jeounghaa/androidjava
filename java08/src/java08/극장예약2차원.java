package java08;

import java.util.Scanner;

public class 극장예약2차원 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 열
		int col = 10;
		// 행
		int row = 3;
		
		int[][] seat = new int[row][col];
		
		while (true) {
			System.out.println("극장 좌석");
			System.out.println("-----------------------------");
			System.out.print("    ");
			for (int i = 0; i < col ; i++) {
				System.out.print(i + " ");
			}
			System.out.println();
			for (int i = 0; i < row; i++) {
				System.out.print(i + "   ");
				for (int j = 0; j < col; j++) {
					System.out.print(seat[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println("예매하고싶은 좌석을 입력해주세요(종료를 원할 시 '종료'라고 입력)   ex)09");
			// 예매하고자하는 좌석을 String으로 입력받음
			System.out.print(">> ");
			String choice = sc.next();
			System.out.println(choice);
			
			if(choice.equals("종료")) {
				// 종료라고 입력 받을 시 무한 루프 종료
				System.out.println("시스템을 종료합니다. 감사합니다.");
				break;
			} else {
				// 아니면 받은 값을 하나하나 따로 나누어 int로 변경
				int o = Integer.parseInt(choice.substring(0, 1));
				int t = Integer.parseInt(choice.substring(1, 2));
				if (seat[o][t] == 1) {
					// seat배열의 값이 1인 값을 입력받으면 다시 입력하게
					System.out.println("\n이미 예약된 좌석입니다.");
					System.out.println("다시 입력해주세요.\n");
				} else if (seat[o][t] == 0){
					// 아니면 seat배열의 값을 1로 변경
					seat[o][t] = 1;
					System.out.println("\n예약되었습니다.");
				}
				
			}
				
		}
	}

}
