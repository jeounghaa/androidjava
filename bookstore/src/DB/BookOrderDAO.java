package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BookOrderDAO {
	
	public void create(BookOrderVO vo) throws Exception {
		// 1. connector설정
		Class.forName("com.mysql.jdbc.Driver");
		// 2. db연결
		String url = "jdbc:mysql://localhost:3366/bookstore?useUnicode=true&characterEncoding=utf8";
		String username = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, username, password);
		// 3. sql문 작성
		String sql = "insert into bookorder values(?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, vo.getPaycode());
		ps.setInt(2, vo.getBookcode());
		ps.setInt(3, vo.getTotal());
		ps.setBoolean(4, vo.getPaycheck());
		ps.setString(5, vo.getUsercode());
		ps.setString(6, vo.getDay());
		ps.setString(7, vo.getPayment());
		// 4. sql문 전송
		ps.executeUpdate();
		System.out.println("SQL문을 mySQL로 네트워크 전송 성공");
	}

	public ArrayList<BookOrderVO> readAll(String usercode) throws Exception {
		ArrayList<BookOrderVO> list = new ArrayList<BookOrderVO>();
		// 1. connector설정
		Class.forName("com.mysql.jdbc.Driver");
		// 2. db연결
		String url = "jdbc:mysql://localhost:3366/bookstore?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		// 3. sql문 작성
		String sql = "select * from bookorder where usercode = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, usercode);
		// 4. sql문 전송
		ResultSet rs = ps.executeQuery();
		// 결과가 있는지 없는지 체크해주는 메서드
		while (rs.next()) {
			BookOrderVO bag = new BookOrderVO(); // 가방만들어서
			int paycode = rs.getInt("paycode"); // 가방에서 하나씩 꺼냄
			int bookcode = rs.getInt("bookcode");
			int total = rs.getInt("total");
			boolean paycheck = rs.getBoolean("paycheck");
			String usercode2 = rs.getString("usercode");
			String day = rs.getString("day");
			String payment = rs.getString("payment");
			// 가방에 넣기
			bag.setPaycode(paycode);
			bag.setBookcode(bookcode);
			bag.setTotal(total);
			bag.setPaycheck(paycheck);
			bag.setUsercode(usercode2);
			bag.setDay(day);
			bag.setPayment(payment);
			// 컨테이너에 넣기
			list.add(bag);
		}
		return list;
	}
	
	public ArrayList<BookOrderVO> readcradit(int craditcode) throws Exception {
		ArrayList<BookOrderVO> list = new ArrayList<BookOrderVO>();
		// 1. connector설정
		Class.forName("com.mysql.jdbc.Driver");
		// 2. db연결
		String url = "jdbc:mysql://localhost:3366/bookstore?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		// 3. sql문 작성
		String sql = "select * from bookorder where paycode = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, craditcode);
		// 4. sql문 전송
		ResultSet rs = ps.executeQuery();
		// 결과가 있는지 없는지 체크해주는 메서드
		while (rs.next()) {
			BookOrderVO bag = new BookOrderVO(); // 가방만들어서
			int paycode = rs.getInt("paycode"); // 가방에서 하나씩 꺼냄
			int bookcode = rs.getInt("bookcode");
			int total = rs.getInt("total");
			boolean paycheck = rs.getBoolean("paycheck");
			String usercode2 = rs.getString("usercode");
			String day = rs.getString("day");
			String payment = rs.getString("payment");
			System.out.println("검색결과가 있어요.");
			// 가방에 넣기
			bag.setPaycode(paycode);
			bag.setBookcode(bookcode);
			bag.setTotal(total);
			bag.setPaycheck(paycheck);
			bag.setUsercode(usercode2);
			bag.setDay(day);
			bag.setPayment(payment);
			// 컨테이너에 넣기
			list.add(bag);
		}
		return list;
	}
	
	public void upTotal(int bookcode, int total) throws Exception {
		// 1. connector설정
		Class.forName("com.mysql.jdbc.Driver");
		// 2. db연결
		String url = "jdbc:mysql://localhost:3366/bookstore?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		// 3. sql문 작성
		String sql = "update bookorder set total = ? where bookcode = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, total);
		ps.setInt(2, bookcode);
		// 4. sql문 전송
		ps.executeUpdate();
	}
	
	public void delete(int paycode) throws Exception {
		// 1. connector설정
		Class.forName("com.mysql.jdbc.Driver");
		// 2. db연결
		String url = "jdbc:mysql://localhost:3366/bookstore?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		// 3. sql문 작성
		String sql = "delete from bookorder where paycode = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, paycode);
		// 4. sql문 전송
		ps.executeUpdate();
	}
	
	// 구매시 pay check를 true로 바꿔주는 DAO
	public void paycheck(BookOrderVO vo) throws Exception {
		// 1. connector설정 (driver)
		Class.forName("com.mysql.jdbc.Driver");
		// 2. db연결 (ip, id, pw)
		String url = "jdbc:mysql://localhost:3366/bookstore?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		// 3. id에 따라 두번째 주소 변경, 업데이트하는 sql문생성
		String sql = "update bookorder set paycheck = ?, day = ?, "
				+ "payment = ? where usercode = ? and paycode = ?";
		// 4. sql문 전송
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setBoolean(1, true);
		ps.setString(2, vo.getDay());
		ps.setString(3, vo.getPayment());
		ps.setString(4, vo.getUsercode());
		ps.setInt(5, vo.getPaycode());
		// 5.업데이트
		ps.executeUpdate();
	}// paycheck

}
