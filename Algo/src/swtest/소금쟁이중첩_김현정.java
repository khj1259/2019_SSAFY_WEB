package swtest;

import java.util.Scanner;

public class 소금쟁이중첩_김현정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); //연못크기
			int su = sc.nextInt(); //소금쟁이 수
			
			int[][] map = new int[N][N];
			int answer = 0;
b:			for(int i=1; i<=su; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt(); 
				int dir = sc.nextInt(); //하:1 우:2
				
				if(dir == 1) {
					for(int j=3; j>=1; j--) {
						if(x+j >= N) {
							break;
						}else {
							if(map[x+j][y] == 0) { //아무도 안뛰었던 자리
								map[x+j][y] = 1;
								x = x+j;
							}else { //이미 누가 뛰었던 자리
								if(answer == 0) {
									answer = i;
								}else {
									continue b;
								}
							}
						}
					}
				}
				if(dir == 2) {
					for(int j=3; j>=1; j--) {
						if(y+j >= N) {
							break;
						}else {
							if(map[x][y+j] == 0) { //아무도 안뛰었던 자리
								map[x][y+j] = 1;
								y = y+j;
							}else { //이미 누가 뛰었던 자리
								if(answer == 0) {
									answer = i;
								}else {
									continue b;
								}
							}
						}
					}
				}
			}
			System.out.println("#"+tc+" "+answer);
			
		}//end testCase
	}//end main
}//end class
