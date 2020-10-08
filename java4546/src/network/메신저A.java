package network;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class 메신저A extends JFrame {
	JTextField input;
	JTextArea list;
	InetAddress ip, ip2;

	public 메신저A() {
		setSize(300, 500);
		setTitle("메신저A");
		getContentPane().setLayout(null);

		list = new JTextArea();
		list.setFont(new Font("Monospaced", Font.BOLD, 20));
		list.setBackground(new Color(216, 191, 216));
		list.setBounds(0, 0, 284, 412);
		getContentPane().add(list);
		list.setEditable(false);

		input = new JTextField();
		input.setFont(new Font("굴림", Font.BOLD, 22));
		input.setBackground(new Color(255, 240, 245));
		input.setBounds(0, 411, 284, 50);
		getContentPane().add(input);
		input.setColumns(10);

		input.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String data = input.getText();
				// 입력한 값 가져와서 list up
				list.append("jh>> " + data + "\n");
				input.setText("");
				try {
					// 상대방에게 네트워크 전송
					DatagramSocket socket = new DatagramSocket();
					byte[] data2 = data.getBytes();
					ip = InetAddress.getByName("192.168.1.80");
					DatagramPacket packet = new DatagramPacket(data2, data2.length, ip, 5000);
					ip2 = InetAddress.getByName("192.168.1.173");
					DatagramPacket packet2 = new DatagramPacket(data2, data2.length, ip2, 5000);
					socket.send(packet);
					socket.send(packet2);
					socket.close();
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("데이터 보내는 중 에러");
				}
			}
		});
		setVisible(true);
	}
	
	public void process() {
		while (true) {
			try {
				DatagramSocket socket = new DatagramSocket(5000);
				// 빈 패킷 필요
				ip = InetAddress.getByName("192.168.1.80");
				ip2 = InetAddress.getByName("192.168.1.173");
				byte[] data = new byte[256];
				DatagramPacket packet = new DatagramPacket(data, data.length, ip, 5000);
				socket.receive(packet);
				System.out.println("받은 데이터: " + new String(data));
				list.append("너>> " + new String(data) + "\n");
				socket.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("데이터 받는 도중 에러");
			} 
		}
		
	}

	public static void main(String[] args) {
		메신저A m = new 메신저A();
		m.process();
	}
}
