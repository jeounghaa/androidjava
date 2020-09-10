package db연결;

import java.util.ArrayList;

public class 게시판전체목록프린트 {

	public static void main(String[] args) throws Exception {
		BbsDAO dao = new BbsDAO();
		ArrayList<BbsVO> list = dao.all();
		System.out.println("게시판의 개수: " + list.size());
		for (int i = 0; i < list.size(); i++) { // 속성개수
			BbsVO bag = list.get(i);
			System.out.println("no: " + bag.getNo());
			System.out.println("writer: " + bag.getWriter());
			System.out.println("title: " + bag.getTitle());
			System.out.println("content: " + bag.getContent());
			System.out.println("-------");
		}
	}
	

}
