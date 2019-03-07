package swtest;

import java.io.IOException;
import java.util.Scanner;

public class 로봇이동거리_김현정 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(sc.nextLine());
			String[][] map = new String[N][N];

			for (int i = 0; i < N; i++) {
				map[i] = sc.nextLine().split(" ");
			}

			int answer = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j].equals("A")) { // 우
						answer += right(map, i, j);
					} else if (map[i][j].equals("B")) { // 좌 우
						answer += left(map, i, j);
						answer += right(map, i, j);
					} else if(map[i][j].equals("C")){ // C 상하좌우
						answer += up_down(map, i, j);
						answer += left(map, i, j);
						answer += right(map, i, j);
					}
				}
			}
			System.out.println("#"+tc+" "+answer);
		} // end testCase

	}// end main
	
	public static int up_down(String[][] map, int x, int y) {
		int cnt=0;
		for(int i=x-1; i>=0; i--) {
			if(map[i][y].equals("S")) {
				cnt++;
			}else {
				break;
			}
		}
		for(int i=x+1; i<map.length; i++) {
			if(map[i][y].equals("S")) {
				cnt++;
			}else {
				break;
			}
		}
		return cnt;
	}

	public static int left(String[][] map, int x, int y) {
		int cnt=0;
		for(int i=y-1; i>=0; i--) {
			if(map[x][i].equals("S")) {
				cnt++;
			}else {
				break;
			}
		}
		return cnt;
	}

	public static int right(String[][]map, int x, int y) {
		int cnt=0;
		for(int i=y+1; i<map.length; i++) {
			if(map[x][i].equals("S")) {
				cnt++;
			}else {
				break;
			}
		}
		return cnt;
	}
}// end class
