package kr.or.ddit.basic;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/*

	추가 조건

1) '6. 전화번호 저장' 메뉴를 추가하고 구현한다.
	(저장파일명은 'phoneData.dat'로 한다.)
	
2) 이 프로그램이 시작될 때 저장된 파일이 있으면 그 파일의 데이터를 읽어와 Map에 셋팅한다.

3) 이 프로그램이 종료될 때 Map의 데이터가 변경(추가, 수정, 삭제) 되었으면 저장 후 종료되도록 한다.


*/

public class PhoneBookTest {
	static Scanner scanner = new Scanner(System.in);
	static HashMap<String, Phone> phoneMap = new HashMap<>();
	static Phone phone = new Phone();
	String fileName;

	public static void main(String[] args) {

		while (true) {
			menu();
			int select = Integer.parseInt(scanner.nextLine());
			System.out.println();
			switch (select) {
			case 1:
				create();
				break;
			case 2:
				update();
				break;
			case 3:
				delete();
				break;
			case 4:
				search();
				break;
			case 5:
				printAll();
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못된 입력입니다. 다시 입력하세요.\n");

			}
		}
	}
	

	public static void menu() {
		System.out.println("	메  뉴\n"
				+ "1. 전화번호 등록\n"
				+ "2. 전화번호 수정\n"
				+ "3. 전화번호 삭제\n"
				+ "4. 전화번호 검색\n"
				+ "5. 전화번호 전체 출력\n"
				+ "0. 프로그램 종료\n"
				+ "---------------------");
		System.out.print("번호 입력 >> ");
	}

	public static void create() {
		while (true) {
			System.out.println("새롭게 등록할 전화번호 정보를 입력하세요.");
			System.out.print("이름 >> ");
			String name = scanner.nextLine();
			if (phoneMap.get(name) != null) {
				System.out.println("'" + name + "'은 이미 등록된 사람입니다.\n");
				break;
			}
			System.out.print("전화번호 >> ");
			String tel = scanner.nextLine();
			System.out.print("주소 >> ");
			String add = scanner.nextLine();
			phoneMap.put(name, new Phone(name, tel, add));
			System.out.println();
			System.out.println("'" + name + "' 전화번호 등록 완료!!\n");
			return;
		}
	}

	public static void printAll() {
		System.out.println("-------------------------------------------------");
		System.out.println("번호     이름      전화번호           주소");
		System.out.println("-------------------------------------------------");
		Set<String> keySet = phoneMap.keySet();
		Iterator<String> it = keySet.iterator();
		if (it.hasNext() == true) {
			while (it.hasNext()) {
				for (int i = 0; i < phoneMap.size(); i++) {
					String name = it.next();
					Phone phone = phoneMap.get(name);
					System.out.printf("%d\t%s\t%s\t%s\n", (i + 1), phone.getName(), phone.getTel(), phone.getAdd());
				}
			}
		} else {
			System.out.println("등록된 정보가 없습니다.\n");
		}
	}

	public static void update() {
		if (phoneMap.size() != 0) {
			System.out.print("수정할 연락처의 이름을 입력하세요: ");
			String name = scanner.nextLine();
			if (phoneMap.containsKey(name) == true) {
				System.out.print("수정할 전화번호를 입력하세요: ");
				String tel = scanner.nextLine();
				phone = phoneMap.get(name);
				phone.setTel(tel);
				System.out.println("\n수정이 완료되었습니다.\n");
			} else {
				System.out.println("해당 이름의 연락처가 존재하지 않습니다.\n");
				update();
			}
		} else {
			System.out.println("연락처에 저장된 데이터가 없습니다.\n");
		}
	}

	public static void delete() {
		if (phoneMap.size() != 0) {
			System.out.print("삭제할 연락처의 이름을 입력하세요: ");
			String name = scanner.nextLine();
			if (phoneMap.containsKey(name) == true) {
				phoneMap.remove(name);
				System.out.println("\n삭제가 완료되었습니다.\n");
			} else {
				System.out.println("해당 이름의 연락처가 존재하지 않습니다.\n");
				delete();
			}
		} else {
			System.out.println("연락처에 저장된 데이터가 없습니다.\n");
		}
	}

	public static void search() {
		if (phoneMap.size() != 0) {
			System.out.print("검색할 연락처의 이름을 입력하세요: ");
			String name = scanner.nextLine();
			if (phoneMap.containsKey(name) == true) {
				Phone phone = phoneMap.get(name);
				System.out.printf("\n[%s] %s, %s\n\n", phone.getName(), phone.getTel(), phone.getAdd());
			} else {
				System.out.println("해당 이름의 연락처가 존재하지 않습니다.\n");
				search();
			}
		} else {
			System.out.println("연락처에 저장된 데이터가 없습니다.\n");
		}
	}
}
