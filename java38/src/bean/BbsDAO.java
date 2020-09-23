package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BbsDAO {
	String url = "jdbc:mysql://localhost:3366/shop1?useUnicode=true&characterEncoding=utf8";
	String user = "root";
	String password = "1234";
	Connection con;

	public BbsDAO() throws Exception {
		// 1. connector설정
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. connector 연결 성공..!");

		// 2. db연결
//				String url = "연걸하는방법://ip//port/db명"
		con = DriverManager.getConnection(url, user, password);
		System.out.println("2. db연결 성공..!");
	}

	public boolean create(BbsVO vo) throws Exception {
		// 3. sql문을 만든다(create)
		String sql = "insert into bbs values (?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, vo.getNo());
		ps.setString(2, vo.getTitle());
		ps.setString(3, vo.getContent());
		ps.setString(4, vo.getWriter());
		System.out.println("3. SQL생성 성공..!");

		// 4. sql문 전송
		int row = ps.executeUpdate();
		ps.close();
		con.close();
		System.out.println("4. SQL문 전송 성공..!");
		boolean result = false;
		if (row == 1) {
			result = true;
		}
		return result;
	}

	public BbsVO select(int no) throws Exception {
		// 3. sql문을 만든다(create)
		String sql = "select * from bbs where no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, no);
		System.out.println("3. SQL생성 성공..!");

		// 4. sql문 전송
		// select의 결과는 검색겨로가가 담긴 테이블(항목 + 내용)
		// 내용에는 없을 수도 있고, 많을 수도 있음
		ResultSet rs = ps.executeQuery();
		System.out.println("4. SQL문 전송 성공..!");
		BbsVO bag = new BbsVO(); // 가방만들어서
		if (rs.next()) {
			// 결과가 있는지 없는지 체크해주는 메서드
			System.out.println("검색결과가 있어요.");
			int no2 = rs.getInt("no");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String writer = rs.getString("writer");
			// 가방에 넣기
			bag.setNo(no2);
			bag.setTitle(title);
			bag.setContent(content);
			bag.setWriter(writer);

		} else {
			System.out.println("검색결과가 없어요.");
		}
		rs.close();
		ps.close();
		con.close();
		return bag;
		// bag은 참조형 변수, 주소를 전달
	}

	public ArrayList<BbsVO> all() throws Exception {
		// 가방을 넣는 컨테이너 역할을 하게 됨
		// <>안에는 컨테이너에 무엇을 넣을지 지정
		ArrayList<BbsVO> list = new ArrayList<BbsVO>();

		// 3. sql문을 만든다(create)
		String sql = "select * from bbs";
		PreparedStatement ps = con.prepareStatement(sql);
		System.out.println("3. SQL생성 성공..!");

		// 4. sql문 전송
		// select의 결과는 검색겨로가가 담긴 테이블(항목 + 내용)
		// 내용에는 없을 수도 있고, 많을 수도 있음
		ResultSet rs = ps.executeQuery();
		System.out.println("4. SQL문 전송 성공..!");
		// 결과가 있는지 없는지 체크해주는 메서드
		while (rs.next()) {
			BbsVO bag = new BbsVO(); // 가방만들어서
			int no2 = rs.getInt("no"); // 가방에서 하나씩 꺼냄
			String title = rs.getString("title");
			String content = rs.getString("content");
			String writer = rs.getString("writer");
			System.out.println("검색결과가 있어요.");
			// 가방에 넣기
			bag.setNo(no2); // 커서(위치 알려주는 역할)
			bag.setTitle(title);
			bag.setContent(content);
			bag.setWriter(writer);
			// 컨테이너에 넣기
			list.add(bag);
		}
		rs.close();
		ps.close();
		con.close();
		return list;
		// bag은 참조형 변수, 주소를 전달
	}

	public void update(int no, String title, String content) throws Exception {
		// 3. sql문을 만든다(create)
		String sql = "update bbs set title = ?, content = ? where no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		BbsVO vo = new BbsVO();
		ps.setString(1, title);
		ps.setString(2, content);
		ps.setInt(3, no);
		System.out.println("3. SQL생성 성공..!");

		// 4. sql문 전송
		ps.executeUpdate();
		ps.close();
		con.close();
		System.out.println("4. SQL문 전송 성공..!");
	}

	public void delete(int no) throws Exception {
		// 3. sql문을 만든다(create)
		String sql = "delete from bbs where no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		BbsVO vo = new BbsVO();
		ps.setInt(1, no);
		System.out.println("3. SQL생성 성공..!");

		// 4. sql문 전송
		ps.executeUpdate();
		ps.close();
		con.close();
		System.out.println("4. SQL문 전송 성공..!");
	}
}
