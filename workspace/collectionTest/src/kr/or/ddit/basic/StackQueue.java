package kr.or.ddit.basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueue {
	
	/*
	stack (후입선출 LIFO)
	입구와 출구가 같음
	한 칸에 하나씩만 저장됨
	데이터가 들어가고 나오는 순서:
	맨 먼저 들어간 데이터가 바닥에 깔리고
	나중에 들어온 애가 맨 위에 있고, 꺼낼 때도 맨 위에 있으므로 가장 먼저 꺼내짐
	먼저 들어간 데이터가 가장 나중에 나옴
	
	Queue (선입선출 FIFO)
	
	Stack과 Queue는 LinkedList를 이용하여 사용할 수 있다
	
	*/
	
	/*
	 Stack의 명령
	 1. 자료 입력: push(입력값)
	 2. 자료 출력: pop() ==> 자료를 꺼내온 후 꺼내온 자료를 stack에서 삭제한다.
	 			   peek() ==> 임시로 자료를 꺼내와서 비교. 삭제없이 자료를 꺼내옴.
	 */
	
	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		
		stack.push("홍길동");
		stack.push("일지매");
		stack.push("변학도");
		stack.push("강감찬");
		// push한 순서대로 값이 들어감
		// stack의 데이터 입구와 출구는 뒤쪽에 있음
		System.out.println("현재 Stack값 : " + stack);
		
		String data = stack.pop();
		System.out.println("꺼내온 값 : " + data);
		System.out.println("꺼내온 값 : " + stack.pop());
		
		System.out.println("현재 Stack 값 : " + stack);
		
		stack.push("성춘향");
		System.out.println("추가 후 Stack값 : " + stack);
		
		System.out.println("꺼내온 값 : " + stack.pop());
		System.out.println("현재 Stack값 : " + stack);
		
		System.out.println();
		System.out.println("삭제없이 꺼내온 값 : " + stack.peek());
		System.out.println("현재 Stack값 : " + stack);
		System.out.println("---------------------------------------------");
		System.out.println();
		
		/*
		  
		 Queue의 명령
		 1. 자료 입력 : offer(입력값)
		 2. 자료 출력 : poll() ==> 자료를 꺼내오고 꺼내온 자료를 Queue에서 삭제한다.
		 				peek() ==> 삭제없이 자료를 꺼내온다.
		 
		 */
		
		Queue<String> queue = new LinkedList<>();
		
		queue.offer("홍길동");
		queue.offer("일지매");
		queue.offer("변학도");
		queue.offer("강감찬");
		
		System.out.println("현재 Queue값 : " + queue);
		// 앞이 출구, 뒤가 입구
		
		String temp = queue.poll();
		System.out.println("꺼내온 값 : " + temp);
		System.out.println("꺼내온 값 : " + queue.poll());
		System.out.println("현재 Queue값 : " + queue);
		
		queue.offer("성춘향");
		System.out.println("현재 Queue값 : " + queue);
		
		System.out.println("꺼내온 값 : " + queue.poll());
		System.out.println("현재 Queue값 : " + queue);

//		test();
		// 메소드를 호출하고 실행이 끝나면 제자리로 돌아갈 수 있게 해주는 게 CallStack
		
		System.out.println("삭제없이 꺼내오기 : " + queue.peek());
		System.out.println("현재 Queue값 : " + queue);
		
	
	}
	
//	static void test() {
//		System.out.println("이것은 test 메서드입니다.");
//	}
	
}
