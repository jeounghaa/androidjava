package bean;

public class MemberVO {
	//private라고 쓰면, 이 클래스내에서만 변수에 접근해서 쓸 수 있음.
	private String id; 
	private String pw;
	private String name;
	private String tel;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	//각 변수에 값을 넣는/빼는 메서드를 정의하면 됨.!
	//가방에 넣을 때는 set메서드로 정의: setters
	//가방에서 꺼낼 때는 get메서드로 정의: getters
	
	}
