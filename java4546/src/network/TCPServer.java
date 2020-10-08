package network;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	
	public static void main(String[] args) throws Exception {
		// 1. 연결 요청만 담당하는 서버용 socket필요
		// prototype(프로토타입) 방법 <-> singleton(싱글톤)
		// 필요할때마다 객체 생성 <-> 하나만 객체 생성 주소를 재사용
		ServerSocket server = new ServerSocket(9100); // 포트번호가 9100인 서버를 생성
		System.out.println("TCP 서버 시작됨"); // 서버시작되었다는 것을 출력
		System.out.println("클라이언트의 요청을 기다리는 중");
		int i = 0; // socket개수
		while (true) {
			i++; // socket개수를 증가시킴
			Socket socket = server.accept(); // 서버에서 받은 socket
			System.out.println(i + "번째 서버와의 연결 성공"); // 받은 socket이 몇번째인지 출력
			
			// true라고 작성해야만 보낼 데이터가 적어도 전송됨
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true); // socket에 데이터를 넘겨주기위한 printwriter
			out.println("i am a java programmer!"); // 넘겨줄 데이터
		}
		
	}
	
}
