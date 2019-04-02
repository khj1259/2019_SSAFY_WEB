package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_4014_활주로건설_정용수 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= testcase; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int benum = 0;
			int becnt = 0;
			int chk = 0;
			int result = 0;
x:			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					if(j == 0) {
						benum = map[i][j];
						becnt = 1;
						chk = 0;
					} else {
						if(benum == map[i][j]) {
							becnt++;
							if(chk>0) {
								chk--;
								becnt=0;
							}
						} else {
							if(benum-map[i][j] == 1) {
								if(chk > 0) {
									continue x;
								}
								chk = X-1;
								benum = map[i][j];
								becnt = 1;
							} else if(benum-map[i][j] == -1) {
								if(chk > 0) {
									continue x;
								}
								if(X > becnt) {
									continue x;
								}
								benum = map[i][j];
								becnt = 1;
							} else {
								continue x;
							}
						}
					}
					if(j==N-1) {
						if(chk>0) {
							continue x;
						}
						result++;
					}
				}
			}
x1:			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					if(j == 0) {
						benum = map[j][i];
						becnt = 1;
						chk = 0;
					} else {
						if(benum == map[j][i]) {
							becnt++;
							if(chk>0) {
								chk--;
								becnt=0;
							}
						} else {
							if(benum-map[j][i] == 1) {
								if(chk > 0) {
									continue x1;
								}
								chk = X-1;
								benum = map[j][i];
								becnt = 1;
							} else if(benum-map[j][i] == -1) {
								if(chk > 0) {
									continue x1;
								}
								if(X > becnt) {
									continue x1;
								}
								benum = map[j][i];
								becnt = 1;
							} else {
								continue x1;
							}
						}
					}
					if(j==N-1) {
						if(chk>0) {
							continue x1;
						}
						result++;
					}
				}
			}
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
	
}
