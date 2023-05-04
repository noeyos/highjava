package kr.or.ddit.basic;


import java.util.ArrayList;
import java.util.Scanner;

/*
 * 	문제) 5명의 사람 이름을 입력 받아 ArrayList에 저장한 후에
 * 		  이 ArrayList에 저장된 이름들 중에서 '김'씨 성의 이름을 모두 출력하시오.
 * 		  (입력은 Scanner객체를 이용한다.)
 * 
 */

public class ArrayListTest02 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<>();
		
		for(int i = 1; i < 6; i++) {
			System.out.print("사람" + i + ": ");
			String name = scanner.nextLine();
			list.add(name);
		}
		
		System.out.print("김씨 성을 가진 사람: ");
		for(int i = 0; i < list.size(); i++) {
			
			// 방법 1
			if(list.get(i).substring(0, 1).equals("김")) {
				System.out.println(list.get(i));
			}
			
			// 방법 2
			if(list.get(i).indexOf("김")==0) {
				System.out.println(list.get(i));
			}
			
			// 방법 3
			if(list.get(i).charAt(0)=='김') {
				System.out.println(list.get(i));
			}
			
			// 방법 4
			if(list.get(i).startsWith("김")) {
				System.out.println(list.get(i));
			}
		}
	}
}
