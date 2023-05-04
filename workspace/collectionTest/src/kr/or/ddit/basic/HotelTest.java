package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HotelTest {
	static Scanner scanner = new Scanner(System.in);
	static Map<Integer, Room> map = new HashMap<>();
	static Room room;
	
	static int roomNum;
	static String roomType;
	static String guestName;
	
	
	public HotelTest() {
		room = new Room(0, null, null);
	}
		
	
	public static void main(String[] args) {
		System.out.println("*******************************************");
		System.out.println("    호텔문을 열었습니다. 어서오십시요.");
		System.out.println("*******************************************\n\n");
		while(true) {
			main();
			int select = Integer.parseInt(scanner.nextLine());
			System.out.println();
			switch(select) {
			case 1:
				checkIn();
				break;
			case 2:
				checkOut();
				break;
			case 3:
				roomList();
				break;
			case 4:
				System.out.println("*****************************************");
				System.out.println("            호텔문을 닫았습니다.");
				System.out.println("*****************************************");
				return;
			}
			
		}
	}
	
	public static void main() {
		System.out.println("-----------------------------------------------------");
		System.out.println(" 어떤 업무를 하시겠습니까?");
		System.out.println(" 1. 체크인   2. 체크아웃   3. 객실상태   4. 업무종료");
		System.out.println("-----------------------------------------------------");
		System.out.print("선택>> ");
	}
	
	public static void checkIn() {
		System.out.println("-------------------------------------------");
		System.out.println("   체크인 작업");
		System.out.println("-------------------------------------------");
		System.out.println(" * 201~209 : 싱글룸");
		System.out.println(" * 301~309 : 더블룸");
		System.out.println(" * 401~409 : 스위트룸");
		System.out.println("-------------------------------------------");
		System.out.print("방 번호 입력 >> ");
		roomNum = Integer.parseInt(scanner.nextLine());
		Boolean correct = false;
		
		if(map.containsKey(roomNum)==true) {
			System.out.println(roomNum + "호 객실은 이미 손님이 있습니다.");
			System.out.println();
			return;
		}
		
		if(roomNum<201 || roomNum>409) {
			System.out.println(roomNum + "호 객실은 존재하지 않습니다.");
			System.out.println();
			return;
		}
		
		if(roomNum >= 201 || roomNum <= 209) {
			roomType = "싱글룸";
			correct = true;
		} else if(roomNum >= 301 || roomNum <= 309) {
			roomType = "더블룸";
			correct = true;
		} else if(roomNum >= 401 || roomNum <= 409) {
			roomType = "스위트룸";
			correct = true;
		}

		while(correct==true) {
			System.out.println("누구를 체크인 하시겠습니까?");
			System.out.print("이름 입력 >> ");
			guestName = scanner.nextLine();
			map.put(roomNum, new Room(roomNum, roomType, guestName));
			System.out.println("체크인이 완료되었습니다.");
			return;
		}
	}			
	
	
	public static void checkOut() {
		System.out.println("-------------------------------------------");
		System.out.println("   체크아웃 작업");
		System.out.println("-------------------------------------------");
		System.out.println("체크아웃");
		roomNum = Integer.parseInt(scanner.nextLine());
		if (!((roomNum >= 201 && roomNum <= 209) || (roomNum >= 301 && roomNum <= 309)
				|| (roomNum >= 401 && roomNum <= 409))) {
			System.out.println(roomNum + "호 객실은 존재하지 않습니다.");
		} else if (map.containsKey(roomNum)==false) {
			System.out.println(roomNum + "호 객실에는 체크인한 사람이 없습니다.");
		} else {
			map.remove(roomNum);
			System.out.println(roomNum + "호 객실의 " + map.get(roomNum).getGuestName() + "님 체크아웃을 완료하였습니다.");
		}
	}
	
	public static void roomList() {
		System.out.println("-------------------------------------------");
		System.out.println("               현재 객실 상태");
		System.out.println("-------------------------------------------");
		System.out.println("방번호          방종류          투숙색이름");
		System.out.println("-------------------------------------------");
		
		List<Integer> list = new ArrayList<>(map.keySet());
		
		Collections.sort(list);
	
		for(int num : list) {
			Room r = map.get(num);
			System.out.print(r.getRoomNum()+"\t\t"+r.getRoomType()+"\t\t");
			
			String name ="-";
			if(r.getGuestName()!=null) {	// 투숙객이 있으면...
				name = r.getGuestName();
			}
			
			System.out.println(name);
		}
		System.out.println("-------------------------------------------");
		System.out.println();

	}

}	

class Room {
	private int roomNum;
	private String roomType;
	private String guestName;
	
	public Room() {
	}
	
	public Room(int roomNum, String roomType, String guestName) {
		super();
		this.roomNum = roomNum;
		this.roomType = roomType;
		this.guestName = guestName;
	}

	public int getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	
}
