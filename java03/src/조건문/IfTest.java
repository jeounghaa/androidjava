package 조건문;

public class IfTest {

	public static void main(String[] args) {
		String data = "ok";
		if (data.equals("ok")) {
			System.out.println("긍정");
		} else if (data.equals("no")){
			System.out.println("부정");
		} else {
			System.out.println("잘 모르겠음");
		}
	}

}
