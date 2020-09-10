package db연결;

import javax.swing.JOptionPane;

public class 회원정보수정UI {

	public static void main(String[] args) throws Exception {
		String id = JOptionPane.showInputDialog("id입력");
		String tel = JOptionPane.showInputDialog("tel입력");
		
		MemberDAO db = new MemberDAO();
		db.update(tel, id);
	}

}
