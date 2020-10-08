package network;

import java.net.InetAddress;

// domain name: www.naver.com ---DNS(Domain,裹困 Name System)辑滚--℃ ip林家

public class DomainToIp {

	public static void main(String[] args) throws Exception {
		String domain = "www.naver.com";
		InetAddress ip = InetAddress.getByName(domain);
		System.out.println("ip林家: " + ip.getHostAddress());
	}

}
