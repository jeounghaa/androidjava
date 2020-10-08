package network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceiver {

	// socket프로그램(소켓프로그램)
	public static void main(String[] args) throws Exception {
		DatagramSocket socket = new DatagramSocket(7100);
		System.out.println("연결중");
		
		// 빈 패킷 필요
		byte[] data = new byte[256];
		DatagramPacket packet = new DatagramPacket(data, data.length);
		socket.receive(packet);
		System.out.println("받은 데이터: " + new String(data));
		socket.close();
	}

}
