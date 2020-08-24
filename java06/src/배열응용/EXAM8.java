package 배열응용;

import java.util.Scanner;

public class EXAM8 {

	public static void main(String[] args) {
		// 투표시스템
		Scanner sc = new Scanner(System.in);
		String[] names = {"A", "B", "C", "D", "E"};
		int[] t = new int[names.length];
		int choice;
		while (true) {
			System.out.print("투표 >> ");
			choice = sc.nextInt();
			if (choice >= 6) {
				break;
			} else {
				t[choice] += 1;
			}
		}
		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i] + "는 " + t[i] + "표");
		}
		
	}

}
