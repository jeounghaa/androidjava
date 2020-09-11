package 스태틱;

public class 직원 {
	String name; // 이름
	String gender; // 성별
	int age; // 나이
	static int count; // 직원 수 합계
	static int sum; // 직원들의 나이 합계
	
	public 직원(String name, String gender, int age) {
		super();
		count++;
		sum = sum + age;
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	@Override
	public String toString() {
		return "직원 [이름=" + name + ", 성별=" + gender + ", 나이=" + age + "]";
	}
}
