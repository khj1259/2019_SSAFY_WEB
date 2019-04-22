package com.ssafy.dao;

import com.ssafy.vo.User;

public interface UserDao {
	
	public void signUp(User user);
	
	public User signIn(String id, String password);
	
	public void leave(User user);
	
	public void modify(String id, String password, String name, String address, String phone, String allergy);
	
	public User searchID(String id);
	
	public void delete(User user);
	
	public String searchPass(String id, String name);
	
	public User userInfo(String id);
}
