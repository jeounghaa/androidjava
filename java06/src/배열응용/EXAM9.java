package 배열응용;

import java.util.Arrays;
import java.util.Scanner;

public class EXAM9 {

	public static void main(String[] args) {
		// 투표시스템
		Scanner sc = new Scanner(System.in);
		String[] names = {"A", "B", "C", "D", "E"};
		int[] t = new int[names.length];
		int choice;
		int count = 0;
		while (true) {
			System.out.print("투표 (5입력 시 종료)>> ");
			choice = sc.nextInt();
			if (choice == 5) {
				break;
			} else if (choice >=0 && choice < 5){
				count++;
				t[choice] += 1;
			} else {
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
			}
		}
		
		int max = 0;
		int a = 0;
		// 최대값
		for (int i = 0; i < t.length; i++) {
			if (t[i] > max) {
				max = t[i];
				a = i;
			}
		}
//		System.out.println(a);
		
		int b = 0;
		
		int[] t2 = t.clone();
		Arrays.sort(t2);
		for (int i = 0; i < t2.length; i++) {
			System.out.println(t2[i]);
		}

		for (int i = 0; i < t.length; i++) {
			if (t[i] == t2[t2.length-2]) {
//				System.out.println(i);
				b = i;
			}
		}
		
		String result = "";
		for (int i = 0; i < t.length; i++) {
			if (count != 0) {
				result = "1등: " + names[a] + ", " + max + "표" + "\n"
						+ "2등: " + names[b] + ", " + t[b] + "표";
			} else {
				result = "투표결과가 없습니다.";
			}
		}
		System.out.println(result);
		
	}

}
