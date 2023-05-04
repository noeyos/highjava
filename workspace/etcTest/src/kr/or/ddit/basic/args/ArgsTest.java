package kr.or.ddit.basic.args;

import java.sql.SQLOutput;

public class ArgsTest {
	
	/*
		가변형 인수 ==> 메서드의 인수의 개수가 메서드를 호출할 때마다 다를 때 사용한다.
		
		- 가변형 인수는 메서드 안에서 배열로 처리된다.
		- 가변형 인수는 한가지 자료형만 사용할 수 있다.
	
	*/
	
	
	// 매개변수로 받은 정수들의 합계를 구하는 메서드 만들기
	// (이 정수들의 개수는 상황에 따라 다르다.)
	
	// 배열을 이용한 메서드
	public int sumArr(int[] data) {
		int sum = 0;
		for(int i=0; i<data.length; i++) {
			sum += data[i];
		}
		return sum;
	}
	
	
	// 가변형 인수를 이용한 메서드
	// 배열 취급함
	// ...
	public int sumArg(int...data) { 
		int sum = 0;
		for(int i=0; i<data.length; i++) {
			sum += data[i];
		}
		return sum;
	}
	
	// 가변형 인수와 일반적인 인수를 같이 사용할 경우엔 가변형 인수를 제일 뒤쪽에 배치해야 한다.
	// (int...data, String name)으로 하면 오류남
	public String sumArg2(String name, int...data) {
		int sum = 0;
		for(int i=0; i<data.length; i++) {
			sum += data[i];
		}
		return name + "씨의 합계 : " + sum ;
	}
	
	
	
	public static void main(String[] args) {
		ArgsTest at = new ArgsTest();
		
		// 1, 2, 3, 4, 5를 sumArr() 메서드에 전달해서 결과를 출력하시오.
		// 배열을 선언과 동시에 초기화
//		int[] num = {1,2,3,4,5};

		// 배열을 선언과 동시에 초기화 & 미리 배열 변수를 만들어놓고, 한번에 초기화
		int[] num;
//		num = new int[] {100,200,300,400}
//		int result = at.sumArr(num);
//		System.out.println(result);
		
		// 100, 200, 300, 400
		System.out.println(at.sumArr(new int[] {100, 200, 300, 400}));
		// 호출을 할 때마다 개수를 다르게 해서 호출 가능
		System.out.println("---------------------------------------------");
		
		// 가변형 인수를 쓰면 직접 데이터 바로 입력 가능
		System.out.println(at.sumArg(1,2,3,4,5));
		System.out.println(at.sumArg(100,200,300,400));
		
		System.out.println("---------------------------------------------");
		
		System.out.println(at.sumArg2("홍길동", 30, 60, 90));

	} 
	
	/*
		at.test01(0, "홍길동");
		// 매개변수에 들어가는 값(예: 0, "홍길동")을 '인수'라고 부름.
		// 인수의 개수는 메소드의 매개변수의 개수의 의해 정해짐.
		// 인수의 개수가 메소드를 호출할 때마다 다를 수 있을 때는 해당 메소드를 만들 때 어떻게 만들어야 되느냐?

		
		// - 메소드를 만들어서 쓰는 이유: 똑같은 동작을 여러번 반복해서 실행해야 될 때
		// 해당 동작을 메소드로 묶어놓고 필요할 때 호출하여 실행하기 위함.
		// - 메소드 실행이 끝나면 자기를 호출했던 곳(라인)으로 다시 돌아감.
	}
	
	 
	// 메소드 이름 옆 괄호 안 매개변수 역할 : 메소드를 호출하는 쪽의 데이터를 메소드 안으로 넣어주는 역할
	public void test01(int a, String str) {
		System.out.println("a = " + a);
		System.out.println("str = " + str);
	}
	
	public int test02(int a, int b, int c) {
		return a + b + c;
	}
	
	*/
}
