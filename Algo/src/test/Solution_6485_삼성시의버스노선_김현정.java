package test;

import java.util.Scanner;

public class Solution_6485_삼성시의버스노선_김현정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int[] busStop = new int[5001];//정류장 배열
			int N = sc.nextInt(); //노선개수
			
			for(int i=0; i<N; i++) {
				int start = sc.nextInt();//시작 정류장
				int end = sc.nextInt();//끝 정류장
				//버스가 지나가면 값을 1증가
				for(int j=start; j<=end; j++) {
					busStop[j]++;
				}
			}
			
			int P = sc.nextInt();
			String s = "";
			for(int i=0; i<P; i++) {
				s += " "+busStop[sc.nextInt()];
			}
			System.out.println("#"+tc+s);
			
		}//end testCase
		
	}//end main
}//end class
