package hwalgo13_seoul_06_kimhyunjung;

import java.util.Scanner;

public class Solution_2819 {
	static int[][] map;
	static char[] check;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.next());
		
		for(int testcase=1; testcase<=T; testcase++) {
			map = new int[4][4];
			check = new char[10000000];
			
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					map[i][j] = Integer.parseInt(sc.next());
				}
			}
			for(int i=0; i<10000000; i++) {
				check[i] = 0;
			}
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					dfs(i, j, 0, 0);
				}
			}
			int cnt = 0;
			for(int i=0; i<10000000; i++) {
				if(check[i] != 0) {
					cnt++;
				}
			}
			System.out.println("#"+testcase+" "+cnt);
			
		}//end testcase
		
	}//end main

	public static void dfs(int i, int j, int number, int depth) {
		if(depth == 7) {
			check[number] = 1;
			return;
		}
		number = number * 10;
		number = number + map[i][j];
	
	    if (j - 1 >= 0) {	//좌
	        dfs(i, j - 1, number, depth + 1);
	    }
	    if (j + 1 < 4) {	//우
	        dfs(i, j + 1, number, depth + 1);
	    }
	    if (i - 1 >= 0) {	//상
	        dfs(i - 1, j, number, depth + 1);
	    }
	    if (i + 1 < 4) {	//하
	        dfs(i + 1, j, number, depth + 1);
	    }
	}
	
}//end class
