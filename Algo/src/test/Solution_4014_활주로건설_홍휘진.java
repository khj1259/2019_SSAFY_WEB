package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4014_활주로건설_홍휘진 {
	
	static int n,ans,k;
	static int[][]map;
	
	static void dfs(int x, int y, int r) {
		// 0은가로 1은 세로탐색
		if (r==0) {
			int prev = map[x][y];
			int cnt = 1;
			for (int i = 1; i < n; i++) {
				if(prev == map[x][i])
					cnt++;
				else {
					if (prev - map[x][i] == -1 && cnt >= k) {
						prev = map[x][i];
						cnt = 1;
					}
					else if (prev - map[x][i] == 1 && i + k - 1 < n) {
						int t = i;
						while (t != i + k) {
							if (map[x][i] != map[x][t])
								return;
							t++;
						}
						i = t - 1;
						prev = map[x][i];
						cnt = 0;
					}
					else
						return;
				}
			}
		}
		else {
			int prev = map[x][y];
			int cnt = 1;
			for (int i = 1; i < n; i++) {
				if(prev == map[i][y])
					cnt++;
				else {
					if (prev - map[i][y] == -1 && cnt >= k) {
						prev = map[i][y];
						cnt = 1;
					}
					else if (prev - map[i][y] == 1 && i + k - 1 < n) {
						int t = i;
						while (t != i + k) {
							if (map[i][y] != map[t][y])
								return;
							t++;
						}
						i = t - 1;
						prev = map[i][y];
						cnt = 0;
					}
					else
						return;
				}
			}
		}
		ans++;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(),  " ");
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			ans = 0;
			for (int i = 0; i < n; i++) {
				dfs(i,0,0);
				dfs(0,i,1);
			}
			System.out.println("#" + t + " " + ans);
		} // end of for
	}
}