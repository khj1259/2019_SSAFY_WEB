package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4014_활주로건설_김현정 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); //map 가로세로 길이
			int X = Integer.parseInt(st.nextToken()); //경사로 길이
			int[][] map = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int cnt = 0;
			int same = 1;
			for(int i = 0; i < N; i++) {
				boolean down = false;
				for(int j = 1; j < N; j++) {
					if(Math.abs(map[i][j] - map[i][j-1]) > 1) {
						break;
					}else if(map[i][j] == map[i][j-1]) { 
						same++;
					}else if(map[i][j] == map[i][j-1]+1) { // 올라갈때
						same = 1;
						if(same >= X) {
							continue;
						}else {
							break;
						}
					}else if(map[i][j] == map[i][j-1]-1) { // 내려갈때
						same = 1;
						if(down && same >= X) {
							down = true;
							continue;
						}else {
							break;
						}
					}
				}
			}
			
		}//end testCase
		
	}//end main
}//end class
