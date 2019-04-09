package com.ssafy.dao;

import java.util.LinkedList;
import java.util.List;

import com.ssafy.vo.User;

public class UserDaoImpl implements UserDao {

	private List<User> list;

	public UserDaoImpl() {
		list = new LinkedList<>();
	}

	@Override
	public void signUp(User user) {
		list.add(user);
	}

	@Override
	public void leave(User user) {
		list.remove(user);
	}

	@Override
	public void modify(String id, String password, String name, String address, String phone, String allergy) {
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
		for (User user : list) {
			if (user.getId().equals(id)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public User signIn(String id, String password) {
		User result = searchID(id);
		if (result != null && result.getPassword().equals(password)) {
			return result;
		}
		return null;
	}
	
	@Override
	public void delete(User user) {
		list.remove(user);
	}

}
