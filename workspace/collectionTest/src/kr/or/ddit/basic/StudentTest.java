package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentTest {

/*
	문제) 학번, 이름, 국어점수, 영어점수, 수학점수, 총점, 등수를 멤버로 갖는 Student클래스를 만든다.
	이 Student클래스의 생성자에서는 학번, 이름, 국어점수, 영어점수, 수학점수만 매개변수로 받아서 초기화 처리를 한다.
	
	이 Student객체는 List에 저장하여 관리한다.
	
	List에 저장된 데이터들을 학번의 오름차순으로 정렬할 수 있는 내부 정렬 기준을 구현하고,
	총점의 역순으로 정렬하는데 총점이 같으면 이름의 오름차순으로 정렬되는 외부 정렬 기준 클래스를 작성하여
	정렬되는 결과를 출력하시오.
	
	등수는 List에 전체 데이터가 추가도니 후에 구해서 저장되도록 한다. (StudentTest클래스에 처리)
	
	(어려우면 등수 구하는 거 안 해도 됨)
*/
	
	// 등수 구하는 메서드
	public void createRank(ArrayList<Student> rankStdList) {
		for(Student std1 : rankStdList) {
			int rank = 1;
			
			for(Student std2 : rankStdList) {
			
				if(std1.getSum() < std2.getSum()) {
					rank++;
				}
			}
			
			// 구해진 등수를 기준으로 데이터의 rank변수에 저장한다.
			std1.setRank(rank);
		}
	}
	
	public static void main(String[] args) {
		
		ArrayList<Student> studentList = new ArrayList<>();
		
		studentList.add(new Student(1, "홍길동", 90, 85, 70));
		studentList.add(new Student(2, "이순신", 100, 80, 80));
		studentList.add(new Student(3, "강감찬", 95, 70, 85));
		studentList.add(new Student(4, "일지매", 75, 75, 75));
		studentList.add(new Student(5, "변학도", 85, 65, 100));
		
		StudentTest test = new StudentTest();
		
		test.createRank(studentList);
		
		System.out.println("기본...");
		for(Student std : studentList) {
			System.out.println(std);
		}
		System.out.println("==============================================");
		
		Collections.shuffle(studentList);
		
		System.out.println("섞인 후...");
		for(Student std : studentList) {
			System.out.println(std);
		}
		System.out.println("==============================================");
		
		Collections.sort(studentList);
		System.out.println("학번 오름차순으로 정렬...");
		for(Student std : studentList) {
			System.out.println(std);
		}
		System.out.println("==============================================");
		
		Collections.sort(studentList, new SortByTotal());
		System.out.println("총점의 역순으로 정렬...");
		for(Student std : studentList) {
			System.out.println(std);
		}
		System.out.println("==============================================");
		
		
		
	}

}

class Student implements Comparable<Student>{
	private int num;
	private String name;
	private int korScore;
	private int engScore;
	private int mathScore;
	private int sum;
	private int rank;
	
	//생성자
	public Student(int num, String name, int korScore, int engScore, int mathScore) {
		super();
		this.num = num;
		this.name = name;
		this.korScore = korScore;
		this.engScore = engScore;
		this.mathScore = mathScore;
		this.sum = korScore + engScore + mathScore;
	}
	
	//getter&setter
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

	public int getKorScore() {
		return korScore;
	}

	public void setKorScore(int korScore) {
		this.korScore = korScore;
	}

	public int getEngScore() {
		return engScore;
	}

	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}

	public int getMathScore() {
		return mathScore;
	}

	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}
	
	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getSum() {
		return sum;
	}
	
	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	

	@Override
	public String toString() {
		return "학번: " + num + " | 이름: " + name + " | 국어: " + korScore + "점 | 영어: " + engScore
				+ "점 | 수학: " + mathScore + "점 | 총점: " + sum + "점 | 등수: " + rank + "등";
	}

	// 내부 정렬 기준
	// 학번 오름차순
	// 내부 정렬 기주은 현재 객체(this)와 매개변수에 저장되는 객체와 비교해서 처리한다.
	// 현재 객체(this)가 앞쪽 데이터, 매개변수에 저장된 객체가 뒤쪽 데이터라고 하고 코딩한다.
	public int compareTo(Student std) { //this랑 괄호 안에 있는 std랑 비교함
		//Wrapper 클래스 이용
		return Integer.compare(this.getNum(), std.getNum()); //compare(this값, std값)
	}
	
}

// 총점의 역순으로 정렬하는데 총점이 같으면 이름의 오름차순으로 정렬되는 외부 정렬 기준 클래스를 작성
class SortByTotal implements Comparator<Student> {
	
	@Override
	public int compare(Student std1, Student std2) {
		if(std1.getSum() == std2.getSum()) { // 총점이 같으면
			return std1.getName().compareTo(std2.getName()); // 이름의 오름차순 정렬
		} else { // 총점의 내림차순 정렬
			return Integer.compare(std1.getSum(), std2.getSum()) * -1; // 역순이니까 곱하기 -1
		}
		
	}
}
