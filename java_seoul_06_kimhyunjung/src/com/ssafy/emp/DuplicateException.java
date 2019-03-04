package com.ssafy.emp;

public class DuplicateException extends Exception {

	public DuplicateException() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "DuplicateException : 데이터가 중복되었습니다.";
	}
}
