package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MemberDAO2 {
	String url = "jdbc:mysql://localhost:3366/shop";
	String user = "root";
	String password = "1234";
	Connection con;

	public MemberDAO2() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url, user, password);
	}

	public boolean create(MemberVO2 vo) throws Exception {
		String sql = "insert into member2 values (?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, vo.getId());
		ps.setString(2, vo.getFirst_name());
		ps.setString(3, vo.getLast_name());
		ps.setString(4, vo.getEmail());
		ps.setString(5, vo.getGender());
		ps.setString(6, vo.getIp_address());

		int row = ps.executeUpdate();
		boolean result = false;
		if (row == 1) {
			result = true;
		}
		ps.close();
		con.close();
		return result;
	}
}
