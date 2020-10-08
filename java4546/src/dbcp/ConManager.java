package dbcp;

public class ConManager {
	static ConManager con = null;
	
	// 객체가 만들어졌는지 체크
	// 객체가 안만들어졌으면 만들어줌
	// 객체가 이미 하나 만들어져 있으면 안만들어줌
	// 객체를 리턴
	public static ConManager getInstance() {
		if (con == null) {
			con = new ConManager();
		}
		
		return con;
	}
}
