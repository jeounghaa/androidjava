package 인터페이스;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class 이벤트처리클래스2 implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("두번째 버튼을 눌렀음...");
	}

}
