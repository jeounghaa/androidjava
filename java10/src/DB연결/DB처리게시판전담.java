package DB연결;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DB처리게시판전담 {
	public void create(String title, String content, String writer) throws Exception {
		System.out.println("DB에 저장처리함");
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3366/shop";
		String username = "root";
		String password = "12341234";
		Connection con = DriverManager.getConnection(url, username, password);
		System.out.println("shop 연결 성공");
		
		String sql = "insert into bbs values(null, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, title);
		ps.setString(2, content);
		ps.setString(3, writer);
		System.out.println("SQL문 성공");
		
		ps.executeUpdate();
		System.out.println("SQL문을 mySQL로 네트워크 전송 성공");
	}
		
	public void read() {
		
	}
	public void update() {
		
	}
	public void delete() {
		
	}
	
}
