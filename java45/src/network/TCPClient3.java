package network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;


public class TCPClient3 {

	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 10000; i++) { // 10000���� �ݺ�
			Socket socket = new Socket("localhost", 9100); // ��Ʈ��ȣ�� 9100�� localhost socket������ 
			System.out.println("client" + i + " ������ �����"); // ���° socket�� ������ ����Ǿ����� ���
			
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream())); // �������� �޾ƿ� �����͸� inputstreamreader�� �о bufferedreader�� �ٽ� �о��
			String data = input.readLine(); // �о�� �����͸� stringŸ������ ������
			System.out.println("���� ������: " + data); // ������ ���
		}
	}

}
