package 클래스만들기;

public class Bbs {
	public int id;
	public String title;
	public String content;
	public String writer;
	
	public void insert() {
		System.out.println("글을 쓰다");
	}
	public void delete() {
		System.out.println("글을 삭제하다");
	}
	public void read() {
		System.out.println("글을 읽다");
	}
	public void update() {
		System.out.println("글을 수정하다");
	}
	
	@Override
	public String toString() {
		return id + ", " + title + ", " + content + ", " + writer;
	}
	
	
}
