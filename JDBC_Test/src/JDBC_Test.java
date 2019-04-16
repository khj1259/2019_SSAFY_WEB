import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * JDBC : 자바에서 데이터베이스에 접속하기 위한 인터페이스 (라이브러리)
 * 			JDBC를 하기 위해서는  Connection 객체를 사용한다
 * 			자바에서는 Connection 인터페이스만 제공된다
 * 			각 DB회사에서는 Connection 인터페이스를 추상메서드
 *			
 *https://mvnrepository.com/	자바 라이브러리 오픈소스 여기 다 있음, 사용량 
 *		MySQL 검색해서 최신버전 *.jar 파일을 다운 받음
 *		Eclipse 프로젝트에 추가작업
 *			lib 폴더 생성
 *			빌드패스 - 라이브러리 - add jar...에 추가
 */
public class JDBC_Test {
//	실행순서 : static을 먼저 (기본값 저장, 명시적 선언한 값으로 초기화, 초기화블럭)
	static Connection conn; // 명시적 선언
	
	static { // static 초기화 블럭
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // 드라이버 적재
			//연결
			String url = "jdbc:mysql://127.0.0.1/"+"mydb"; // 데이터베이스명
			url += "?characterEncoding=UTF-8&serverTimezone=UTC";
			String user = "root";
			String password = "tiger";
			conn = DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
	}
	
	public static void main(String[] args) {
//		 영구적으로 데이터 저장하는 방법 DB, 
//		1. Connection 연결(디비 접속)
//		2. SQL 문을 DB에 전달
//		3. SQL 질의 겨롸 리턴받음
		
		try {
			
			System.out.println("정상적으로 연결됨");
			System.out.println(!conn.isClosed() + " <= true 가 나오면 정상적으로 연결");
			
//			String sql = "INSERT INTO books (book_id, title, publisher, year, price) "
//						+"VALUES(0, 'JDBC 완성', '사피출판', '2019', 50000)"; // 0 입력시, 다음값으로 삽입됨
			String sql = "INSERT INTO books (title, publisher, year, price) "
					+"VALUES('JDBC 완성', '사피출판', '2019', 50000)";
			Statement stmt = conn.createStatement(); // 완성된 문자열로 쿼리를 날림
//			execute(sql)		: DDL (CREATE, ALTER)
//			executeUpdate(sql)	: DML (INSERT, UPDATE..)
//			executeQuery(sql)	: DQL (SELECT)
			
//			int result = stmt.executeUpdate(sql); // 쿼리 실행
//			System.out.println("쿼리 DB에 전달 성공 : "+ result+"행이  affected");
			
			// 사용자에게 제목, 출판사, 연도, 금액을 입력받아서 INSERT 하기
			Scanner sc = new Scanner(System.in);
			System.out.print("책 제목 : ");
			String title = sc.nextLine();
			System.out.print("출판사 : ");
			String publisher = sc.nextLine();
			System.out.print("연도 : ");
			String year = sc.nextLine();
			System.out.print("금액 : ");
			int price = Integer.parseInt(sc.nextLine().trim());
			
			insertBook(title, publisher, year, price);
			
//			String sql2 = "INSERT INTO books "
//						+"VALUES(0,'"+title+"', '"+publisher+"', '"+year+"', "+price+")";
//			
//			int result2 = stmt.executeUpdate(sql2);
//			System.out.println("쿼리 DB에 전달 성공 : "+result2+"행이 affected");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}//end main
	
	static void insertBook(String title, String publisher, String year, int price) {
		try {
			String sql3 = "INSERT INTO books VALUES (0, ?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql3);
			pstmt.setString(1, title); //첫번째 물음표에 title 변수의 값을 문자열 형태로 채워라
			pstmt.setString(2, publisher);
			pstmt.setString(3, year);
			pstmt.setInt(4, price);
			
			int result = pstmt.executeUpdate();
			System.out.println("쿼리 DB에 전달 성공 : "+result+"행이 affected");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}//end class
