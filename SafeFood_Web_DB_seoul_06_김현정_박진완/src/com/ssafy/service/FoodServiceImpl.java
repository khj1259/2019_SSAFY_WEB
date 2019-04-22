package com.ssafy.service;

import java.util.List;

import com.ssafy.dao.FoodDao;
import com.ssafy.dao.FoodDaoImpl;
import com.ssafy.dao.UserDao;
import com.ssafy.dao.UserDaoImpl;
import com.ssafy.util.FoodSaxParser;
import com.ssafy.vo.EatFood;
import com.ssafy.vo.Food;
import com.ssafy.vo.FoodPageBean;
import com.ssafy.vo.User;

public class FoodServiceImpl implements FoodService {
	private FoodDao dao;
	private UserDao userDao;
	private FoodSaxParser fsp;

	public FoodServiceImpl() {
		dao = FoodDaoImpl.getInstance();
		userDao = new UserDaoImpl();
		fsp = new FoodSaxParser();
	}
	
	public List<Food> searchAll(FoodPageBean bean) {
		return dao.searchAll(bean);
	}
	
	public List<Food> getFoods(){
		return fsp.getFoods();
	}

	public Food search(int code) {
		// code에 맞는 식품 정보를 검색하여 리턴
		Food food = new Food();
		food = dao.search(code);

		return food;
	}

	public List<Food> searchBest() {
		return dao.searchBest();
	}

	public List<Food> searchBestIndex() {
		return dao.searchBestIndex();
	}

	public void addUser(String id, String password, String name, String address, String phone, String allergy) {
		User user = new User(id, password, name, address, phone, allergy);
		userDao.signUp(user);
	}
	
	public void modifyUser(String id, String password, String name, String address, String phone, String allergy) {
		userDao.modify(id, password, name, address, phone, allergy);
	}

	public User signIn(String id, String password) {
		User user = userDao.signIn(id, password);
		return user;
	}
	
	public boolean deleteUser(User user) {
//		User result = userDao.searchID(user.getId());
//		System.out.println(result);
//		if (result.getPassword().equals(user.getPassword())) {
//			userDao.delete(user);
//			return true;
//		}
		userDao.delete(user);
		return true;
	}

	public static void main(String[] args) {
		FoodDaoImpl dao = FoodDaoImpl.getInstance();
		FoodServiceImpl fsi = new FoodServiceImpl();
		fsi.dao = dao;
		System.out.println(fsi.search(2).getAllergy());
	}

	public static void print(List<Food> foods) {
		for (Food food : foods) {
			System.out.println(food);
		}
	}
	
	@Override
	public List<String> containAllergy(String foodAllergy, String userAllergy) {
		return dao.containAllergy(foodAllergy, userAllergy);
	}

	@Override
	public int insertEatFood(String id, String code, int cnt) {
		return dao.insertEatFood(id, code, cnt);
	}

	@Override
	public List<EatFood> selectAllEatFood(String id) {
		return dao.selectAllEatFood(id);
	}

	@Override
	public int deleteEatFood(int eatfoodcode) {
		return dao.deleteEatFood(eatfoodcode);
	}

	@Override
	public int updateEatFood(int eatfoodcode, int cnt) {
		return dao.updateEatFood(eatfoodcode, cnt);
	}

	public String searchPass(String id, String name) {
		String result=userDao.searchPass(id, name);
		return result;
	}

	@Override
	public User userInfo(String id) {
		return userDao.userInfo(id);
	}

}
