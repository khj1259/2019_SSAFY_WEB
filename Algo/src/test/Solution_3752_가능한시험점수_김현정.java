package test;

import java.util.Scanner;

public class Solution_3752_가능한시험점수_김현정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int[] score = new int[N];
			int max = 0; // 나올 수 있는 최고점
			for(int i=0; i<N; i++) {
				score[i] = sc.nextInt();
				max += score[i]; 
			}
			
			int[] check = new int[max+1]; // 나올 수 있는 점수들을 체크할 배열 0~max
			check[0] = 1; // 0점은 무조건 나올 수 있음 -> 체크
			for(int i=0; i<score.length; i++) {
				for(int j = max; j>=0; j--) {
					if(j+score[i] < max && check[j] != 0) {
						check[j+score[i]] = 1;
					}
				}
			}
			check[max] = 1; // 최고점 체크
			int cnt = 0; 
			for(int i=0; i<check.length; i++) {
				if(check[i] == 1) {
					cnt++;
				}
			}
			
			System.out.println("#"+tc+" "+cnt);
			
		}
	}//end main
	
}//end class
