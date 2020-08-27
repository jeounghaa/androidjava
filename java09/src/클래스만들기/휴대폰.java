package 클래스만들기;

class 휴대폰 { // 틀역할
//	가눙(동작): 전화하다, 문자하다, 검색하다 -> 멤버 메서드 정의
//	속성: 색, 크기, 회사 -> 멤버변수 정의
	// 틀 역할을 하기때문에 초기화값은 넣지 않음
	String color;
	int size;
	String company;
	
	public void call() {
		System.out.println("전화하다");
	}

	public void text() {
		System.out.println("문자하다");
	}

	public void search() {
		System.out.println("검색하다");
	}
}
