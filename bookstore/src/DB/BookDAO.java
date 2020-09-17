package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BookDAO {

	// 책 한개만 가져옴
	public BookVO read(int bookcode) throws Exception {
		// 1. connector설정
		Class.forName("com.mysql.jdbc.Driver");
		// 2. db연결
		String url = "jdbc:mysql://localhost:3366/bookstore?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		// 3. sql문 작성
		String sql = "select * from book where bookcode = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, bookcode);
		// 4. sql문 전송
		ResultSet rs = ps.executeQuery();
		BookVO bag = new BookVO(); // 가방만들어서
		if (rs.next()) {
			// 결과가 있는지 없는지 체크해주는 메서드
			int bookcode2 = rs.getInt("bookcode");
			String title = rs.getString("title");
			String writer = rs.getString("writer");
			String publisher = rs.getString("publisher");
			String field = rs.getString("field");
			int price = rs.getInt("price");
			String image = rs.getString("image");
			int sales = rs.getInt("sales");
			int stock = rs.getInt("stock");
			String intro = rs.getString("intro");
			// 가방에 넣기
			bag.setBookcode(bookcode2);
			bag.setTitle(title);
			bag.setWriter(writer);
			bag.setPublisher(publisher);
			bag.setField(field);
			bag.setPrice(price);
			bag.setImage(image);
			bag.setSales(sales);
			bag.setStock(stock);
			bag.setIntro(intro);
		} else {
			System.out.println("검색결과가 없어요.");
		}
		return bag;
	}

	// 재고가 많은 순으로 가져오기
	public ArrayList<BookVO> month() throws Exception {
		ArrayList<BookVO> list = new ArrayList<BookVO>();
		// 1. connector설정
		Class.forName("com.mysql.jdbc.Driver");
		// 2. db연결
		String url = "jdbc:mysql://localhost:3366/bookstore?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		// 3. sql문을 만든다(create)
		String sql = "select bookcode, image from book order by stock desc";
		PreparedStatement ps = con.prepareStatement(sql);
		// 4. sql문 전송
		ResultSet rs = ps.executeQuery();
		// 결과가 있는지 없는지 체크해주는 메서드
		while (rs.next()) {
			BookVO bag = new BookVO(); // 가방만들어서
			int bookcode = rs.getInt("bookcode");
			String image = rs.getString("image");
			// 가방에 넣기
			bag.setBookcode(bookcode);
			bag.setImage(image);
			// 컨테이너에 넣기
			list.add(bag);
		}
		return list;
	}

	// 국내,국외 db데이터를 list에 가져오기
	public ArrayList<BookVO> all(String find) throws Exception {
		// 1. connector설정 (driver)
		Class.forName("com.mysql.jdbc.Driver");// 외부에있는 파일과 연결할때는 예외처리가 필수다.
		// 2. db연결 (ip, id, pw)
		String url = "jdbc:mysql://localhost:3366/bookstore?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		// 3. sql문 생성.
		// ''가 있는 문장이기 때문에 +로 변환하여 바꿔준다.
		String sql = "select * from book where field like '" + find + "%'";
		// 4. sql문은 전송
		PreparedStatement ps = con.prepareStatement(sql);
		// 5. resultset으로 data 받아오기
		ResultSet rs = ps.executeQuery();
		// 6. BookVO 가방들을 넣을 arraylist 컨테이너 만들기
		ArrayList<BookVO> list = new ArrayList<BookVO>();

		while (rs.next()) { // data가 있는지 없는지 체크해주는 메서드
			BookVO bag = new BookVO(); // 7.컨테이너에 넣을 가방 만들기
			// 8.data 가져오기
			int bookcode = rs.getInt("bookcode");
			String title = rs.getString("title");
			String writer = rs.getString("writer");
			String publisher = rs.getString("publisher");
			String field = rs.getString("field");
			int price = rs.getInt("price");
			String image = rs.getString("image");
			int sales = rs.getInt("sales");
			int stock = rs.getInt("stock");
			String intro = rs.getString("intro");
			// 9.가방에 넣기
			bag.setBookcode(bookcode);
			bag.setTitle(title);
			bag.setWriter(writer);
			bag.setPublisher(publisher);
			bag.setField(field);
			bag.setPrice(price);
			bag.setImage(image);
			bag.setSales(sales);
			bag.setStock(stock);
			bag.setIntro(intro);
			// 10.컨테이너에 넣기
			list.add(bag);
		}
		return list;
		// 값이 들어있는 리스트 반환
	}// all
	
	// 판매량이 높은 db데이터를 list에 가져오는 DAO
		public ArrayList<BookVO> best(String find) throws Exception {
			// 1. connector설정 (driver)
			Class.forName("com.mysql.jdbc.Driver");// 외부에있는 파일과 연결할때는 예외처리가 필수다.
			// 2. db연결 (ip, id, pw)
			String url = "jdbc:mysql://localhost:3366/bookstore?useUnicode=true&characterEncoding=utf8";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);
			// 3. sql문 생성.
			// ''가 있는 문장이기 때문에 +로 변환하여 바꿔준다.
			String sql = "select * from book order by sales desc limit 10";

			// String sql = "select * from book where field like '" + find + "%'";
			// 4. sql문은 전송
			PreparedStatement ps = con.prepareStatement(sql);
			// 5. resultset으로 data 받아오기
			ResultSet rs = ps.executeQuery();
			// 6. BookVO 가방들을 넣을 arraylist 컨테이너 만들기
			ArrayList<BookVO> list = new ArrayList<BookVO>();

			while (rs.next()) { // data가 있는지 없는지 체크해주는 메서드
				BookVO bag = new BookVO(); // 7.컨테이너에 넣을 가방 만들기
				// 8.data 가져오기
				int bookcode = rs.getInt("bookcode");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String publisher = rs.getString("publisher");
				String field = rs.getString("field");
				int price = rs.getInt("price");
				String image = rs.getString("image");
				int sales = rs.getInt("sales");
				int stock = rs.getInt("stock");
				String intro = rs.getString("intro");
				// 9.가방에 넣기
				bag.setBookcode(bookcode);
				bag.setTitle(title);
				bag.setWriter(writer);
				bag.setPublisher(publisher);
				bag.setField(field);
				bag.setPrice(price);
				bag.setImage(image);
				bag.setSales(sales);
				bag.setStock(stock);
				bag.setIntro(intro);
				// 10.컨테이너에 넣기
				list.add(bag);
			}
			return list;
			// 값이 들어있는 리스트 반환
		}// best

}
