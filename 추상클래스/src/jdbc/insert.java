package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class insert {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 사용자 화면
		System.out.print("ID: ");
		String id = sc.next();
		System.out.print("PW : ");
		String pw = sc.next();
		System.out.print("NAME : ");
		String name = sc.next();

		// JDBC 연결순서(4단계)
		// 선행작업 필요 : ojdbc6.jar -> 프로젝트에 라이브러로 추가
		// 프로젝트 우클릭 -"> build path -> configure build path

		// 1. JDBC 동적로딩
		// 동적로딩을 위한 메소드 사용

		Connection conn = null;
		PreparedStatement psmt = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. DB 연결
			// DB에 접근 할때 -> 변수를 사용해서 url, id, pw를 전송
			String url = "jdbc:oracle:thin:@localhost:1521:xe";// @localhost
			String db_id = "system";
			String db_pw = "0000";

			conn = DriverManager.getConnection(url, db_id, db_pw);

			if (conn != null) {
				System.out.println("연결 성공");

			} else {
				System.out.println("연결 실패");
			}
			// 3. sql문 작성 및 전송
			String sql = "insert into member values(?, ?, ?) ";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, id);
			psmt.setString(2, pw);
			psmt.setString(3, name);

			// CRUD : create(생성), Read(읽기, 조회), Update(갱신 , 수정), Delete(삭제)
			// insert, update, delete : executeUpdate()
			// select : executeQuery()
			int cnt = psmt.executeUpdate();

			if (cnt > 0) {
				System.out.println("회원가입 성공!");

			} else {
				System.out.println("회원가입 실패!!");
			}

		} catch (ClassNotFoundException e) {
			System.out.println("동적 로딩 실패~");
		} catch (SQLException e) {
			System.out.println("DB연결 실패!");
		} finally {
			// 4. 통로 닫아주기

			try {
				if (psmt != null) {
					psmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();

			}

		}

	}
}
