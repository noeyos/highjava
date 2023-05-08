package kr.or.ddit.basic.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;

/*

클라이언트는 서버와 접속이 완료되면 'e:/e_other/' 폴더에 있는
'펭귄.jpg'파일을 서버로 전송한다.
(파일을 읽어서 소켓으로 출력하기)

*/

public class TcpFileClient {

	public static void main(String[] args) {
		File file = new File("e:/e_other/펭귄.jpg");
		
		if(!file.exists()) {
			System.out.println(file.getPath() + "파일이 없습니다...");
			return;
		}
		
		String fileName = file.getName();	// 파일명 구하기
		
		try {
			Socket socket = new Socket("localhost", 7777);
			System.out.println("파일 전송 시작...");
			
			
			// 처음에는 파일명을 문자열로 전송한다
			DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
			dout.writeUTF(fileName);
			
			
			// 파일 내용 읽어서 소켓으로 전송한다
			BufferedInputStream bin = new BufferedInputStream(new FileInputStream(file));
			
			
			// 소켓 출력용 스트림 객체 생성
			BufferedOutputStream bout = new BufferedOutputStream(dout);
			
			byte[] temp = new byte[1024];
			int length = 0;
			
			
			// 파일 읽어서 소켓 전송하기
			while((length=bin.read(temp))>0) {
				bout.write(temp, 0, length);
			}
			bout.flush();
			System.out.println("파일 전송 완료...");
			
			
			// 스트림과 소켓 닫기
			bout.close();
			bin.close();
			socket.close();
			
			
		} catch (Exception e) {
			System.out.println("파일 전송 실패! --> " + e.getMessage());
		} 
		
		
		
	}

}
