package swtest;

import java.util.Arrays;
import java.util.Scanner;

public class 빌딩_김현정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(sc.nextLine());
			String[][] map = new String[N+2][N+2];
			
			for(int i=0; i<map.length; i++) { //map 초기화 (null을 없애기 위해서)
				Arrays.fill(map[i], "N");
			}
			
			for(int i=1; i<=N; i++) {
				String[] tmp = sc.nextLine().split(" ");
				for(int j=1; j<=N; j++) {
					map[i][j] = tmp[j-1];
				}
			}
			
			int max = 0;
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(map[i][j].equals("B")) {
						int building = 0;
						if(checkG(map, i, j)) { // 주변에 G가 있을때
							building = 2;
						}else { // 주변에 G가 없을때
							building = countB(map, i, j);
						}
						if(max < building) {
							max = building;
						}
					}
				}
			}
			System.out.println("#"+tc+" "+max);
		}//end testCase
	}//end main
	
	public static boolean checkG(String[][] map, int x, int y) {
		int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
		int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
		for(int i=0; i<8; i++) {
			if(map[x+dx[i]][y+dy[i]].equals("G")) {
				return true;
			}
		}
		return false;
	}
	
	public static int countB(String[][] map, int x, int y) {
		int sum = 0;
		for(int i=0; i<map.length; i++) {
			if(map[x][i].equals("B")) sum++;
			if(map[i][y].equals("B")) sum++;
		}
		return sum-1;
	}
}//end class
