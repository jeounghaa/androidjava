package 스태틱;

public class Day {
	String doing; // 무엇을 했는지
	int time; // 몇시간을 했는지
	String location; // 어디에서 했는지
	final static String company = "mega";
	// final은 이 설정이 끝, 변경불가능
	static int count; // 전역변수는 자동초기화가 됨. 0으로 초기화
	static int sum; // 시간누적

	public Day(String doing, int time, String location) {
		super();
		count++;
		sum = sum + time;
		this.doing = doing;
		this.time = time;
		this.location = location;
	}
	// static 메서드(정적 메서드): 객체 생성하지 않안도 이 기능을 바로 사용 가능
	// 클래스 이름으로 바로 접근해서 사용할 수 있는 메서드로 만드는 것이 좋다
	public static String getName() {
		return company; // static메서드 내에서는 인스턴스 사용 불가
	}
	// 자주 사용하는 기능의 메서드는 바로바로 쓸 수 있게 만들어 주는 것이 좋다
	// Integer.parseInt(), JOptionPane.showInputDialog() ...
	
	// 일반 메서드: 객체 생성 후, 참조형 변수의 주소로 접근 가능
	public int getAvg() {
		return sum/count;
	}

	@Override // 재정의, 오버라이드, 오버라이딩
	public String toString() {
		return "Day [doing=" + doing + ", time=" + time + ", location=" + location + "]";
	}

}
