package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserDAO {

	public void create(UserVO vo) throws Exception {
		// 1. connector설정
		Class.forName("com.mysql.jdbc.Driver");
		// 2. db연결
		String url = "jdbc:mysql://localhost:3366/bookstore?useUnicode=true&characterEncoding=utf8";
		String username = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, username, password);
		// 3. sql문 작성
		String sql = "insert into user values(?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, vo.getId());
		ps.setString(2, vo.getPassword());
		ps.setString(3, vo.getName());
		ps.setString(4, vo.tel);
		ps.setString(5, vo.getEmail());
		ps.setString(6, vo.getAddress());
		ps.setString(7, vo.getAddresstwo());
		// 4. sql문 전송
		ps.executeUpdate();
		System.out.println("SQL문을 mySQL로 네트워크 전송 성공");
	}

	// 로그인 확인
	public Boolean login(String id, String pw) throws Exception {
		// 1. connector설정 (driver)
		Class.forName("com.mysql.jdbc.Driver");
		// 2. db연결 (ip, id, pw)
		String url = "jdbc:mysql://localhost:3366/bookstore?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		// 3. 아이디와 패스워드 확인하는 sql문 생성
		String sql = "select * from user where id = ? and password = ?";
		// 4. sql문 전송
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ps.setString(2, pw);
		// 5. resultset으로 data 받아오기
		ResultSet rs = ps.executeQuery();
		// 결과가 있는지 없는지 체크해주는 메서드
		if (rs.next()) {
			// 6.data 가져와서 체크
			String idch = rs.getString("id");
			String pwch = rs.getString("password");
			// 두개의 결과가 같으면 true 출력
			if (id.equals(idch) && pw.equals(pwch)) {
				return true;
			} else {
				// 두개의 결과가 다르면 false출력
				return false;
			}
			// 검색결과가 없으면 false출력
		} else {
			return false;
		}
	}// login

	// user 정보 가져오기
	public ArrayList<UserVO> read(String userid) throws Exception {
		// 1. connector설정 (driver)
		Class.forName("com.mysql.jdbc.Driver");
		// 2. db연결 (ip, id, pw)
		String url = "jdbc:mysql://localhost:3366/bookstore?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		// 3. 아이디로 정보 확인하는 sql문 생성
		String sql = "select * from user where id = ?";
		// 4. sql문 전송
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, userid);
		// 5. resultset으로 data 받아오기
		ResultSet rs = ps.executeQuery();
		// 6. BookVO 가방들을 넣을 arraylist 컨테이너 만들기
		ArrayList<UserVO> list = new ArrayList<UserVO>();

		while (rs.next()) { // data가 있는지 없는지 체크해주는 메서드
			UserVO bag = new UserVO(); // 7.컨테이너에 넣을 가방 만들기
			// 8.data 가져오기
			String id = rs.getString("id");
			String pw = rs.getString("password");
			String name = rs.getString("name");
			String address = rs.getString("address");
			String addresstwo = rs.getString("addresstwo");
			String email = rs.getString("email");
			String tel = rs.getString("tel");
			// 9.가방에 넣기
			bag.setId(id);
			bag.setPassword(pw);
			bag.setName(name);
			bag.setAddress(address);
			bag.setAddresstwo(addresstwo);
			bag.setEmail(email);
			bag.setTel(tel);
			// 10.컨테이너에 넣기
			list.add(bag);
		}
		return list; // 값이 들어있는 리스트 반환
	}// read

	// 배송지 수정
	public void update(UserVO vo) throws Exception {
		// 1. connector설정 (driver)
		Class.forName("com.mysql.jdbc.Driver");
		// 2. db연결 (ip, id, pw)
		String url = "jdbc:mysql://localhost:3366/bookstore?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		// 3. id에 따라 두번째 주소 변경, 업데이트하는 sql문생성
		String sql = "update user set addresstwo = ? where id =?";
		// 4. sql문 전송
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, vo.getAddresstwo());
		ps.setString(2, vo.getId());
		// 5. 업데이트 실행
		ps.executeUpdate();
	}// update

}
