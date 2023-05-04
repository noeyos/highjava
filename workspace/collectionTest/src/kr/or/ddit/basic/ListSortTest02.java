package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListSortTest02 {
	
	public static void main(String[] args) {
		ArrayList<Member> memList = new ArrayList<>(); //멤버 클래스를 데이터로 받는 ArrayList를 만든다.
		
		memList.add(new Member(1,"홍길동","010-1111-1111"));
		memList.add(new Member(5,"이순신","010-2222-1111"));
		memList.add(new Member(9,"성춘향","010-3333-1111"));
		memList.add(new Member(3,"강감찬","010-4444-1111"));
		memList.add(new Member(6,"일지매","010-5555-1111"));
		memList.add(new Member(2,"변학도","010-6666-1111"));
		
		System.out.println("정렬전...");
		for(Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("==============================================");
		
		Collections.sort(memList); // sort안에 list를 그냥 주면 
		System.out.println("정렬후...");
		for(Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("==============================================");
		
		// 데이터 섞기
		Collections.shuffle(memList);
		
		System.out.println("섞인후...");
		for(Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("==============================================");
		
		// Member의 회원번호(num)값의 내림차순으로 정렬하는 외부 정렬 기준 클래스를 작성하여 정렬하시오.
		// ==> Comparator인터페이스를 구현한다 (클래스명: SortNumDesc)
		Collections.sort(memList, new SortNumDesc());
		
		System.out.println("회원번호 내림차순 정렬후...");
		for(Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("==============================================");
		
	}

}

class SortNumDesc implements Comparator<Member> {
	
	@Override
	public int compare(Member mem1, Member mem2) {
//		방법1:
//		if(mem1.getNum() > mem2.getNum()) {
//			return -1;
//		} else if (mem1.getNum() < mem2.getNum()) {
//			return 1;
//		} else {
//			return 0;
//		}
		
//		Wrapper클래스를 이용하는 방법 (방법2-1)
//		return new Integer(mem1.getNum()).compareTo(mem2.getNum()) * -1;
		
//		Wrapper클래스를 이용하는 방법 (방법2-2)
		return Integer.compare(mem1.getNum(), mem2.getNum()) * -1;
		
		
	}
}

// Member클래스의 회원이름을 기준으로 오름차순 정렬이 되도록 내부 정렬 기준 추가하기
class Member implements Comparable<Member> {
	private int num;
	private String name;
	private String tel;
	
	//생성자
	public Member(int num, String name, String tel) {
		super();
		this.num = num;
		this.name = name;
		this.tel = tel;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", tel=" + tel + "]";
	}

	// compareTo()메서드의 반환값의 의미
	// 반환 값이 양수면 두 값의 순서를 바꾼다, 음수면 바꾸지 않는다, 0이면 두개의 데이터가 똑같다는 뜻.
	@Override
	public int compareTo(Member mem) { // 나하고 다른 회원하고 비교한다
		if(this.getName().compareTo(mem.getName()) > 0) {
			return 1; 
		} else if (this.getName().compareTo(mem.getName()) < 0) {
			return -1;
		} else {
		return 0;
		}
		
		//compareTo 사용한 이유: 문자열 가지고 크기 비교가 안 됨. 이미 String 객체에 만들어져있는 비교 메소드를 사용하기 위해 compareTo를 사용한 것.
		
		// if문 대신에 이것도 가능
		// 방법1 : return this.getName().compareTo(member.getName());
		// 방법2 : public int compare(String str1, String str2) { return str1.compareTo(str2) * -1; }

	}
}