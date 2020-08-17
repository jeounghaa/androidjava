package 연산자;

import javax.swing.JOptionPane;

public class 기본입출력 {

	public static void main(String[] args) {
//		창을 띄워서 입력을 받아보자
//		창을 띄워서 출력을 해보자
//		자주 사용하는 것은 부품의 대문자를 그대로 쓴다.
//		특정한 일을 전담하는 부품을 만들어서 특정한 처리를 할 때
//		부품을 지정함.

//		cpu를 통해 값을 받아와서 name변수를 ram에 저장
		String name = JOptionPane.showInputDialog("이름은 무엇인가요?");
//		ram에서 name변수를 가져옴
		System.out.println("당신의 이름은 " + name);
//		cpu를 통해 값을 받아와서 age변수를 ram에 저장
		String age = JOptionPane.showInputDialog("당신의 나이는?");
		
//		키보드로 입력한 데이터 타입은 무조건 String!
//		String으로 저장된 데이터를 int/String으로 쓸지는 내가 결정
//		계산의 유무: 계산해야하는 경우는 int로 변환해주어야함
//		숫자로 바꿔보자.
		
//		ram에서 String변수 age를 가져와서 cpu로 int변환한 후 age2변수를 ram에 저장 
		int age2 = Integer.parseInt(age);
//		ram에 cpu로 저장된 age2를 -1 계산하여 lastAge변수를 ram에 저장
		int lastAge = age2 - 1;
//		ram에 저장된 lastAge를 가져와서 출력
		System.out.println("당신의 작년 나이는 " + lastAge);
	}

}
