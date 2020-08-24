package 배열응용;


import java.util.Scanner;


public class EXAM4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] num = new int[5];
		for (int i = 0; i < num.length; i++) {
//			String n = JOptionPane.showInputDialog("1~5까지의 값을 입력해주세요.");
//			num[i] = Integer.parseInt(n);
			System.out.print("숫자 >> ");
			num[i] = sc.nextInt();
		}
		for (int j = 0; j < num.length; j++) {
			System.out.println(num[j]);
		}
	}

}
