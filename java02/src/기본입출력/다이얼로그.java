package 기본입출력;

import javax.swing.JOptionPane;

public class 다이얼로그 {

	public static void main(String[] args) {
//		자바에서의 코딩 방식
//		특정한 일을 처리하는 부품을 만들어 전담시킨다.
//		자바에서는 자주 사용되는 부품은 미리 메모리에 가져다 놓고 있음
//		부품의 이름을 대문자로 시작해서 사용하면 됨
		String hour = JOptionPane.showInputDialog("지금 몇시인가요?");
//		JOptionPane.showMessageDialog(null, hour + "시 입니다.");
//		기능을 처리해주는 단위: function(함수)
		
//		int <- String
//		부품을 써야함
		int ihour = Integer.parseInt(hour);
		if (ihour < 16) { // 조건에는 비교연산자를 쓰고 비교연산자의 결과는 논리
//			true일 때 실행
			JOptionPane.showMessageDialog(null, "아직 멀었어요.....");
		} else {
//			false일 때 실행
			JOptionPane.showMessageDialog(null, "조금만 버티세요....");
		}
	}

}
