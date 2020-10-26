package 추상클래스;

// 인터페이스는 다중상속이 된다.
// 메가폰이 되기 위한 규칙을 정의하는 문서의 역할
public interface MegaPhone  extends Phone, Gps{
	public final String COMPANY = "mega";
	public abstract void siri();
}
