package kr.or.ddit.basic;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressClass {

	public static void main(String[] args) throws UnknownHostException {
		// IP 주소가 여러개인 호스트의 IP 정보 가져오기 
		InetAddress[] ipArr = InetAddress.getAllByName("www.naver.com");
		for (InetAddress nip : ipArr) {
			System.out.println(nip.toString());
		}

	}

}
