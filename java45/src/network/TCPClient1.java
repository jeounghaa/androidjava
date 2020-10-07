package network;

import java.net.Socket;

public class TCPClient1 {

	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("localhost", 9100);
		System.out.println("client1 서버와 연결됨");
	}

}
