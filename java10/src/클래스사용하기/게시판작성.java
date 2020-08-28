package 클래스사용하기;

import 클래스만들기.Bbs;

public class 게시판작성 {

	public static void main(String[] args) {
		Bbs bbs1 = new Bbs();
		bbs1.id = 1;
		bbs1.title = "java";
		bbs1.content = "fun java";
		bbs1.writer = "park";
		
		Bbs bbs2 = new Bbs();
		bbs2.id = 2;
		bbs2.title = "jsp";
		bbs2.content = "fun jsp";
		bbs2.writer = "kim";
		
		System.out.println("id, title, content, writer");
		System.out.println("--------------------------");
		System.out.println(bbs1);
		System.out.println(bbs2);
		bbs1.insert();
		bbs2.delete();
	}

}
