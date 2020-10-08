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

public class 메신저B extends JFrame {
	JTextField input;
	JTextArea list;

	public 메신저B() {
		setSize(300, 500);
		setTitle("�޽���B");
		getContentPane().setLayout(null);

		list = new JTextArea();
		list.setFont(new Font("Monospaced", Font.BOLD, 20));
		list.setBackground(new Color(176, 224, 230));
		list.setBounds(0, 0, 284, 412);
		getContentPane().add(list);
		list.setEditable(false);

		input = new JTextField();
		input.setFont(new Font("����", Font.BOLD, 22));
		input.setBackground(new Color(95, 158, 160));
		input.setBounds(0, 411, 284, 50);
		getContentPane().add(input);
		input.setColumns(10);

		input.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String data = input.getText();
				//입력한 값 가지고 와서, list up!
				list.append("나>> " + data + "\n");
				input.setText("");
				try {
					//상대방에게 네트워크 전송! 
					DatagramSocket socket = new DatagramSocket();
					String str = "i am a android programmer!";
					byte[] data2 = data.getBytes();
					InetAddress ip = InetAddress.getByName("127.0.0.1");
					DatagramPacket packet = new DatagramPacket(data2, data2.length, ip, 5000);
					socket.send(packet);
					socket.close();
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("보내는 도중 에러");
				}
			}
		});
		setVisible(true);
	}
	
	public void process() {
		while (true) {
			try {
				DatagramSocket socket = new DatagramSocket(6000);
				// 빈 패킷 필요
				byte[] data = new byte[256];
				DatagramPacket packet = new DatagramPacket(data, data.length);
				socket.receive(packet);
				System.out.println("받은 데이터: " + new String(data));
				list.append("너>> " + new String(data) + "\n");
				socket.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("받는 도중 에러");
			} 
		}
		
	}

	public static void main(String[] args) {
		메신저B m = new 메신저B();
		m.process();
	}
}
