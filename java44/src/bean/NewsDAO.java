package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class NewsDAO {
	String url = "jdbc:mysql://localhost:3366/shop?useUnicode=true&characterEncoding=utf8";
	String user = "root";
	String password = "1234";
	Connection con;

	public NewsDAO() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. connector�뿰寃� �꽦怨�.!!");

		con = DriverManager.getConnection(url, user, password);
		System.out.println("2. db�뿰寃� �꽦怨�.!!");
	}

	public boolean create(NewsVO vo) throws Exception {
		String sql = "insert into news values (?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, vo.getTitle());
		ps.setString(2, vo.getPubDate());
		ps.setString(3, vo.getLink());
		ps.setString(4, vo.getGuid());
		ps.setString(5, vo.getAuthor());
		ps.setString(6, vo.getThumbnail());
		ps.setString(7, vo.getDescription());
		ps.setString(8, vo.getContent());
		ps.setString(9, vo.getEnclosure());
		ps.setString(10, vo.getCategories());

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
