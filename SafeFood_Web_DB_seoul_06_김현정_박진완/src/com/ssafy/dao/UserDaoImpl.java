package com.ssafy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.ssafy.vo.User;

public class UserDaoImpl implements UserDao {
	private Connection conn; // 데이터베이스와 통신하기위한 객체
	private List<User> list;

	public UserDaoImpl() {
		list = new LinkedList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // 드라이버 적재
			
			String dbName = "safefood";
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
	private static UserDaoImpl instance; // 인스턴스를 하나만 생성해서 사용하자
	public static UserDaoImpl getInstance() {
		if(instance == null) {
			instance = new UserDaoImpl();
		}
		return instance;
	}
	@Override
	public void signUp(User user) {
		
		String sql= "INSERT INTO user VALUES(?,?,?,?,?,?)";
		System.out.println(list.toString());
		PreparedStatement pstmt=null;
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, user.getId());
				pstmt.setString(2, user.getPassword());
				pstmt.setString(3, user.getName());
				pstmt.setString(4, user.getAddress());
				pstmt.setString(5, user.getPhone());
				pstmt.setString(6, user.getAllergy());
				
				System.out.println(pstmt.toString());
				System.out.println("before");
				pstmt.executeUpdate();
				System.out.println("after");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				if(pstmt !=null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
	}

	
	
	@Override
	public void leave(User user) {
		String sql= "DELETE FROM user WHERE id = ?";
		PreparedStatement pstmt = null;
			for (int i = 0; i < list.size(); i++) {
				if(list.get(i).getId()==user.getId()) {
					try {
						pstmt=conn.prepareStatement(sql);
						pstmt.setString(1, user.getId());
						pstmt.executeUpdate();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						if(pstmt !=null) {
							try {
								pstmt.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
					list.remove(user);
					break;
				}
			}
		
	}

	@Override
	public void modify(String id, String password, String name, String address, String phone, String allergy) {
		String sql= "ALTER FROM user WHERE id = ? AND password=?";
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		
		User result = searchID(id);
		if (result != null) {
			result.setAddress(address);
			result.setPassword(password);
			result.setName(name);
			result.setPhone(phone);
			result.setAllergy(allergy);
		}

		
		
	}

	@Override
	public User searchID(String id) {
		String sql="SELECT FROM user Where id=?";
		PreparedStatement pstmt = null;
		for (User user : list) {
			if (user.getId().equals(id)) {
				try {
					pstmt=conn.prepareStatement(sql);
					pstmt.setString(1, user.getId());
					pstmt.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					if(pstmt !=null) {
						try {
							pstmt.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				return user; // 이게 의미가 있나 ? 
			}
		}
		return null;
	}

	@Override
	public User signIn(String id, String password) {
		String sql= "SELECT * FROM user WHERE id = ? AND password=?";
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		User result=null;
		try {
			result = new User();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setString(2,password);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				result.setId(rs.getString("id"));
				result.setPassword(rs.getString("password"));
				result.setName(rs.getString("name"));
				result.setAddress(rs.getString("address"));
				result.setPhone(rs.getString("phone"));
				result.setAllergy(rs.getString("allergy"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(pstmt !=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
//		User result = searchID(id);
//		if (result != null && result.getPassword().equals(password)) {
//			return result;
//		}
		System.out.println(result.toString());
		return result;
	}
	
	@Override
	public void delete(User user) {
		String sql= "DELETE FROM user WHERE id = ? ";
		PreparedStatement pstmt = null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(pstmt !=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}