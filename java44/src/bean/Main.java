package bean;

public class Main {

	public static void main(String[] args) {
		int[] num = {1, 2, 3};
		// ������ for��
		for (int i = 0; i < num.length; i++) {
			System.out.println(num[i]);
		}
		System.out.println();
		// for-each(�ϳ��� ������� �����´�)
		for (int i : num) {
			System.out.println(i);
		}
	}

}
