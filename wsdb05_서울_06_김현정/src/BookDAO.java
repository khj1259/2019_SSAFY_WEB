import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
	private Connection conn; // 데이터베이스와 통신하기위한 객체
	// BookDAO 을 싱글톤 패턴으로 사용해 보자
	private BookDAO() { // 객체생성을 외부클래스에서 하지 못하도록 막음
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // 드라이버 적재
			
			String dbName = "mydb";
			String url = "jdbc:mysql://127.0.0.1/"+dbName+ "?characterEncoding=UTF-8&serverTimezone=UTC";
			String user = "root";
			String password = "tiger";

			conn = DriverManager.getConnection(url, user, password);
			
			System.out.println(!conn.isClosed() + " : DB 연결 성공여부");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	private static BookDAO instance; // 인스턴스를 하나만 생성해서 사용하자
	public static BookDAO getInstance() {
		if(instance == null) {
			instance = new BookDAO();
		}
		return instance;
	}
	
	/**
	 * 책 한권의 정보를 데이터베이스에 삽입하는 메서드
	 * @param book
	 * 책 한권에 대한 정보가 BookVO 객체로 전달된다
	 * @return
	 * 쿼리문을 수행해서 영향받은 레코드의 수를 리턴
	 */
	public int insertBook(BookVO book) {
		String sql = "INSERT INTO book VALUES(?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getIsbn());;
			pstmt.setString(2, book.getTitle());;
			pstmt.setString(3, book.getAuthor());;
			pstmt.setString(4, book.getPublisher());
			pstmt.setInt(5, book.getPrice());
			pstmt.setString(6, book.getDescription());
			
			return pstmt.executeUpdate(); // 삽입, 삭제, 수정

		} catch (SQLException e) {
			e.printStackTrace();
		} finally { //사용한 자원을 반환
			try {
				if(pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return -1; // 쿼리수행중 에러발생
	}//end insertBook()
	
	/**
	 * book 하나의 정보를 받아서 id에 해당하는 레코드를 나머지 필드 값으로 변경하기
	 */
	public int updateBook(BookVO book) {
		String sql = "UPDATE book SET title=?, author=?, publisher=?, price=?, description=? WHERE isbn=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getTitle());;
			pstmt.setString(2, book.getAuthor());;
			pstmt.setString(3, book.getPublisher());
			pstmt.setInt(4, book.getPrice());
			pstmt.setString(5, book.getDescription());
			pstmt.setString(6, book.getIsbn());;
			
			return pstmt.executeUpdate(); // 삽입, 삭제, 수정
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { //사용한 자원을 반환
			try {
				if(pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return -1;
	}// end updateBook()	
	
	/**
	 * book 하나의 정보를 받아서 id에 해당하는 레코드를 삭제
	 */
	public int deleteBook(BookVO book) {
		String sql = "DELETE FROM book WHERE isbn=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getIsbn());
			
			return pstmt.executeUpdate(); // 삽입, 삭제, 수정
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { //사용한 자원을 반환
			try {
				if(pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return -1;
	}// end deleteBook()
	
	/**
	 * select * from books 실행해서 조회된 모든 책의 정보를 리스트로 만들어서 리턴
	 */
	public List<BookVO> selectAll(){
		List<BookVO> list = new ArrayList<>();
		String sql = "SELECT * FROM book";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); // select 
			
			while(rs.next()) { // 다음행의 데이터가 존재하면 true/ 없으면 false
				BookVO book = new BookVO();
				book.setIsbn(rs.getString(1));
				book.setTitle(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setPublisher(rs.getString(4));
				book.setPrice(rs.getInt(5));
				book.setDescription(rs.getString(6));
				list.add(book); // 리턴할 list 객체에 추가
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { //사용한 자원을 반환
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}// end selectAll()

	/**
	 * books 테이블에서 bookid의 id값을 가지고 있는 정보 하나만 리턴하기
	 */
	public BookVO selectOne(String isbn) {
		BookVO book = new BookVO();
		String sql  = "SELECT * FROM book WHERE isbn=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, isbn);
			rs = pstmt.executeQuery(); // select 
			
			while(rs.next()) { // 다음행의 데이터가 존재하면 true/ 없으면 false
				book.setIsbn(rs.getString(1));
				book.setTitle(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setPublisher(rs.getString(4));
				book.setPrice(rs.getInt(5));
				book.setDescription(rs.getString(6));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { //사용한 자원을 반환
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return book;
	}//end selectOne()
}
