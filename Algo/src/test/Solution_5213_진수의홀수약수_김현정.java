package test;

import java.util.Scanner;

public class Solution_5213_진수의홀수약수_김현정{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
//			long L = sc.nextLong();
//			long R = sc.nextLong();
			int L = sc.nextInt();
			int R = sc.nextInt();
			long answer = 0;
			//f(L) +...+ f(R)
			for(int i=L; i<=R; i++) {
				answer += cal(i);
				System.out.println("ans "+answer);
			}
			System.out.println("#"+tc+" "+answer);
		}//end testCase
		
	}//end main
	
	//홀수인 약수들의 합 구하는 함수
	public static long cal(int su) {
		long sum = 0;
		for(int i=1; i<=su; i+=2) {
			if(su%i == 0) {
				sum += i;
			}
		}
		System.out.println("sum "+sum);
		return sum;
	}
}//end class
