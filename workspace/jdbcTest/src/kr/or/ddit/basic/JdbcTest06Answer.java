package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;

/*
회원을 관리하는 프로그램을 작성하시오... (MYMEMBER테이블 이용)

아래 메뉴의 기능을 모두 구현하시오. (CRUD 기능 구현하기)

메뉴예시)
-----------------------
1. 자료 추가			 ==> insert (C)
2. 자료 삭제			 ==> delete (D)
3. 자료 수정			 ==> update (U)
4. 전체 자료 출력		 ==> select (R)
0. 작업 끝
-----------------------

조건) 
1) '자료 추가' 메뉴에서 '회원ID'는 중복되지 않는다. (중복되면 다시 입력받는다.)
2) 자료 삭제는 '회원ID'를 입력 받아서 처리한다. 
3) 자료 수정에서 '회원ID'는 변경되지 않는다.


*/


public class JdbcTest06Answer {
	Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		new JdbcTest06Answer().memberStart(); 
	}
	
	// 회원 정보를 삭제한느 메서드
	private void deleteMember() {
		System.out.println();
		System.out.println("삭제할 회원 정보를 입력하세요.");
		System.out.print("삭제할 회원ID >> ");
		String memId = scan.nextLine();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil.getConnection();
			
			String sql = "delete from mymember where mem_id =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			
			int cnt = pstmt.executeUpdate();

			if (cnt > 0) {
				System.out.println(memId + "회원정보가 삭제되었습니다.");
			} else {
				System.out.println(memId + "회원정보 삭제를 실패했습니다.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		
	}
	
	// 시작 메서드
	public void memberStart() {
		while(true) {
			int choice = displayMenu();
			
			switch(choice) {
			case 1:		// 추가
				insertMember();
				break;
			case 2:		// 삭제
				deleteMember();
				break;
			case 3:		// 수정
				displayAll();
				break;
			case 4:		// 전체 출력
				break;
			case 0:		// 종료
				System.out.println();
				System.out.println("작업을 마칩니다.");
				return;
			default:
				System.out.println();
				System.out.println("작업 번호를 잘못 입력했습니다. 다시 입력하세요.");
			}
		}
	}
	
	// 전체 회원 정보를 출력하는 메서드
	private void displayAll() {
		System.out.println();
		System.out.println("-----------------------------------------------------------");
		System.out.println(" ID      비밀번호      이름       전화번호            주소");
		System.out.println("-----------------------------------------------------------");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			String sql="select * from mymember";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while(rs.next()) {
				String memId = rs.getString("mem_id");
				String memPass = rs.getString("mem_pass");
				String memName = rs.getString("mem_name");
				String memTel = rs.getString("mem_tel");
				String memAddr = rs.getString("mem_addr");
				System.out.println(memId + "  " + memPass + "  " + memName + "   " + memTel + "   " + memAddr);
			}
			System.out.println("-----------------------------------------------------------");
			System.out.println("전체 자료 출력 끝..");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try {rs.close();} catch(SQLException e) {}
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		
		
	}
	
	// 회원 정보를 추가하는 메서드
	private void insertMember() {
		System.out.println();
		System.out.println("추가할 회원 정보를 입력하세요.");
		
		String memId = null;	// 회원ID가 저장될 변수
		int count = 0;
		do {
			System.out.print("회원 ID >> ");
			memId = scan.nextLine();
			
			count = getMemberCount(memId);
			
			if(count>0) {
				System.out.println(memId + "은(는) 이미 등록된 회원ID 입니다.");
				System.out.println("다른 회원ID를 입력하세요.");
			}
		} while (count > 0);
		
		System.out.print("비밀번호: ");
		String memPw = scan.nextLine();

		System.out.print("이름: ");
		String memName = scan.nextLine();

		System.out.print("전화번호: ");
		String memTel = scan.nextLine();

		System.out.print("주소: ");
		String memAddr = scan.nextLine();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil.getConnection();
			
			String sql = "insert into mymember(mem_id, mem_pass, mem_name, mem_tel, mem_addr)" + "values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			pstmt.setString(2, memPw);
			pstmt.setString(3, memName);
			pstmt.setString(4, memTel);
			pstmt.setString(5, memAddr);
			
			int cnt = pstmt.executeUpdate();

			if (cnt > 0) {
				System.out.println(memId + "회원정보 등록이 완료되었습니다.");
			} else {
				System.out.println(memId + "회원정보 등록을 실패했습니다.");
			}

		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		
	}
	
	// 회원ID를 매개변수로 받아서 해당 회원이 개수를 반환하는 메서드
	private int getMemberCount(String memId) {
		int count = 0;		// 반환값이 저장될 변수
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			String sql="select count(*) cnt from mymember where mem_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try {rs.close();} catch(SQLException e) {}
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		
		return count;
	}
	
	// 메뉴를 출력하고 작업번호를 입력받아 반환하는 메서드
	private int displayMenu() {
		System.out.println();
		System.out.println("------------------------------------");
		System.out.println("   1. 자료 추가");
		System.out.println("   2. 자료 삭제");
		System.out.println("   3. 자료 수정");
		System.out.println("   4. 전체 자료 출력");
		System.out.println("   0. 작업 끝");
		System.out.println("------------------------------------");
		System.out.print("원하는 작업 선택 >> ");
		return Integer.parseInt(scan.nextLine());
	}
}
