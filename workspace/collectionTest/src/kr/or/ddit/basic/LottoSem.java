package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class LottoSem {
		private Scanner scanner = new Scanner(System.in);

		public static void main(String[] args) {
			LottoSem lotto = new LottoSem();
			lotto.lottoStart();
		}

		// 시작 메서드
		public void lottoStart() {
			while (true) {
				int choice = displayMenu();

				switch (choice) {
				case 1: // 로또 구입
					buyLotto();
					break;

				case 2: // 프로그램 종료
					System.out.println("감사합니다.");
					return;

				default:
					System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
					break;
				}
			}
		}

		// 메뉴를 출력하고 용자가 선택한(입력한) 메뉴 번호를 반환하는 메서드
		private int displayMenu() {
			System.out.println();
			System.out.println("==========================");
			System.out.println("       Lotto 프로그램       ");
			System.out.println("--------------------------");
			System.out.println("1. Lotto 구입");
			System.out.println("2. 프로그램 종료");
			System.out.println("==========================");
			System.out.print("메뉴 선택: ");
			return scanner.nextInt();
		}

		// 로또 구입을 처리하는 메서드
		private void buyLotto() {
			System.out.println("로또 구입 시작");
			System.out.println("(1000원에 로또 하나입니다.)");
			System.out.print("금액 입력: ");
			int money = scanner.nextInt();

			if (money < 1000) {
				System.out.println("입력 금액이 너무 적습니다. 로또번호 구입 실패");
				return;
			}

			if (money >= 101000) {
				System.out.println("입력 금액이 너무 많습니다. 로또번호 구입 실패");
				return;
			}

			Set<Integer> lottoSet = new HashSet<>();
			Random random = new Random();
			int count = money / 1000;
			for (int i = 1; i <= count; i++) {
				while (lottoSet.size() < 6) {
					lottoSet.add(random.nextInt(45) + 1);
				}
				List<Integer> lottoList = new ArrayList<>(lottoSet);
				Collections.sort(lottoList);
				System.out.println("로또번호" + i + ": " + lottoList);
				lottoSet.clear();
			}
			System.out.println();
			System.out.println("받은 금액은 " + money + "원이고 거스름돈은 " + money % 1000 + "원입니다.");
	}
}


