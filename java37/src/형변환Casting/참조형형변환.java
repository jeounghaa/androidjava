package ����ȯCasting;

import java.util.ArrayList;

public class ����������ȯ {

	public static void main(String[] args) {
		// ��Ӱ��迡���� ����ȯ(Casting, ĳ����) ����
		// Car(�θ�, ����Ŭ����), Truck(�ڽ�, ����Ŭ����)
		// Ŭ�������� ��Һ��� ���� ���������� ����
		// �θ�Ŭ������ ũ��, �ڽ�Ŭ������ �۴�
		ArrayList list = new ArrayList();
		// ��� Ÿ���� ���� �� ����. ũ�Ⱑ ������
		list.add("ȫ�浿");
		// Object(ū) <- String(��): �ڵ�����ȯ
		// ��ĳ����
		list.add(100);
		// Object <--upcasting-- Integer <--auto boxing-- int
		list.add(11.22);
		list.add(true);
		list.add('A');
		list.add(new VO());
		System.out.println("��ϳ���: " + list);
		// ��ĳ����(�ڵ�����ȯ)���� String�� Object���� ����ȯ�Ͽ� ���� ���� 
		// ������ �� Object���� �ų��� String���� �߰��� ����� �� �� ����.
		// ���� ��, String���� ����ȯ�Ͽ� ������ �Ѵ�.
		// ��������ȯ, down casting(�ٿ�ĳ����)
		String name = (String) list.get(0);
		int age = (int) list.get(1); // (Integer)�� �ᵵ ���x
		// �⺻�� <--auto unboxing-- Integer <--down casting-- Object
	}

}
