package network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceiver {

	// socket���α׷�(�������α׷�)
	public static void main(String[] args) throws Exception {
		DatagramSocket socket = new DatagramSocket(7100);
		System.out.println("�޴� �� ���� ����..");
		System.out.println("���� �غ� ��");
		
		// �� ��Ŷ �ʿ�
		byte[] data = new byte[256];
		DatagramPacket packet = new DatagramPacket(data, data.length);
		socket.receive(packet);
		System.out.println("���� ������: " + new String(data));
		socket.close();
	}

}
