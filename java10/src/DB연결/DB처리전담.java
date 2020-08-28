package DB연결;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

// 특정한 방법을 처리하는 클래스: 방법(model)클래스
public class DB처리전담 {
	// DB처리하는 방법이 4단계로 정해져있다.
	public void create(String id, String pw, String name, String tel) throws Exception {
		System.out.println("DB에 저장처리함");
		// 1. connector 설정
		Class.forName("com.mysql.jdbc.Driver");
		// 자바에서는 에러가 너무 많이 발생할 것 같은 상황에서는 반드시
		// 에러처리를 반드시 해주어야 함
		// 네트워크 연결, db연결, 파일연결, cpu연결
		String url = "jdbc:mysql://localhost:3366/shop";
		String username = "root";
		String password = "12341234";
		Connection con = DriverManager.getConnection(url, username, password);
		System.out.println("shop 연결 성공");
		
		// DB연동하는 index는 1부터 시작
		String sql = "insert into member values(?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ps.setString(2, pw);
		ps.setString(3, name);
		ps.setString(4, tel);
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
