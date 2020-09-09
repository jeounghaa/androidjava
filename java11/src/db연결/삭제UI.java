package db연결;

import javax.swing.JOptionPane;

public class 삭제UI {

	public static void main(String[] args) throws Exception {
		MemberDAO db = new MemberDAO();
		
		String id = JOptionPane.showInputDialog("삭제할 id입력");
		
		db.delete(id);
	}

}
