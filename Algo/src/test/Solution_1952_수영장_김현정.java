package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1952_수영장_김현정 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for(int tc = 1; tc <= T; tc++) {
			int[] price = new int[4]; //1일, 1달, 3달, 1년
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < 4; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			
			int[] plan = new int[12]; // 12월 이용계획
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}
			//입력 끝
			
			int min = 0;
			int[] pay = new int[12];
			// 하루권금액*날짜수 > 한달권금액 이면  한달권을 이용하는것이 싸다
			for(int i = 0; i < plan.length; i++) {
				if(plan[i] != 0) {
					if(plan[i]*price[0] > price[1]) {
						pay[i] = price[1];
						min += price[1];
					}else {
						pay[i] = price[0]*plan[i];
						min += price[0]*plan[i];
					}
				}
			}
			
			int[] result = new int[12]; // 지불금액을 비교해서 누적할 배열
			result[0] = pay[0];
			for(int i=1; i<pay.length; i++) {
				if(i < 2) {
					result[i] = result[i-1] +pay[i];
				}else if(i == 2){
					if(result[i-1] +pay[i] > price[2]) {
						result[i] = price[2];
					}else {
						result[i] = result[i-1] +pay[i];
					}
				}else if(i > 2) {
					if(pay[i] == 0) {
						result[i] = result[i-1] +pay[i];
					}else if(result[i-1] +pay[i] > result[i-3]+price[2]) {
						result[i] = result[i-3]+price[2];
					}else {
						result[i] = result[i-1] +pay[i];
					}
				}
				
			}
			
			
			if(min > result[11]) {
				min = result[11];
			}
			
			if(min > price[3]) {
				min = price[3];
			}
			
			System.out.println("#"+tc+" "+min);
			
			
		}//end testCase
		
	}//end main
}//end class
