package com.ssafy.emp;

public class RecordNotFoundException extends Exception {

	public RecordNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "RecordNotFoundException : 데이터가 없습니다.";
	}
}
