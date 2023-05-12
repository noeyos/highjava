package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
	문제) lprod_id값을 2개를 입력 받아서 두 값중 작은 값부터 큰 값 사이의 자료들을 출력하시오.
		  (작은 값과 큰 값은 포함된다.)
	
 */

public class JdbcTest03 {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
				"pc07", "java");
		
		System.out.print("lprod_id 값1 입력 >> ");
		int id1 = scan.nextInt();
		System.out.print("lprod_id 값2 입력 >> ");
		int id2 = scan.nextInt();
		System.out.println();
		
		int min = Math.min(id1, id2);	// 두 값 중 작은 값 구하기
		int max = Math.max(id1, id2);	// 두 값 중 큰 값 구하기
		
		String sql = "select * from lprod where lprod_id between " + min + " and " + max;
		
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		System.out.println("========== 쿼리문 처리 결과 ==========");
		
		while(resultSet.next()) {
			System.out.println("LPROD_ID : " + resultSet.getInt("lprod_id"));
			System.out.println("LPROD_GU : " + resultSet.getString("lprod_gu"));
			System.out.println("LPROD_NM : " + resultSet.getString("lprod_nm"));
			System.out.println("--------------------------------------");
		}
		
		resultSet.close();
		statement.close();
		connection.close();

	}

}
