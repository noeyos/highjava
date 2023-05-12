package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 문제1) 사용자로부터 lprod_id값을 입력받아 입력한 값보다 lprod_id가 큰 자료들을 출력하시오.

public class JdbcTest02 {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
				"pc07", "java");
		
		System.out.print("lprod_id 값 입력 >> ");
		String id = scan.nextLine();
		System.out.println();
		String sql = "select * from lprod where lprod_id > " + id;
		
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
