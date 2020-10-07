package network;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	
	public static void main(String[] args) throws Exception {
		// 1. ���� ��û�� ����ϴ� ������ socket�ʿ�
		// prototype(������Ÿ��) ��� <-> singleton(�̱���)
		// �ʿ��Ҷ����� ��ü ���� <-> �ϳ��� ��ü ���� �ּҸ� ����
		ServerSocket server = new ServerSocket(9100); // ��Ʈ��ȣ�� 9100�� ������ ����
		System.out.println("TCP ���� ���۵�"); // �������۵Ǿ��ٴ� ���� ���
		System.out.println("Ŭ���̾�Ʈ�� ��û�� ��ٸ��� ��");
		int i = 0; // socket����
		while (true) {
			i++; // socket������ ������Ŵ
			Socket socket = server.accept(); // �������� ���� socket
			System.out.println(i + "��° �������� ���� ����"); // ���� socket�� ���°���� ���
			
			// true��� �ۼ��ؾ߸� ���� �����Ͱ� ��� ���۵�
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true); // socket�� �����͸� �Ѱ��ֱ����� printwriter
			out.println("i am a java programmer!"); // �Ѱ��� ������
		}
		
	}
	
}
