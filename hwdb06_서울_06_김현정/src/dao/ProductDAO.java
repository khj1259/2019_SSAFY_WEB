package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Product;

public class ProductDAO {
	private Connection conn; // 데이터베이스와 통신하기위한 객체
	// BookDAO 을 싱글톤 패턴으로 사용해 보자
	private ProductDAO() { // 객체생성을 외부클래스에서 하지 못하도록 막음
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
	private static ProductDAO instance; // 인스턴스를 하나만 생성해서 사용하자
	public static ProductDAO getInstance() {
		if(instance == null) {
			instance = new ProductDAO();
		}
		return instance;
	}
	
	/**
	 * 상품 한개를 데이터베이스에 삽입
	 */
	public int insertProduct(Product product) {
		String sql = "INSERT INTO product VALUES(?, ?, ?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getCode());;
			pstmt.setString(2, product.getName());;
			pstmt.setInt(3, product.getPrice());;
			
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
	}//end insertProduct()
	
	/**
	 * product 하나의 정보를 받아서 code에 해당하는 레코드를 나머지 필드 값으로 변경하기
	 */
	public int updateBook(Product product) {
		String sql = "UPDATE product SET name=?, price=? WHERE code=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getName());;
			pstmt.setInt(2, product.getPrice());
			pstmt.setString(3, product.getCode());;
			
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
	}// end updateProduct()	
	
	/**
	 * Product 하나의 정보를 받아서 code에 해당하는 레코드를 삭제
	 */
	public int deleteBook(Product product) {
		String sql = "DELETE FROM product WHERE code=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getCode());
			
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
	}// end deleteProduct()
	
	/**
	 * select * from product 실행해서 조회된 모든 책의 정보를 리스트로 만들어서 리턴
	 */
	public List<Product> selectAll(){
		List<Product> list = new ArrayList<>();
		String sql = "SELECT * FROM product";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); // select 
			
			while(rs.next()) { // 다음행의 데이터가 존재하면 true/ 없으면 false
				Product product = new Product();
				product.setCode(rs.getString(1));
				product.setName(rs.getString(2));
				product.setPrice(rs.getInt(3));
				list.add(product); // 리턴할 list 객체에 추가
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
	public Product selectOne(String code) {
		Product product = new Product();
		String sql  = "SELECT * FROM product WHERE code=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			rs = pstmt.executeQuery(); // select 
			
			while(rs.next()) { // 다음행의 데이터가 존재하면 true/ 없으면 false
				product.setCode(rs.getString(1));
				product.setName(rs.getString(2));
				product.setPrice(rs.getInt(3));
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
		return product;
	}//end selectOne()

	public List<Product> searchByName(String name) {
		List<Product> list = new ArrayList<>();
		String sql  = "SELECT * FROM product WHERE name LIKE ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+name+"%");
			rs = pstmt.executeQuery(); // select 
			
			while(rs.next()) { // 다음행의 데이터가 존재하면 true/ 없으면 false
				Product product = new Product();
				product.setCode(rs.getString(1));// 컬럼의 순번으로 
				product.setName(rs.getString(2));
				product.setPrice(rs.getInt(3));
				list.add(product);
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
	}

	public List<Product> searchByCode(String code) {
		List<Product> list = new ArrayList<>();
		String sql  = "SELECT * FROM product WHERE code LIKE ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+code+"%");
			rs = pstmt.executeQuery(); // select 
			
			while(rs.next()) { // 다음행의 데이터가 존재하면 true/ 없으면 false
				Product product = new Product();
				product.setCode(rs.getString(1));// 컬럼의 순번으로 
				product.setName(rs.getString(2));
				product.setPrice(rs.getInt(3));
				list.add(product);
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
	}
}
