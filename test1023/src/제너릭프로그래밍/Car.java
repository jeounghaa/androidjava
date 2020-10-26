package 제너릭프로그래밍;

// 특정한 타입을 지정하지 않고 일반적으로 타입을 지정만 해서
// generic이라고 한다.
public class Car<T> {
	T size;
	
	public Car(T size) {
		this.size = size;
	}

	public T getSize() {
		return size;
	}

}
