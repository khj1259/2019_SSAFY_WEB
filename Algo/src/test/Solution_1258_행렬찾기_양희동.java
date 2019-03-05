package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_1258_행렬찾기_양희동 {
	public static ArrayList<Square> info = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			info.clear();
			int N = Integer.parseInt(br.readLine());
			
			int[][] map = new int[N][N];
			int[][] check = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(check[i][j] == 0 && map[i][j] != 0) {
						search(map, check, i, j);
					}
				}
			}
			info.sort(null);
			
			System.out.print("#" + t + " " + info.size());
			for (int i = 0; i < info.size(); i++) {
				System.out.print(" " + info.get(i).x + " " + info.get(i).y);
			}
			System.out.println();
		}
	}
	
	public static void search(int[][] map, int[][] check, int x, int y) {
		// x값 증가 행 길이 찾기
		int count = 0;
		int dx = x;
		do {
			count++;
			dx++;
		} while(dx < map.length && map[dx][y] != 0);
		int sx = count;
		// y값 증가 열 길이 찾기
		count = 0;
		int dy = y;
		do {
			count++;
			dy++;
		} while(dy < map.length && map[x][dy] != 0);
		int sy = count;
		info.add(new Square(sx, sy, sx * sy));

		for (int i = x; i < dx; i++) {
			for (int j = y; j < dy; j++) {
				check[i][j] = 1;
			}
		}
	}
		
	public static class Square implements Comparable<Square>{
		int x;
		int y;
		int size;
		public Square(int x, int y, int size) {
			this.x = x;
			this.y = y;
			this.size = size;
		}
		
		@Override
		public int compareTo(Square o) {
			if(this.size == o.size) {
				return this.x - o.x;
			}
			return this.size - o.size;
		}
	}
}
