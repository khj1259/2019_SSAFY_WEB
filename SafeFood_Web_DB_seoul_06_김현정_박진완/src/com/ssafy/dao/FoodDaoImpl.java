package com.ssafy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.ssafy.util.FoodSaxParser;
import com.ssafy.vo.EatFood;
import com.ssafy.vo.Food;
import com.ssafy.vo.FoodPageBean;

public class FoodDaoImpl implements FoodDao{
	private Connection conn; // 데이터베이스와 통신하기위한 객체

//	private List<Food> foods;
	private String[] allergys = { "대두", "땅콩", "우유", "게", "새우", "참치", "연어", "쑥", "소고기", "닭고기", "돼지고기", "복숭아", "민들레",
	"계란흰자" };
	
	private FoodDaoImpl() {
//		foods = new LinkedList<Food>();
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
//		loadData(); // 최초 한번만 Food 데이터 넣고 주석처리?
	}
	
	private static FoodDaoImpl instance; // 인스턴스를 하나만 생성해서 사용하자
	public static FoodDaoImpl getInstance() {
		if(instance == null) {
			instance = new FoodDaoImpl();
		}
		return instance;
	}
	
	
	/**
	 * 식품 영양학 정보와 식품 정보를  xml 파일에서 읽어와서 db에 저장한다.
	 */
	public void loadData() {
		System.out.println("food데이터 최초 insert");
		FoodSaxParser parser = new FoodSaxParser();
		List<Food> foods = parser.getFoods();//  FoodNutritionSaxPaser를 이용하여 Food 데이터들을 가져온다
		String sql = "INSERT INTO food VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		for (Food food : foods) {
			PreparedStatement pstmt = null;
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, food.getCode());
				pstmt.setString(2, food.getName());
				pstmt.setDouble(3, food.getSupportpereat());
				pstmt.setDouble(4, food.getCalory());
				pstmt.setDouble(5, food.getCarbo());
				pstmt.setDouble(6, food.getProtein());
				pstmt.setDouble(7, food.getFat());
				pstmt.setDouble(8, food.getSugar());
				pstmt.setDouble(9, food.getNatrium());
				pstmt.setDouble(10, food.getChole());
				pstmt.setDouble(11, food.getFattyacid());
				pstmt.setDouble(12, food.getTransfat());
				pstmt.setString(13, food.getMaker());
				pstmt.setString(14, food.getMaterial());
				pstmt.setString(15, food.getImg());
				String allergyList = "";
				for (String allergy : allergys) {
					if (food.getMaterial().contains(allergy)) { // 알러지 있으면 //원재료에 검색
						allergyList += allergy + " ";
					}
				}
				food.setAllergy(allergyList);
				pstmt.setString(16, food.getAllergy());
				pstmt.executeUpdate(); // 삽입, 삭제, 수정

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
		}
	}
	
	
	/**
	 * 검색 조건(key) 검색 단어(word)에 해당하는 식품 정보(Food)의 개수를 반환. 
	 * web에서 구현할 내용. 
	 * web에서 페이징 처리시 필요 
	 * @param bean  검색 조건과 검색 단어가 있는 객체
	 * @return 조회한  식품 개수
	 */
	public int foodCount(FoodPageBean  bean){
		return 0;
//		return foods.size();
	}
	
	/**
	 * 검색 조건(key) 검색 단어(word)에 해당하는 식품 정보(Food)를  검색해서 반환.  
	 * @param bean  검색 조건과 검색 단어가 있는 객체
	 * @return 조회한 식품 목록
	 */
	public List<Food> searchAll(FoodPageBean  bean){
		System.out.println("searchAll 함수 실행");
		List<Food> list = new LinkedList<Food>();
		String sql = "SELECT * FROM food"; // 전체 검색
		String sql2 = "SELECT * FROM food WHERE name like ?"; //이름으로 검색
		String sql3 = "SELECT * FROM food WHERE maker like ?"; //제조사로 검색
		String sql4 = "SELECT * FROM food WHERE material like ?"; //원재료로 검색
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			if(bean !=null) { // 검색조건이 있으면
				String key = bean.getKey();
				String word = bean.getWord();
				if(!key.equals("all") && word!=null && !word.trim().equals("")) { // key null없다, 
					list = new LinkedList<Food>();
					//식품명 검색 구현
					if(key.equals("name")) {
						pstmt = conn.prepareStatement(sql2);
						pstmt.setString(1, "%"+bean.getWord()+"%");
						rs = pstmt.executeQuery(); // select
					}
					//제조사 검색  구현
					else if(key.equals("maker")) {
						pstmt = conn.prepareStatement(sql3);
						pstmt.setString(1, "%"+bean.getWord()+"%");
						rs = pstmt.executeQuery(); // select
					}
					// 원재료 검색 구현
					else if(key.equals("material")) {
						pstmt = conn.prepareStatement(sql4);
						pstmt.setString(1, "%"+bean.getWord()+"%");
						rs = pstmt.executeQuery(); // select
					}
					
				}else { // 검색 단어 없으면
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery(); // select
				}
			}else { // 검색 조건 없이 전체 검색이면
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery(); // select
			}
			
			while(rs.next()) { // 다음행의 데이터가 존재하면 true/ 없으면 false
				Food food = new Food();
				food.setCode(rs.getInt("code"));
				food.setName(rs.getString("name"));
				food.setSupportpereat(rs.getDouble("supportpereat"));
				food.setCalory(rs.getDouble("calory"));
				food.setProtein(rs.getDouble("protein"));
				food.setFat(rs.getDouble("fat"));
				food.setSugar(rs.getDouble("sugar"));
				food.setNatrium(rs.getDouble("natrium"));
				food.setChole(rs.getDouble("chole"));
				food.setFattyacid(rs.getDouble("fattyacid"));
				food.setMaker(rs.getString("maker"));
				food.setMaterial(rs.getString("material"));
				food.setImg(rs.getString("img"));
				food.setAllergy(rs.getString("allergy"));
				list.add(food); // 리턴할 list 객체에 추가
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
	
	/**
	 * 식품 코드에 해당하는 식품정보를 검색해서 반환.(food detail 정보)
	 * @param code	검색할 식품 코드
	 * @return	식품 코드에 해당하는 식품 정보, 없으면 null이 리턴됨
	 */
	public Food search(int code) {
//		System.out.println("food 한개 검색");
		// 코드에 맞는 식품 검색하여 리턴
		Food food = new Food();
		String sql = "SELECT * FROM food WHERE code = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, code);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				food.setCode(rs.getInt("code"));
				food.setName(rs.getString("name"));
				food.setSupportpereat(rs.getDouble("supportpereat"));
				food.setCalory(rs.getDouble("calory"));
				food.setProtein(rs.getDouble("protein"));
				food.setFat(rs.getDouble("fat"));
				food.setSugar(rs.getDouble("sugar"));
				food.setNatrium(rs.getDouble("natrium"));
				food.setChole(rs.getDouble("chole"));
				food.setFattyacid(rs.getDouble("fattyacid"));
				food.setMaker(rs.getString("maker"));
				food.setMaterial(rs.getString("material"));
				food.setImg(rs.getString("img"));
				food.setAllergy(rs.getString("allergy"));
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
		return food;
	}

	/**
	 * 가장 많이 검색한 Food  정보 리턴하기 
	 * web에서 구현할 내용.  
	 * @return
	 */
	public List<Food> searchBest() {
		return null;
	}
	
	public List<Food> searchBestIndex() {
		return null;
	}
	
	public static void main(String[] args) {
		FoodDaoImpl dao = new FoodDaoImpl();
//		dao.loadData();
		System.out.println("===================================1번 코드 검색=============================");
		System.out.println(dao.search(1));
		System.out.println("===========================material로 검색=================================");
		print(dao.searchAll(new FoodPageBean("material", "감자전분", null, 0)));
		System.out.println("===========================maker로 검색=================================");
		print(dao.searchAll(new FoodPageBean("maker", "빙그레", null, 0)));
		System.out.println("===========================name으로 검색=================================");
		print(dao.searchAll(new FoodPageBean("name", "라면", null, 0)));
		System.out.println("============================================================");
		print(dao.searchAll(null));
		System.out.println("============================================================");
	}
	
	public static void print(List<Food> foods) {
		for (Food food : foods) {
			System.out.println(food);
		}
	}
	
	//내 알러지와 식품에 포함된 알러지 성분 비교
	@Override
	public List<String> containAllergy(String foodAllergy, String userAllergy) {
//		System.out.println(foodAllergy);
//		System.out.println(userAllergy);
		String[] fa = foodAllergy.split(" ");
		String[] ua = userAllergy.split(",");
		List<String> result = new ArrayList<>();
		for (String userall : ua) {
			for (String foodall : fa) {
				if(userall.equals(foodall)) {
					result.add(foodall);
				}
			}
		}
		return result;
	}


	// 섭취식품 추가
	@Override
	public int insertEatFood(String id, String code, int cnt) {
		String sql = "INSERT INTO eatfood VALUES(0, ?, ?, ?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, code);
			pstmt.setInt(3, cnt);
			
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
	}

	//섭취식품 전체 검색
	@Override
	public List<EatFood> selectAllEatFood(String id) {
		System.out.println("섭취식품 전체 검색");
		List<EatFood> list = new ArrayList<EatFood>();
		String sql = "SELECT * FROM eatfood WHERE id = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				EatFood eatFood = new EatFood();
				eatFood.setEatfoodcode(rs.getInt("eatfoodcode"));
				eatFood.setId(rs.getString("id"));
				eatFood.setCode(rs.getInt("code"));
				eatFood.setCnt(rs.getInt("cnt"));
				list.add(eatFood);
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
