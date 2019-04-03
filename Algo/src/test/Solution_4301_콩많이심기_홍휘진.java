package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4301_콩많이심기_홍휘진 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(),  " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			boolean [][] map = new boolean[m][n];
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (!map[i][j]) {
						if (j + 2 < n) map[i][j+2] = true;
						if (i + 2 < m) map[i+2][j] = true;
					}
				}
			}
			int ans = 0;
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (!map[i][j]) ans++;
				}
			}
			
			System.out.println("#" + t + " " + ans);
			
		} // end of for
	}
}
