package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

public class JdbcTest06 {

	static Scanner scan = new Scanner(System.in);

	static Connection conn = DBUtil.getConnection();;
	static Statement stmt = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;

	public static void main(String[] args) {
		while (true) {
			int select = main();

			switch (select) {
			case 1:
				insert();
				break;
			case 2:                                                                                                                                                                                                                                                                                                                               
				delete();
				break;
			case 3:
				update();
				break;
			case 4:
				select();
				break;
			case 0:
				close();
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못된 입력입니다. 다시 입력해주세요");

			}
		}
	}
	
	// 종료 메서드 (DB랑 연결 종료)
	private static void close() {
		try {
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 메인 메뉴 메서드
	public static int main() {
		System.out.println("-------------------------------------");
		System.out.println("1. 자료 추가");
		System.out.println("2. 자료 삭제");
		System.out.println("3. 자료 수정");
		System.out.println("4. 전체 자료 출력");
		System.out.println("0. 작업 끝");
		System.out.println("-------------------------------------");
		System.out.print("메뉴 선택 >> ");
		return Integer.parseInt(scan.nextLine());
	}

	// 자료 추가 메서드
	public static void insert() {
		boolean check = true;
		int checking = 0;
		String id = null;

		try {
			while (check) {
				// 아이디 입력 받기
				System.out.print("아이디: ");
				id = scan.nextLine();

				String sql = "select count(*) cnt from mymember where mem_id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					checking = rs.getInt("cnt");
				}
				if (checking > 0) {
					System.out.println("이미 사용중인 아이디입니다.");
					System.out.println("다시 입력하세요.");
				} else {
					check = false;
				}
			}

			System.out.print("비밀번호: ");
			String pw = scan.nextLine();

			System.out.print("이름: ");
			String name = scan.nextLine();

			System.out.print("전화번호: ");
			String tel = scan.nextLine();

			System.out.print("주소: ");
			String addr = scan.nextLine();

			String sql2 = "insert into mymember(mem_id, mem_pass, mem_name, mem_tel, mem_addr)" + "values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, tel);
			pstmt.setString(5, addr);

			int cnt = pstmt.executeUpdate();

			if (cnt > 0) {
				System.out.println("회원정보 등록이 완료되었습니다.");
			} else {
				System.out.println("회원정보 등록을 실패했습니다.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 자료 삭제 메서드
	public static void delete() {
		boolean check = true;
		int checking = 0;
		String id = "";

		System.out.println("자료를 삭제할 회원의 아이디를 입력하세요.");

		while (check) {
			// 아이디 입력 받기
			System.out.print("회원 아이디 >> ");
			id = scan.nextLine();

			try {
				String sql = "select count(*) cnt from mymember where mem_id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					checking = rs.getInt("cnt");
				}
				if (checking == 0) {
					System.out.println("존재하지 않는 회원 아이디입니다.");
					System.out.println("다시 입력하세요.");
				} else {
					check = false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		try {
			String sql = "delete from mymember where mem_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			System.out.println(id + " 회원의 자료가 삭제되었습니다.");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	// 자료 수정 메서드
	public static void update() {
		boolean check = true;
		int checking = 0;
		String id = "";

		System.out.println("자료를 수정할 회원의 아이디를 입력하세요.");

		while (check) {
			// 아이디 입력 받기
			System.out.print("회원 아이디 >> ");
			id = scan.nextLine();

			try {
				String sql = "select count(*) cnt from mymember where mem_id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					checking = rs.getInt("cnt");
				}
				if (checking == 0) {
					System.out.println("존재하지 않는 회원 아이디입니다.");
					System.out.println("다시 입력하세요.");
				} else {
					check = false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		System.out.println(id + " 회원의 자료를 수정합니다.");

		System.out.println("수정하고자 하는 정보를 선택하세요.");
		System.out.println("1. 비밀번호 | 2. 이름 | 3. 전화번호 | 4. 주소");
		System.out.print("선택 >> ");
		int select = Integer.parseInt(scan.nextLine());
		switch (select) {
		case 1:
			System.out.print("변경할 비밀번호: ");
			String pw = scan.nextLine();
			try {
				String sql1 = "update mymember set mem_pass = ? where mem_id = ?";
				pstmt = conn.prepareStatement(sql1);
				pstmt.setString(1, pw);
				pstmt.setString(2, id);
				rs = pstmt.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(id + " 회원의 비밀번호가 변경되었습니다.");
			break;
		case 2:
			System.out.print("변경할 이름: ");
			String name = scan.nextLine();
			try {
				String sql2 = "update mymember set mem_name = ? where mem_id = ?";
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, name);
				pstmt.setString(2, id);
				rs = pstmt.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(id + " 회원의 이름이 변경되었습니다.");
			break;
		case 3:
			System.out.print("변경할 전화번호: ");
			String tel = scan.nextLine();
			try {
				String sql3 = "update mymember set mem_tel = ? where mem_id = ?";
				pstmt = conn.prepareStatement(sql3);
				pstmt.setString(1, tel);
				pstmt.setString(2, id);
				rs = pstmt.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(id + " 회원의 전화번호가 변경되었습니다.");
			break;
		case 4:
			System.out.print("변경할 주소: ");
			String addr = scan.nextLine();
			try {
				String sql4 = "update mymember set mem_addr = ? where mem_id = ?";
				pstmt = conn.prepareStatement(sql4);
				pstmt.setString(1, addr);
				pstmt.setString(2, id);
				rs = pstmt.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println(id + " 회원의 전화번호가 변경되었습니다.");
			break;
		default:
			System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
		}
	}

	// 전체 자료 출력 메서드
	public static void select() {
		System.out.println();
		System.out.println("-------------------------------------");

		try {
			String sql = "select * from mymember";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				System.out.println("회원 아이디: " + rs.getString("mem_id"));
				System.out.println("회원 비밀번호: " + rs.getString("mem_pass"));
				System.out.println("회원 이름: " + rs.getString("mem_name"));
				System.out.println("회원 전화번호: " + rs.getString("mem_tel"));
				System.out.println("회원 주소: " + rs.getString("mem_addr"));
				System.out.println("-------------------------------------");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
