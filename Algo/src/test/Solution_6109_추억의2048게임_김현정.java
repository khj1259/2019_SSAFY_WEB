package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_6109_추억의2048게임_김현정 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); // 타일크기
			String dir = st.nextToken(); //미는 방향
			int[][] tile = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < N; j++) {
					tile[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			if(dir.equals("up")) {
				//숫자 합치기
				for(int i = 0; i < N; i++) { //열
					for(int j = 0; j < N-1; j++) { //행
						for(int k = j+1; k < N; k++) {
							if(tile[k][i] !=0 && tile[j][i] != tile[k][i]) {
								break;
							}
							
							if(tile[j][i] == tile[k][i]) {
								tile[j][i] += tile[k][i];
								tile[k][i] = 0;
								break;
							}
						}
					}
				}
				
				//0이 있으면 땡기기
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < N-1; j++) {
						if(tile[j][i]==0) {
							for(int k = j+1; k < N; k++) {
								if(tile[k][i] == 0) {
									continue;
								}else {
									tile[j][i] = tile[k][i];
									tile[k][i] = 0;
									break;
								}
							}
						}
					}
				}
			}else if(dir.equals("down")) {
				//숫자 합치기
				for(int i = N-1; i >= 0; i--) { //열
					for(int j = N-1; j >=1; j--) { //행
						for(int k = j-1; k >= 0; k--) {
							if(tile[k][i] !=0 && tile[j][i] != tile[k][i]) {
								break;
							}
							
							if(tile[j][i] == tile[k][i]) {
								tile[j][i] += tile[k][i];
								tile[k][i] = 0;
								break;
							}
						}
					}
				}
				
				//0이 있으면 땡기기
				for(int i = N-1; i >= 0; i--) { //열
					for(int j = N-1; j >=1; j--) { //행
						if(tile[j][i]==0) {
							for(int k = j-1; k >= 0; k--) {
								if(tile[k][i] == 0) {
									continue;
								}else {
									tile[j][i] = tile[k][i];
									tile[k][i] = 0;
									break;
								}
							}
						}
					}
				}
			}else if(dir.equals("left")) {
				//숫자 합치기
				for(int j = 0; j < N; j++) { //행
					for(int i = 0; i < N-1; i++) { //열
						for(int k = i+1; k < N; k++) {
							if(tile[j][k] !=0 && tile[j][i] != tile[j][k]) {
								break;
							}
							
							if(tile[j][i] == tile[j][k]) {
								tile[j][i] += tile[j][k];
								tile[j][k] = 0;
								break;
							}
						}
					}
				}
				
				//0이 있으면 땡기기
				for(int j = 0; j < N; j++) { //행
					for(int i = 0; i < N-1; i++) { //열
						if(tile[j][i]==0) {
							for(int k = i+1; k < N; k++) {
								if(tile[j][k] == 0) {
									continue;
								}else {
									tile[j][i] = tile[j][k];
									tile[j][k] = 0;
									break;
								}
							}
						}
					}
				}
			}else if(dir.equals("right")) {
				//숫자 합치기
				for(int j = N-1; j >= 0; j--) { //행
					for(int i = N-1; i >= 1; i--) { //열
						for(int k = i-1; k >= 0; k--) {
							if(tile[j][k] !=0 && tile[j][i] != tile[j][k]) {
								break;
							}
							
							if(tile[j][i] == tile[j][k]) {
								tile[j][i] += tile[j][k];
								tile[j][k] = 0;
								break;
							}
						}
					}
				}
				
				//0이 있으면 땡기기
				for(int j = N-1; j >= 0; j--) { //행
					for(int i = N-1; i >= 1; i--) { //열
						if(tile[j][i]==0) {
							for(int k = i-1; k >= 0; k--) {
								if(tile[j][k] == 0) {
									continue;
								}else {
									tile[j][i] = tile[j][k];
									tile[j][k] = 0;
									break;
								}
							}
						}
					}
				}
			}
				
			System.out.println("#"+tc);
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					System.out.print(tile[i][j]+" ");
				}
				System.out.println();
			}
		}//end testCase
			
	}//end main
}// end class
