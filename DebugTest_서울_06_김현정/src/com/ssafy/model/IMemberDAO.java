package com.ssafy.model;

import java.sql.SQLException;

public interface IMemberDAO {

	boolean loginCheck(String user, String pass) throws SQLException;

	int add(Member m);

}