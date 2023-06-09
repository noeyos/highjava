package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*

	'e:/e_other' 폴더에 있는 '펭귄.jpg'파일을
	'e:/e_other/연습용' 폴더에 '펭귄_복사본.jpg'파일로 복사하는 프로그램


*/

public class FileCopy {

	public static void main(String[] args) {
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		try {
			fis = new FileInputStream("e:/e_other/펭귄.jpg");
			bis = new BufferedInputStream(fis);
			fos = new FileOutputStream("e:/e_other/연습용/펭귄_복사본.jpg");
			bos = new BufferedOutputStream(fos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int i=0;
		
		try {
			while((i=bis.read())!= -1) {
				bos.write(i);
			}
			System.out.println("복사 완료!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("복사 실패!");
			e.printStackTrace();
		}

		
		try {
			fis.close();
			bis.close();
			fos.close();
			bos.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
