package kr.or.ddit.basic;

/*
	wait(), notify() 메서드를 이용해서
	두 스레드가 번갈아 한번씩 실행되는 예제
*/


public class ThreadTest18 {

	public static void main(String[] args) {
		WorkObject workObj = new WorkObject();
		
		ThreadA thA = new ThreadA(workObj);
		ThreadB thB = new ThreadB(workObj);
		
		thA.start();
		thB.start();
		
	}
	
}



// 공통으로 사용할 객체
class WorkObject {
	public synchronized void methodA() {
		System.out.println("methodA() 메서드 실행 중");

		// notify()는 그냥 사용해도 되는데, wait()는 try/catch로 사용해야 됨
		notify();
		
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
	}
	
	public synchronized void methodB() {
		System.out.println("methodB() 메서드에서 처리하는 중");
		
		// notify()는 그냥 사용해도 되는데, wait()는 try/catch로 사용해야 됨
		notify();
		
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
	}
}


// WorkObject의 methodA() 메서드만 호출하는 스레드
class ThreadA extends Thread {
	private WorkObject workObj;
	
	public ThreadA(WorkObject workObj) {
		this.workObj = workObj;
	}
	
	@Override
	public void run() {	
		for(int i=0; i<=10; i++) {	// methodA 10번 호출
			workObj.methodA();
		}

		synchronized (workObj) {
			workObj.notify();              
		}

	}
	
}

// WorkObject의 methodB() 메서드만 호출하는 스레드
class ThreadB extends Thread {
	private WorkObject workObj;
	
	public ThreadB(WorkObject workObj) {
		this.workObj = workObj;
	}
	
	@Override
	public void run() {	
		for(int i=0; i<=10; i++) {	// methodB 10번 호출
			workObj.methodB();
		}
		
		synchronized (workObj) {
			workObj.notify();              
		}
		
	}
}