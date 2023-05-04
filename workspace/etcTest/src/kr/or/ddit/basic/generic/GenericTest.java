package kr.or.ddit.basic.generic;

// 제네릭을 적용하는 class 만들기
class Generic {
	
}




// 제네릭을 적용하지 않은 class 작성
class NonGeneric {	// 어떤 객체든 다 저장 가능
	// 오브젝트용 변수를 만들어줌
	private Object value;
	
	public Object getValue() {
		return value;
	}
	
	public void setValue(Object value) {
		this.value = value;
	}
}

/*

제네릭을 적용한 클래스 만드는 방법
형식)

	class 클래스명<제네릭타입글자> {
		private 제네릭타입글자 변수명;						// 변수 선언에 제네릭을 사용한 경우
		...
		
		public 제네릭타입글자 메서드명(매개변수들...) {		// 반환값이 있는 메서드에서 제네릭을 사용한 경우
			...
			return 반환값;
		}
		
		public void 메서드명(제네릭타입글자 변수명) {		// 메서드의 매개변수에 제네릭을 사용한 경우
			...
		}
		
	}


	// 제네릭타입글자 ==> 영문자 대문자 1글자로 표기한다.
	   T  ==>  Type
	   K  ==>  Key
	   V  ==>  Value
	   E  ==>  Element
	
*/


// 어떤 객체가 데이터를 관리하는 객체일 때 제네릭을 주로 씀.
// 데이터를 관리하는 객체는 모든 종류의 객체를 받을 수 있어야 함.
// 데이터를 보관하는 객체를 생성할 때 객체의 타입을 지정.


// 제네릭을 사용한 class 작성
class MyGeneric<T> {
	private T value;
	
	public void setValue(T value) {
		this.value = value;
	}
	
	public T getValue() {
		return this.value;
	}
	
	
}

public class GenericTest {
	
	public static void main(String[] args) {
		NonGeneric ng1 = new NonGeneric();
		ng1.setValue("가나다라");
		
		NonGeneric ng2 = new NonGeneric();
		ng2.setValue(123);
		
		String temp1 = (String)ng1.getValue();	// 형변환이 필수적으로 필요하다.
//		Object temp1 = ng1.getValue();
		System.out.println("temp1 = " + temp1);
		
		int intTemp1 = (Integer)(ng2.getValue());
//		Object temp2 = ng2.getValue();
		System.out.println("intTemp1 = " + intTemp1);
		System.out.println("---------------------------------------------");
		
		MyGeneric<String> mg1 = new MyGeneric<>();	// MyGeneric<T>에 String이 들어감.
		mg1.setValue("안녕하세요");
		//mg1.setValue(100); <== 오류 발생
		
		MyGeneric<Integer> mg2 = new MyGeneric<>();
		mg2.setValue(100);
		
		String temp2 = mg1.getValue();	// 형변환없이 데이터를 꺼내올 수 있다.
		int intTemp2 = mg2.getValue();
		
		System.out.println("제네릭의 temp2 = " + temp2);
		System.out.println("제네릭의 intTemp2 = " + intTemp2);
		
		System.out.println("---------------------------------------------");
		
		NonGeneric test = new NonGeneric();
		
		test.setValue("ABCDE");
		
//		int a = (int)test.getValue();	// 실제는 오류지만 컴파일 단계에서는 오류가 발견되지 않고 실행 중일 때만 발견된다.
		
		MyGeneric<String> test2 = new MyGeneric<>();
		test2.setValue("XYZ");
//		int b = test2.getValue();		// 오류가 컴파일 단계에서 바로 발견된다.
	}
}
