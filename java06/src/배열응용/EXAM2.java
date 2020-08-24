package 배열응용;

import javax.swing.JOptionPane;

public class EXAM2 {

	public static void main(String[] args) {

		String[] sub = new String[3];
		for (int i = 0; i < sub.length; i++) {
			sub[i] = JOptionPane.showInputDialog("과목을 입력해주세요.");
		}
		System.out.println("**" + sub[0] + "보다는 " + sub[1] + "**");
	}

}
