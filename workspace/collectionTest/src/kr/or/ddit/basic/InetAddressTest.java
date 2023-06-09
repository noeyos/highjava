package kr.or.ddit.basic;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
	public static void main(String[] args) throws UnknownHostException {
		// InetAddress클래스: IP주소를 다루기 위한 클래스

		// www.naver.com의 IP정보 가져오기
		InetAddress ip = InetAddress.getByName("www.naver.com");
		System.out.println("Host Name: " + ip.getHostName());
		System.out.println("Host Addressl: " + ip.getHostAddress());
		System.out.println("toString(): " + ip.toString());
	}

}
