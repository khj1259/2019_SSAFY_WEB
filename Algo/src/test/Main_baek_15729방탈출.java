package test;

import java.util.Scanner;

public class Main_baek_15729방탈출 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] lamp = new int[N];
		for(int i=0; i<N; i++) {
			lamp[i] = sc.nextInt();
		}
		
		int cnt = 0;
		for(int i=0; i<N; i++) {
			if(lamp[i] == 1) {
				lamp[i] = 0;
				if(i+1 < N) {
					lamp[i+1] = (lamp[i+1] == 1) ? 0 : 1; 
				}
				if(i+2 < N) {
					lamp[i+2] = (lamp[i+2] == 1) ? 0 : 1; 
				}
				cnt++;
			}
		}
		System.out.println(cnt);
		
	}//end main
}//end class
