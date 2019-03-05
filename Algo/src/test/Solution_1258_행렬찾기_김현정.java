package test;

import java.util.ArrayList;
import java.util.Scanner;

//양희동 참고
public class Solution_1258_행렬찾기_김현정 {
	public static ArrayList<Square> info = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			info.clear();
			int N = sc.nextInt();
			
			int[][] space = new int[N][N];
			boolean[][] check = new boolean[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					space[i][j] = sc.nextInt();
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(space[i][j] != 0 && check[i][j] == false) {
						search(space, check, i, j);
					}
				}
			}
			info.sort(null);
			
			System.out.print("#" + tc + " " + info.size());
			for (int i = 0; i < info.size(); i++) {
				System.out.print(" " + info.get(i).x + " " + info.get(i).y);
			}
			System.out.println();
			
			
		}//end testCase
	}//end main

	public static void search(int[][] space, boolean[][] check, int x, int y) {
		// 행 길이 찾기
		int cnt = 0;
		int dx = x;
		while(dx < space.length && space[dx][y] != 0) {
			cnt++;
			dx++;
		}
		int sx = cnt;
		//열 길이 찾기
		cnt = 0;
		int dy = y;
		while(dy < space.length && space[x][dy] != 0) {
			cnt++;
			dy++;
		}
		int sy = cnt;
		info.add(new Square(sx, sy, sx*sy));
		
		//사각형에 대해 방문 체크 하기
		for (int i = x; i < dx; i++) {
			for (int j = y; j < dy; j++) {
				check[i][j] = true;
			}
		}
		
	}
	
	static class Square implements Comparable<Square>{
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
			//크기를 기준으로 정렬, 크기가 같다면 행길이 기준으로 정렬
			if(this.size == o.size) {
				return this.x - o.x;
			}
			return this.size - o.size;
		}
	}

}//end class
