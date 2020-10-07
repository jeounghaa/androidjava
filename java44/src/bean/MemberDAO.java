package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	String url = "jdbc:mysql://localhost:3366/shop";
	String user = "root";
	String password = "1234";
	Connection con;

	public MemberDAO() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		con = DriverManager.getConnection(url, user, password);
	}

	public List<MemberVO> all() throws Exception {
		String sql = "select * from member";
		PreparedStatement ps = con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		List<MemberVO> list = new ArrayList<MemberVO>();
		while (rs.next()) {
			MemberVO bag = new MemberVO();
			bag.setId(rs.getString("id"));
			bag.setPw(rs.getString("pw"));
			bag.setName(rs.getString("name"));
			bag.setTel(rs.getString("tel"));
			list.add(bag);
		}
		rs.close();
		ps.close();
		con.close();
		return list;
	}

	public List<MemberVO> all(String tel) throws Exception {
		String sql = "select * from member where tel = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, tel);

		ResultSet rs = ps.executeQuery();

		List<MemberVO> list = new ArrayList<MemberVO>();
		while (rs.next()) {
			MemberVO bag = new MemberVO();
			bag.setId(rs.getString("id"));
			bag.setPw(rs.getString("pw"));
			bag.setName(rs.getString("name"));
			bag.setTel(rs.getString("tel"));
			list.add(bag);
		}
		rs.close();
		ps.close();
		con.close();
		return list;
	}

	public List<MemberVO> all2(String tel) throws Exception {
		String sql = "select * from member where tel like '" + tel + "%'";
		PreparedStatement ps = con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		List<MemberVO> list = new ArrayList<MemberVO>();
		while (rs.next()) {
			MemberVO bag = new MemberVO();
			bag.setId(rs.getString("id"));
			bag.setPw(rs.getString("pw"));
			bag.setName(rs.getString("name"));
			bag.setTel(rs.getString("tel"));
			list.add(bag);
		}
		rs.close();
		ps.close();
		con.close();
		return list;
	}

	public boolean create(MemberVO vo) throws Exception {
		String sql = "insert into member values (?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, vo.getId());
		ps.setString(2, vo.getPw());
		ps.setString(3, vo.getName());
		ps.setString(4, vo.getTel());

		int row = ps.executeUpdate();
		boolean result = false;
		if (row == 1) {
			result = true;
		}
		ps.close();
		con.close();
		return result;
	}

	public boolean create(String id, String pw, String name, String tel) throws Exception {
		String sql = "insert into member values (?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ps.setString(2, pw);
		ps.setString(3, name);
		ps.setString(4, tel);

		int row = ps.executeUpdate();
		boolean result = false;
		if (row == 1) {
			result = true;
		}

		ps.close();
		con.close();
		return result;
	}

	public MemberVO one(String id) throws Exception {
		String sql = "select * from member where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);

		ResultSet rs = ps.executeQuery();
		System.out.println("4. SQL�눧占� 占쎌읈占쎈꽊 占쎄쉐�⑨옙.!!");
		MemberVO bag = new MemberVO();
		if (rs.next() == true) {
			System.out.println("野껓옙占쎄퉳野껉퀗�궢揶쏉옙 占쎌뿳占쎈선占쎌뒄.");
			String id2 = rs.getString("id");
			String pw = rs.getString("pw");
			String name = rs.getString("name");
			String tel = rs.getString("tel");
			bag.setId(id2);
			bag.setPw(pw);
			bag.setName(name);
			bag.setTel(tel);
		} else {
			System.out.println("data not");
		}

		rs.close();
		ps.close();
		con.close();

		return bag;
	}

	// id餓λ쵎�궗筌ｋ똾寃�
	public int read(String id) throws Exception {
		String sql = "select * from member where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);

		ResultSet rs = ps.executeQuery();
		System.out.println("4. SQL�눧占� 占쎌읈占쎈꽊 占쎄쉐�⑨옙.!!");
		int result = 0;
		if (rs.next() == true) {
			result = 1;
		} else {
			System.out.println("data not");
		}

		rs.close();
		ps.close();
		con.close();
		return result;
	}

	public boolean read(String id, String pw) throws Exception {

		String sql = "select * from member where id = ? and pw = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ps.setString(2, pw);

		ResultSet rs = ps.executeQuery();
		System.out.println("4. SQL�눧占� 占쎌읈占쎈꽊 占쎄쉐�⑨옙.!!");
		boolean result = false;
		if (rs.next() == true) {
			result = true;
		} else {
			System.out.println("data not.");
		}
		rs.close();
		ps.close();
		con.close();
		return result;
	}

	public boolean update(MemberVO vo) throws Exception {

		String sql = "update member set pw = ?, name = ?, tel = ? where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, vo.getPw());
		ps.setString(2, vo.getName());
		ps.setString(3, vo.getTel());
		ps.setString(4, vo.getId());
		int row = ps.executeUpdate();
		ps.close();
		con.close();
		boolean result = false;
		if (row == 1) {
			result = true;
		}
		return result;
	}

	public boolean delete(String id) throws Exception {
		String sql = "delete from member where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);

		int row = ps.executeUpdate();
		ps.close();
		con.close();
		boolean result = false;
		if (row == 1) {
			result = true;
		}
		return result;
	}
}
