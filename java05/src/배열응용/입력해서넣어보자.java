package 배열응용;

import javax.swing.JOptionPane;

public class 입력해서넣어보자 {

	public static void main(String[] args) {
		// 입력을 받아서 저장공간에 넣고
		// 나중에 꺼내서 연산이나 출력을 하고자 하는 경우
		String data = null; //참조형은 null로 초기화 시켜줘야 함
		for (int i = 0; i < 3; i++) {
			// 변수 선언의 위치가 변수를 사용할 수 있는 범위를 결정
			data = JOptionPane.showInputDialog("숫자입력");
		}
		System.out.println(data);
	}

}
