package dbcp;

public class SingleTonTest {

	public static void main(String[] args) {
		ConManager con = ConManager.getInstance();
		System.out.println(con);
		ConManager con2 = ConManager.getInstance();
		System.out.println(con2);
		ConManager con3 = ConManager.getInstance();
		System.out.println(con3);
	}

}
