package ����ȯCasting;

public class �⺻������ȯ {

	public static void main(String[] args) {
		// primitive(��������, �������� ����) data: �⺻�� ������, ���� ������
		// <-> derived(�Ļ���, ������) data: ������ ������, �Ļ� ������
		// ũ�⿡ ���� ���� ����ؾ���
		// ���� byte(1) - short(2) - int(4) - long(8)
		byte a = 100; // -128 ~ 127
		int b = a; // �⺻�� ����
		// int(ū) <- byte(��): �ڵ�����ȯ

		
		int c = 128;
		byte d = (byte) c;
		// byte(��) <- int(ū): ��������ȯ
		
		
		char e = (char) c;
		char f = (char) a; 
		
		
	}

}
