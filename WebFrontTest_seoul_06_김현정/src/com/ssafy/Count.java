package com.ssafy;

import java.util.Arrays;
import java.util.Comparator;

public class Count {	
	
	public String execute(String msg) {
		//구현하세요.   필요하면  변수, 추가 메서드 구현 가능, 리턴타입 변경도 가능
		int[][] numArr = new int[10][2]; //{해당 숫자의 인덱스, 빈도수}
		
		for(int i=0; i<10; i++) {
			numArr[i][0] = i; // 초기화
		}
		
		for(int i=0; i<msg.length(); i++) {
			int su = Character.getNumericValue(msg.charAt(i));
			numArr[su][1]++;
		}
		
		Arrays.sort(numArr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] >= o2[1] ? -1 : 1;
			}
		});
		
		String answer = "";
		for(int i=0; i<3; i++) {
			answer += numArr[i][0];
		}
		
		
		return answer;  //구현시 리턴값 변경
	}
	public static void main(String[] args) {
		Count c=new Count();
		System.out.println(c.execute("5329053995535987827332679340558347453272569584")); //539
		System.out.println(c.execute("122333444455555666666")); //654
	}
}
