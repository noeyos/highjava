package kr.or.ddit.basic;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Lotto {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		while(true) {
			System.out.println("\n==========================\n"
					+ "      Lotto 프로그램\n"
					+ "--------------------------\n"
					+ " 1. Lotto 구입\n"
					+ " 2. 프로그램 종료\n"
					+ "==========================	");
			System.out.print("메뉴선택: ");
			int select = Integer.parseInt(scanner.nextLine());
			System.out.println();
			switch(select) {
			case 1:
				System.out.println("Lotto 구입 시작\n");
				System.out.println("(1000원에 로또번호 하나입니다.)");
				System.out.print("금액 입력: ");
				int price = Integer.parseInt(scanner.nextLine());
				System.out.println();
				if (price < 1000) {
					System.out.println("입력 금액이 너무 적습니다. 로또번호 구입 실패!!!");
				} else if (price >= 101000) {
					System.out.println("입력 금액이 너무 많습니다. 로또번호 구입 실패!!!");
				} else {
					System.out.println("행운의 로또번호는 아래와 같습니다.");	
					for(int i=1; i <= (price / 1000); i++) {
						HashSet<Integer> lotto = new HashSet<>();
						while(lotto.size() < 6) {
							lotto.add(random.nextInt(45) + 1);
						}		
						System.out.println("로또번호" + i + ": " + lotto);
					}
					
					if (price % 1000 == 0) {
						System.out.println("\n받은 금액은 " + price + "원입니다.");
					} else {
						System.out.println("\n받은 금액은 " + price + "원이고 거스름돈은 " + price % 1000 + "원입니다.");
					}
				}
				break;
			case 2:
				System.out.println("감사합니다");
				return;
			default:
				System.out.println("번호를 잘못 선택했습니다. 다시 선택하세요.");
			}
			
		}
		
	}

}
