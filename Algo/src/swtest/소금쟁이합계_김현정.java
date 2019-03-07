package swtest;

import java.util.Scanner;

public class 소금쟁이합계_김현정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int su = sc.nextInt();
			int[][] map = new int[N][N];
			int cnt = 0;
			
c:			for(int i=0; i<su; i++) {
				int x = sc.nextInt(); //행
				int y = sc.nextInt(); //열
				int dir = sc.nextInt(); //방향(상:1, 하:2, 좌:3, 우:4)
			
				if(dir == 1) {
					for(int j=3; j>=1; j--) {
						if(x-j < 0 || map[x-j][y] == 1) {
							continue c;
						}
						x = x-j;
					}
					map[x][y] = 1; // 소금쟁이 머무름
					cnt++;
				}else if(dir == 2) {
					for(int j=3; j>=1; j--) {
						if(x+j >= N || map[x+j][y] == 1) {
							continue c;
						}
						x = x+j;
					}
					map[x][y] = 1; // 소금쟁이 머무름
					cnt++;
				}else if(dir == 3) {
					for(int j=3; j>=1; j--) {
						if(y-j < 0 || map[x][y-j] == 1) {
							continue c;
						}
						y = y-j;
					}
					map[x][y] = 1; // 소금쟁이 머무름
					cnt++;
				}else if(dir == 4) {
					for(int j=3; j>=1; j--) {
						if(y+j >= N || map[x][y+j] == 1) {
							continue c;
						}
						y = y+j;
					}
					map[x][y] = 1; // 소금쟁이 머무름
					cnt++;
				}
			}
			
			System.out.println("#"+tc+" "+cnt);
			
		}//end testCase
	}//end main
}//end class
