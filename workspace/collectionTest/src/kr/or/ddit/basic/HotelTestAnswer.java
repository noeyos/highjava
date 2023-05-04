package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class HotelTestAnswer {
	private HashMap<Integer, RoomAnswer> hotelMap;
	private Scanner scan;
		
	// 생성자
	public HotelTestAnswer() {
		hotelMap = new HashMap<>();
		scan = new Scanner(System.in);
			
		// 객실 초기화
		for(int i=2; i<=4; i++) {
			String type = null;
			switch(i) {
			case 2: type = "싱글룸"; break;
			case 3: type = "더블룸"; break;
			case 4: type = "스위트룸"; break;
			}
				
			for(int j=1; j<=9; j++) {
				int num = i * 100 + j;
				hotelMap.put(num, new RoomAnswer(num, type));
			}
		} // 객체 초기화 중...
	}
	
	public static void main(String[] args) {
		new HotelTestAnswer().hotelStart();
	}
		
	public void hotelStart() {
		System.out.println("*******************************************");
		System.out.println("    호텔문을 열었습니다. 어서오십시요.");
		System.out.println("*******************************************");
		System.out.println();
			
		while(true) {
			int choice = displayMenu();
			switch(choice) {
			case 1 : // 체크인
				checkIn();
				break;
			case 2 : // 체크아웃
				checkOut();
				break;
			case 3 : // 객실상태
				viewRoom();
				break;
			case 4 : // 업무종료
				System.out.println();
				System.out.println("*****************************************");
				System.out.println("            호텔문을 닫았습니다.");
				System.out.println("*****************************************");
				System.out.println();
				break;
			}
		}		
	}
	
	// 객실 상태를 출력하는 메서드
	public void viewRoom() {
		// 방번호를 순서대로 나오게 하기 위해서 방번호(Map의 key값)만 List에 넣은 후 정렬해서 사용한다.
		ArrayList<Integer> roomNumList = new ArrayList<>(hotelMap.keySet());
		
		// 방번호를 기준으로 오름차순 정렬하기
		Collections.sort(roomNumList);
		
		System.out.println();
		System.out.println("-------------------------------------------");
		System.out.println("               현재 객실 상태");
		System.out.println("-------------------------------------------");
		System.out.println("방번호          방종류          투숙색이름");
		System.out.println("-------------------------------------------");
		
		// List에서 방번호를 하나씩 꺼내와 Map에서 해당 방번호에 대한 Room객체를 구해서 출력한다.
		for(int num : roomNumList) {
			RoomAnswer r = hotelMap.get(num);
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
	
	// 체크아웃 메서드
	public void checkOut() {
		System.out.println("-------------------------------------------");
		System.out.println("   체크아웃 작업");
		System.out.println("-------------------------------------------");
		System.out.println("체크아웃 할 방 번호를 입력하세요.");
		System.out.print("방 번호 입력 >> ");
		int num = scan.nextInt();
		
		if(!hotelMap.containsKey(num)) {
			System.out.println(num + "호 객실은 존재하지 않습니다...");
		} else if(hotelMap.get(num).getGuestName()==null) {		// 손님이 없는 방일 때...
			System.out.println(num + "호 객실에는 체크인한 손님이 없습니다...");
		} else {
			// 체크아웃 작성 진행 ==> 해당 객실의 투숙객 이름을 null로 변경하면 된다.
			
			// 현재 객실의 손님 이름 구하기
			String name = hotelMap.get(num).getGuestName();
			
			// 투숙객 이름을 null로 변경하기
			hotelMap.get(num).setGuestName(null);
			System.out.println(num + "호 객실의 " + name + "님이 체크아웃을 완료했습니다...");
		}
	}
	
	// 체크인 메서드
	public void checkIn() {
		System.out.println("-------------------------------------------");
		System.out.println("   체크인 작업");
		System.out.println("-------------------------------------------");
		System.out.println(" * 201~209 : 싱글룸");
		System.out.println(" * 301~309 : 더블룸");
		System.out.println(" * 401~409 : 스위트룸");
		System.out.println("-------------------------------------------");
		System.out.print("방 번호 입력 >> ");
		int num = scan.nextInt();
		
		// 입력한 방번호가 있는지 검사하기
		if(!hotelMap.containsKey(num)) {
			System.out.println(num + "호 객실은 존재하지 않습니다...");
			return;
		} 
		
		// 입력한 방법호의 객실에 손님이 이미 있는지 검사
		if(hotelMap.get(num).getGuestName() != null) {
			System.out.println(num + "호 객실에는 이미 손님이 있습니다...");
			return;
		}
		
		System.out.println();
		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.print("이름 입력 >> ");
		String name = scan.next();
		
		// 입력 받은 투수객 이름을 해당 객실의 투숙객 명단에 저장
		hotelMap.get(num).setGuestName(name);
		System.out.println(name + "씨가 " + num + "호 객실에 체크인 되었습니다...");
		
	}

	// 메뉴 메서드
	public int displayMenu() {
		System.out.println();
		System.out.println("-----------------------------------------------------");
		System.out.println(" 어떤 업무를 하시겠습니까?");
		System.out.println(" 1. 체크인   2. 체크아웃   3. 객실상태   4. 업무종료");
		System.out.println("-----------------------------------------------------");
		System.out.print("선택>> ");
		return scan.nextInt();
		
	}	
}
	
class RoomAnswer {
	private int roomNum;
	private String roomType;
	private String guestName;
	
	public RoomAnswer(int roomNum, String roomType) {
		super();
		this.roomNum = roomNum;
		this.roomType = roomType;
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
	
	@Override
	public String toString() {
		return "Room [roomNum=" + roomNum + ", roomType=" + roomType + ", guestName=" + guestName + "]";
	}
	
}