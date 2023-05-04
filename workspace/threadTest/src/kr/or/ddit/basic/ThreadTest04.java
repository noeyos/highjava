package kr.or.ddit.basic;

/*
	1 ~ 20억까지의 합계를 구하는 프로그램을 하나의 쓰레드가 단독으로 처리할 때와
	여러개의 쓰레드가 협력해서 처리할 때의 경과 시간을 비교해 보자.
*/

public class ThreadTest04 {

	public static void main(String[] args) {
		// 단독으로 처리하는 쓰레드 생성
		SumThread sm = new SumThread(1L, 2000000000L);
		
		// 여럿이 협력해서 처리하는 쓰레드 생성
		SumThread[] sumArr = new SumThread[] {
			new SumThread(		   1L, 500000000L),
			new SumThread( 500000001L,1000000000L),
			new SumThread(1000000001L,1500000000L),
			new SumThread(1500000001L,2000000000L)
		};
		
		
		
		// 단독으로 처리하기
		long startTime = System.currentTimeMillis();
		sm.start();
		
		try {
			sm.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
		
		long endTime = System.currentTimeMillis();

		System.out.println("단독 처리 경과시간 : " + (endTime - startTime));
		System.out.println();
		

		
		// 여럿이 협력해서 처리하기
		
		startTime = System.currentTimeMillis();
		
		for(SumThread th : sumArr) {	// 여러개의 쓰레드 실행
			th.start();
		}
		
		for(SumThread th : sumArr) {	// 모든 쓰레드의 실행이 끝날 때까지 기다린다
			try {
				th.join();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
		endTime = System.currentTimeMillis();
	
		System.out.println("협력 처리 경과시간 : " + (endTime - startTime));
		System.out.println();
	}


}

// 시작값과 끝값을 주면 시작값부터 끝값까지의 합계를 구하는 쓰레드 클래스 만들기
class SumThread extends Thread {
	private long start;		// 시작값이 저장될 변수
	private long end;		// 끝값이 저장될 변수
	
	// 생성자
	public SumThread(long start, long end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	public void run() {
		long sum = 0L;
		for(long i=start; i<=end; i++) {
			sum += i;
		}
		
		System.out.println(start + "부터 " + end + "까지의 합계 : " + sum);
	}
}