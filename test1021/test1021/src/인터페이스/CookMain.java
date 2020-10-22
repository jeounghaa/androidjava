package 인터페이스;

import javax.swing.JOptionPane;

public class CookMain {

	public static void main(String[] args) {
		// 한식 or 중식을 입력받음
		String food = JOptionPane.showInputDialog("뭐드실래요? 한식/중식");
		// 입력받은 값을 cookmanager에 넣음
		CookManager m = new CookManager(food);
		// 입력받은 값의 salad와 soup의 값을 출력
		m.salad();
		m.soup();
	}

}
