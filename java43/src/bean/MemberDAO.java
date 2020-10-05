package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//CRUD以묒떖�쑝濡� 湲곕뒫�쓣 �젙�쓽
//�뜲�씠�꽣�� 愿��젴�맂 �옉�뾽(Data Access Object: DAO)
public class MemberDAO {
	String url = "jdbc:mysql://localhost:3366/shop";
	String user = "root";
	String password = "1234";
	Connection con;
	
	public MemberDAO() throws Exception{
				// 1. connector�꽕�젙
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("1. connector�뿰寃� �꽦怨�.!!");

				// 2. db�뿰寃�
//				String url = "�뿰寃고븯�뒗諛⑸쾿://ip:port/db紐�";
				con = DriverManager.getConnection(url, user, password);
				System.out.println("2. db�뿰寃� �꽦怨�.!!");
	}
	public List<MemberVO> all() throws Exception {
		// 3. sql臾몄쓣 留뚮뱺�떎.
		String sql = "select * from member";
		PreparedStatement ps = con.prepareStatement(sql);

		// 4. sql臾몄� �쟾�넚
		ResultSet rs = ps.executeQuery();
		System.out.println("4. SQL臾� �쟾�넚 �꽦怨�.!!");
		
		List<MemberVO> list = new ArrayList<MemberVO>();
		while (rs.next()) { // 寃곌낵媛� �엳�뒗吏� �뾾�뒗吏� 泥댄겕�빐二쇰뒗 硫붿꽌�뱶
			//Object(vo) Relational DB(row) Mapping(ORM)
			MemberVO bag = new MemberVO();// 媛�諛⑸쭔�뱾�뼱�꽌,
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
		// bag�� 李몄“�삎 蹂��닔, 二쇱냼瑜� �쟾�떖!
	}
	
	public List<MemberVO> all(String tel) throws Exception {
		// 3. sql臾몄쓣 留뚮뱺�떎.
		String sql = "select * from member where tel = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, tel);
		
		// 4. sql臾몄� �쟾�넚
		ResultSet rs = ps.executeQuery();
		System.out.println("4. SQL臾� �쟾�넚 �꽦怨�.!!");
		
		List<MemberVO> list = new ArrayList<MemberVO>();
		while (rs.next()) { // 寃곌낵媛� �엳�뒗吏� �뾾�뒗吏� 泥댄겕�빐二쇰뒗 硫붿꽌�뱶
			//Object(vo) Relational DB(row) Mapping(ORM)
			MemberVO bag = new MemberVO();// 媛�諛⑸쭔�뱾�뼱�꽌,
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
		// bag�� 李몄“�삎 蹂��닔, 二쇱냼瑜� �쟾�떖!
	}
	
	public List<MemberVO> all2(String tel) throws Exception {
		// 3. sql臾몄쓣 留뚮뱺�떎.
		String sql = "select * from member where tel like '" + tel + "%'";
		PreparedStatement ps = con.prepareStatement(sql);
		
		// 4. sql臾몄� �쟾�넚
		ResultSet rs = ps.executeQuery();
		System.out.println("4. SQL臾� �쟾�넚 �꽦怨�.!!");
		
		List<MemberVO> list = new ArrayList<MemberVO>();
		while (rs.next()) { // 寃곌낵媛� �엳�뒗吏� �뾾�뒗吏� 泥댄겕�빐二쇰뒗 硫붿꽌�뱶
			//Object(vo) Relational DB(row) Mapping(ORM)
			MemberVO bag = new MemberVO();// 媛�諛⑸쭔�뱾�뼱�꽌,
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
		// bag�� 李몄“�삎 蹂��닔, 二쇱냼瑜� �쟾�떖!
	}
	
	public boolean create(MemberVO vo) throws Exception {
		// 3. sql臾몄쓣 留뚮뱺�떎.(create)
		String sql = "insert into member values (?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, vo.getId());
		ps.setString(2, vo.getPw());
		ps.setString(3, vo.getName());
		ps.setString(4, vo.getTel());
		System.out.println("3. SQL�깮�꽦 �꽦怨�.!!");
		
		// 4. sql臾몄� �쟾�넚
		int row = ps.executeUpdate();
		System.out.println("4. SQL臾� �쟾�넚 �꽦怨�.!!");
		boolean result = false;
		if(row == 1) {
			result = true;
		}
		ps.close();
		con.close();
		return result;
	}

	public boolean create(String id, String pw, String name, String tel) throws Exception {
		// 3. sql臾몄쓣 留뚮뱺�떎.(create)
		String sql = "insert into member values (?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ps.setString(2, pw);
		ps.setString(3, name);
		ps.setString(4, tel);
		System.out.println("3. SQL�깮�꽦 �꽦怨�.!!");

		// 4. sql臾몄� �쟾�넚
		int row = ps.executeUpdate();
		boolean result = false;
		if (row == 1) {
			result = true;
		} 
		System.out.println("4. SQL臾� �쟾�넚 �꽦怨�.!!");
		
		ps.close();
		con.close();
		return result;
	}

	public MemberVO one(String id) throws Exception {
		// 3. sql臾몄쓣 留뚮뱺�떎.(create)
		String sql = "select * from member where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);

		// 4. sql臾몄� �쟾�넚
		// select�쓽 寃곌낵�뒗 寃��깋寃곌낵媛� �떞湲� �뀒�씠釉�(�빆紐�+�궡�슜)
		// �궡�슜�뿉�뒗 �뾾�쓣 �닔�룄 �엳怨�, 留롮� �닔�룄 �엳�쓬.
		ResultSet rs = ps.executeQuery();
		System.out.println("4. SQL臾� �쟾�넚 �꽦怨�.!!");
		MemberVO bag = new MemberVO();//媛�諛⑸쭔�뱾�뼱�꽌,
		if (rs.next() == true) { // 寃곌낵媛� �엳�뒗吏� �뾾�뒗吏� 泥댄겕�빐二쇰뒗 硫붿꽌�뱶
			// if(rs.next())�� �룞�씪�븿.
			// if臾몄� rs.next()媛� true�븣留� �떎�뻾�릺誘�濡�!
			System.out.println("寃��깋寃곌낵媛� �엳�뼱�슂.");
			String id2 = rs.getString("id");
			String pw = rs.getString("pw");
			String name = rs.getString("name");
			String tel = rs.getString("tel");
			//媛�諛⑹뿉 �꽔湲�
			bag.setId(id2);
			bag.setPw(pw);
			bag.setName(name);
			bag.setTel(tel);
			System.out.println("寃��깋寃곌낵 id: " + id2);
			System.out.println("寃��깋寃곌낵 pw: " + pw);
			System.out.println("寃��깋寃곌낵 name: " + name);
			System.out.println("寃��깋寃곌낵 tel: " + tel);
		} else {
			System.out.println("寃��깋寃곌낵媛� �뾾�뼱�슂.");
		}
		
		rs.close();
		ps.close();
		con.close();
		
		return bag;
		// bag�� 李몄“�삎 蹂��닔, 二쇱냼瑜� �쟾�떖!
	}
	// id以묐났泥댄겕
	public int read(String id) throws Exception {
		// 3. sql臾몄쓣 留뚮뱺�떎.(create)
		String sql = "select * from member where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);

		// 4. sql臾몄� �쟾�넚
		// select�쓽 寃곌낵�뒗 寃��깋寃곌낵媛� �떞湲� �뀒�씠釉�(�빆紐�+�궡�슜)
		// �궡�슜�뿉�뒗 �뾾�쓣 �닔�룄 �엳怨�, 留롮� �닔�룄 �엳�쓬.
		ResultSet rs = ps.executeQuery();
		System.out.println("4. SQL臾� �쟾�넚 �꽦怨�.!!");
		int result = 0;// �뾾�쓬.
		if (rs.next() == true) { // 寃곌낵媛� �엳�뒗吏� �뾾�뒗吏� 泥댄겕�빐二쇰뒗 硫붿꽌�뱶
			// if(rs.next())�� �룞�씪�븿.
			// if臾몄� rs.next()媛� true�븣留� �떎�뻾�릺誘�濡�!
			System.out.println("寃��깋寃곌낵媛� �엳�뼱�슂.");
			result = 1; // �엳�쓬.
//			rs.getInt("no");//�젙�닔 媛�吏�怨� �삱�븣
//			rs.getDouble("num");//�떎�닔 媛�吏�怨� �삱�븣
			String id2 = rs.getString("id");
			String pw = rs.getString("pw");
			String name = rs.getString("name");
			String tel = rs.getString("tel");
			System.out.println("寃��깋寃곌낵 id: " + id2);
			System.out.println("寃��깋寃곌낵 pw: " + pw);
			System.out.println("寃��깋寃곌낵 name: " + name);
			System.out.println("寃��깋寃곌낵 tel: " + tel);
		} else {
			System.out.println("寃��깋寃곌낵媛� �뾾�뼱�슂.");
		}
		
		rs.close();
		ps.close();
		con.close();
		return result;
		// 0�씠 �꽆�뼱媛�硫�, 寃��깋寃곌낵 �뾾�쓬.
		// 1�씠 �꽆�뼱媛�硫�, 寃��깋寃곌낵 �엳�쓬.
	}

	// id, pw留욌뒗吏� 濡쒓렇�씤 泥섎━
	public boolean read(String id, String pw) throws Exception {

		// 3. sql臾몄쓣 留뚮뱺�떎.(create)
		String sql = "select * from member where id = ? and pw = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ps.setString(2, pw);

		// 4. sql臾몄� �쟾�넚
		// select�쓽 寃곌낵�뒗 寃��깋寃곌낵媛� �떞湲� �뀒�씠釉�(�빆紐�+�궡�슜)
		// �궡�슜�뿉�뒗 �뾾�쓣 �닔�룄 �엳怨�, 留롮� �닔�룄 �엳�쓬.
		ResultSet rs = ps.executeQuery();
		System.out.println("4. SQL臾� �쟾�넚 �꽦怨�.!!");
		boolean result = false;// 濡쒓렇�씤�씠 not!�씤 �긽�깭!
		if (rs.next() == true) { // 寃곌낵媛� �엳�뒗吏� �뾾�뒗吏� 泥댄겕�빐二쇰뒗 硫붿꽌�뱶
			System.out.println("濡쒓렇�씤 ok.");
			result = true; // �엳�쓬.
		} else {
			System.out.println("濡쒓렇�씤 not.");
		}
		rs.close();
		ps.close();
		con.close();
		return result;
		// false硫� 濡쒓렇�씤not.
		// true硫� 濡쒓렇�씤ok.
	}

	public boolean update(MemberVO vo) throws Exception {
	
		// 3. sql臾몄쓣 留뚮뱺�떎.(create)
		String sql = "update member set pw = ?, name = ?, tel = ? where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, vo.getPw());
		ps.setString(2, vo.getName());
		ps.setString(3, vo.getTel());
		ps.setString(4, vo.getId());
		System.out.println("3. SQL�깮�꽦 �꽦怨�.!!");

		// 4. sql臾몄� �쟾�넚
		int row = ps.executeUpdate();
		System.out.println("4. SQL臾� �쟾�넚 �꽦怨�.!!");
		ps.close();
		con.close();
		boolean result = false;
		if (row == 1) {
			result = true;
		}
		return result;
	}

	public boolean delete(String id) throws Exception {
		// 3. sql臾몄쓣 留뚮뱺�떎.(create)
		String sql = "delete from member where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		System.out.println("3. SQL�깮�꽦 �꽦怨�.!!");

		// 4. sql臾몄� �쟾�넚
		int row = ps.executeUpdate();
		System.out.println("4. SQL臾� �쟾�넚 �꽦怨�.!!");
		ps.close();
		con.close();
		boolean result = false;
		if (row == 1) {
			result = true;
		}
		return result;
	}
}
