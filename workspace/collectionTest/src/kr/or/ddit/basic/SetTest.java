package kr.or.ddit.basic;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class SetTest {
	
	public static void main(String[] args) {
	/*
	
	- List와 Set의 차이점
	1. List
	  - 데이터의 순서(index)가 있다.
	  - 중복되는 데이터를 저장할 수 있다.
	  - 순서대로 데이터를 넣었다 뺐다,
	
	2. Set
	  - 데이터의 순서(index)가 없다.
	  - 중복되는 데이터를 저장할 수 없다.
	  - 데이터가 순서없이 섞여 있음.
	  - 주머니(자루)에 데이터를 넣는다고 생각하면 됨.
	   
	 */
		
		HashSet hs1 = new HashSet();
		
		// Set에 데이터를 추가할 때도 add() 메서드를 사용한다.
		hs1.add("DD");
		hs1.add("AA");
		hs1.add(2);
		hs1.add("CC");
		hs1.add("BB");
		hs1.add(1);
		hs1.add(3);
		
		System.out.println("Set의 개수 : " + hs1.size());
		System.out.println("set 데이터 => " + hs1); // 내가 데이터를 집어넣는 순서와 다르게 마구잡이로 출력됨.
		
		// Set에 중복되는 데이터를 추가하면 false를 반환하고 데이터는 추가되지 않는다.
		boolean isAdd = hs1.add("FF");
		System.out.println("중복되지 않을 때 : " + isAdd);
		System.out.println("set 데이터 => " + hs1); // 추가됨
		
		isAdd = hs1.add("CC");
		System.out.println("중복될 때 : " + isAdd);
		System.out.println("set 데이터 => " + hs1); // 추가안됨
		
		// Set의 데이터를 수정하려면 수정하는 명령이 따로 없기 때문에 해당 자료를 삭제한 후 추가 해 주는 방법을 이용한다.
		
		// 삭제하는 메서드 : remove(삭제할 자료) ==> 반환값 : 삭제성공(true), 삭제실패(false)
		// 전체 데이터 삭제 : clear()
		
		// "FF" 데이터를 "EE"로 변경하기
		hs1.remove("FF");
		System.out.println("삭제후 set => " + hs1);
		hs1.add("EE");
		System.out.println("set 데이터 => " + hs1);
		System.out.println();
		
//		hs1.clear();
//		System.out.println("clear후 set 데이터 => " + hs1);
		
		/*
		 Set의 데이터 순서(index)가 없기 때문에 List처럼 인덱스로 데이터를 하니씩 불러올 수 없다.
		 그래서 데이터를 하나씩 얻기 위해서는 Iterator형 객체를 변환해야 한다.
		 
		 - Set형의 데이터들을 Iterator형의 객체로 변환하는 메서드 ==> iterator()
		 
		 */
		
		Iterator it = hs1.iterator();	// Set데이터를 Iterator로 변환하기
		
		// Iterator객체의 hasNext() 메서드
		// ==> Iterator의 데이터를 가리키는 포인터가 현재 가리키는 위치의 다음 번째에 데이터가 있는지 검사한다.
		// ==> 그래서 데이터가 있으면 true, 없으면 false를 반환한다.
		
		while(it.hasNext()) { // 다음 번째 데이터가 있으면 반복하라.
			// Iterator객체의 next()메서드
			// ==> Iterator의 데이터를 가리키는 포인터가 현재 가리키고 있는 곳의
			// 	   다음번째로 포인터를 이동한 후 그 곳의 데이터를 꺼내와 반환한다. 
			System.out.println(it.next());
		}
		
		System.out.println("------------------------------------------------------------------");

		// 우리반 학생들 중 번호를 이용하여 추첨하는 프로그램을 작성해 보자.
		// 번호는 1번부터 26번까지 있고 추첨할 인원은 3명이다.
		// 당첨자를 출력해 보시오.
		
		// 난수 만들기 (23~55 사이의 난수 만들기)
		// random.nextInt((최대값-최솟값+1)+최솟값;
		Random random = new Random();
//		for(int i=1; i<20; i++) {
//			int r = random.nextInt((55-23+1)) + 23;
//			System.out.println(r);
//		}
		
		// <> 안에는 제네릭(Integer 같은 형식)
		HashSet<Integer> testSet = new HashSet<>();
		while(testSet.size() < 3) {		// Set의 크기가 원하는 개수가 될 때까지 반복
			testSet.add(random.nextInt(26) + 1);	// 난수를 만들어서 Set에 추가한다.
		}
		System.out.println("당첨자 번호 : " + testSet);
	}

}
