package ����ȯCasting;

public class ����Ŭ���� {

	public static void main(String[] args) {
		// ����Ŭ����(Wrapper class, ����Ŭ����)
		// �⺻���� ���� �߰����� ����� �ٿ���
		// Ŭ������ ����� ���� ��
		// int -> Integer
		// double -> Double
		// char -> Character
		// boolean -> Boolean
		int x = 100;
		Integer y = new Integer(200);
		x = y; // �⺻���� ����Ŭ���������� �ڵ����� ��ȯ
		// �⺻�� <- ������: ���� ��ڽ�(auto unboxing)
		y = x;
		// ������ <- �⺻��: ���� �ڽ�(auto boxing)
	}

}
