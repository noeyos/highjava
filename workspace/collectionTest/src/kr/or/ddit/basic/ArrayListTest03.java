package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
 *	문제) 5명의 별명을 입력 받아 ArrayList에 저장하고
 *		  저장된 별명들 중에 별명의 길이가 제일 긴 별명을 출력하시오.
 *		  (단, 각 별명의 길이는 모두 다르게 입력한다.)
 */

public class ArrayListTest03 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<>();
		
		for(int i=1; i<6; i++) {
			System.out.print("사람" + i + "의 별명: ");
			String nickname = scanner.nextLine();
			list.add(nickname);
		}
		
		// 제일 긴 별명이 저장될 변수를 선언하고 List의 첫번째 데이터로 초기화한다.
		String longest = list.get(0);
		for(int i=1; i<list.size(); i++) {
			if (list.get(i).length() > longest.length()) {				
				longest = list.get(i);	
			}
		}
		System.out.println("제일 긴 별명은 '" + longest + "'입니다.");
	}

}
