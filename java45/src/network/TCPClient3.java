package network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;


public class TCPClient3 {

	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 10000; i++) { // 10000까지 반복
			Socket socket = new Socket("localhost", 9100); // 포트번호가 9100인 localhost socket을생성 
			System.out.println("client" + i + " 서버와 연결됨"); // 몇번째 socket이 서버와 연결되었는지 출력
			
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 서버에서 받아온 데이터를 inputstreamreader로 읽어서 bufferedreader로 다시 읽어옴
			String data = input.readLine(); // 읽어온 데이터를 string타입으로 가져옴
			System.out.println("받은 데이터: " + data); // 데이터 출력
		}
	}

}
