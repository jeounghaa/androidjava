package network;

import java.net.InetAddress;

// domain name: www.naver.com ---DNS(Domain,���� Name System)����--�� ip�ּ�

public class DomainToIp {

	public static void main(String[] args) throws Exception {
		String domain = "www.naver.com";
		InetAddress ip = InetAddress.getByName(domain);
		System.out.println("ip�ּ�: " + ip.getHostAddress());
	}

}
