package test;

import java.util.Scanner;

public class Solution_1861_정사각형방_김현정 {
	static int[][] visit;
	static int[][] data;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int N;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int tc = s.nextInt();
		for (int t = 1; t <= tc; t++) {

			N = s.nextInt();//

			data = new int[N][N];
			visit = new int[N][N];// 방문여부

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					data[i][j] = s.nextInt();
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visit[i][j] == 0)//no visit
						dfs(i, j);
				}
			}
			get_result(t);
		}
	}

	static void dfs(int x, int y) {
		visit[x][y] = 1;

		for (int i = 0; i < 4; i++) {
			int ax = x + dx[i];
			int ay = y + dy[i];

			if (!inRange(ax, ay))
				continue;

			if (data[ax][ay] == data[x][y] + 1) {// 새위치의 값이 현재위치보다 1큰값이라면, 조건에 부합
				if (visit[ax][ay] == 0) // 방문 안한 칸인지 확인 후 다시  dfs
					dfs(ax, ay);
				
				visit[x][y] = Math.max(visit[x][y], visit[ax][ay] + 1);
			}
		}
	}

	static void get_result(int tc) {
		int cnt = 0;
		int num = 987654321;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (cnt < visit[i][j]) {
					cnt = visit[i][j];//cnt
					num = data[i][j];//room number
					
				} else if (cnt == visit[i][j]) {//방번호 같으면 작은 방번호
					num = Math.min(num, data[i][j]);
				}
			}
		}
		System.out.println("#" + tc + " " + num + " " + cnt);
	}

	static boolean inRange(int nx, int ny) {
		return (nx >= 0 && nx < N && ny >= 0 && ny < N); 
			
	}

}
