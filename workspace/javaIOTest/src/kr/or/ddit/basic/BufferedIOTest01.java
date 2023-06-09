package kr.or.ddit.basic;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedIOTest01 {

	public static void main(String[] args) {
		// 입출력의 성능 향상을 위해서 buffered 스트림을 사용한다
		
		// 출력용 buffered스트림 사용 예제
		try {
			// 기반이 되는 스트림 생성 ==> 파일 출력용
			FileOutputStream fout = new FileOutputStream("e:/e_other/bufferTest.txt");
			
			// 버퍼 크기가 5인 buffered스트림 객체 생성
			BufferedOutputStream bout = new BufferedOutputStream(fout, 5);
			
			for(int i='1'; i<='9'; i++) {
				bout.write(i);
			}
			
			System.out.println("작업 끝...");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
