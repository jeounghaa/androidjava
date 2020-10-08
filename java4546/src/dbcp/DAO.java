package dbcp;

public class DAO {
	static DAO dao = null;
	
	public static DAO getInstance() {
		if (dao == null) {
			dao = new DAO();
		}
		return dao;
	}
}
