package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4613_러시아국기같은깃발_홍휘진 {

	static int[] color;
	static char[][] map;
	static int[][] rowColor;
	static int n, m, ans;

	static void go(int cnt, int row, int color) {
		if (row == n) {
			if(color != 2) return;
			ans = Math.min(cnt, ans);
			return;
		}
		if(color == 0) {
			go(cnt + rowColor[row][1] + rowColor[row][2], row + 1, color);
			go(cnt + rowColor[row][0] + rowColor[row][2], row + 1, color + 1);
		}
		else if(color == 1) {
			go(cnt + rowColor[row][0] + rowColor[row][2], row + 1, color);
			go(cnt + rowColor[row][0] + rowColor[row][1], row + 1, color + 1);
		}
		else {
			for (int i = row; i < n; i++) {
				cnt += rowColor[i][0] + rowColor[i][1];
			}
			go(cnt, n, color);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			map = new char[n][m];
			rowColor = new int[n][3];
			color = new int[3]; // 0 은 흰색, 1은 파랑, 2은 빨강
			for (int i = 0; i < n; i++) {
				map[i] = br.readLine().trim().toCharArray();
				for (int j = 0; j < m; j++) {
					if(map[i][j] == 'W') rowColor[i][0]++;
					else if(map[i][j] == 'B') rowColor[i][1]++;
					else rowColor[i][2]++;
				}
			}
			for (int i = 0; i < 3; i++) {
				color[i] = 1;
			}
			ans = 987654321;
			go(rowColor[0][1] + rowColor[0][2],1,0);
			System.out.println("#" + t + " " + ans);
		}
	}
}
