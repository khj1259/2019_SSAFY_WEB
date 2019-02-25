package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1873 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상 하 좌 우
		char[] car = { '^', 'v', '<', '>' };

		int TC = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= TC; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			char[][] map = new char[H][W];

			for (int i = 0; i < H; i++) {
				map[i] = br.readLine().trim().toCharArray();
			} // 초기 상태 맵

			int[] direction = null; // 현재 방향
			int x = 0, y = 0; // 현재 좌표
			X: for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					switch (map[i][j]) {
					case '^':
						direction = dir[0];
						x = i;
						y = j;
						break X;
					case 'v':
						direction = dir[1];
						x = i;
						y = j;
						break X;
					case '<':
						direction = dir[2];
						x = i;
						y = j;
						break X;
					case '>':
						direction = dir[3];
						x = i;
						y = j;
						break X;
					}
				} // 시작 점 찾기
			}

			int N = Integer.parseInt(br.readLine().trim());
			char[] input = br.readLine().trim().toCharArray(); // 사용자 입력
			for (int i = 0; i < input.length; i++) {
				switch (input[i]) {
				case 'U': // up
					direction = dir[0];
					map[x][y] = car[0];
					if (x + direction[0] >= 0 && y + direction[1] >= 0 
							&& x + direction[0] <= map.length - 1 
							&& y + direction[1] <= map[0].length - 1) {
						if (map[x + direction[0]][y + direction[1]] == '.') {
							map[x][y] = '.';
							x += direction[0];
							y += direction[1];
							map[x][y] = car[0];
						}
					}
					break;
				case 'D': // down
					direction = dir[1];
					map[x][y] = car[1];
					if (x + direction[0] >= 0 && y + direction[1] >= 0 
							&& x + direction[0] <= map.length - 1 
							&& y + direction[1] <= map[0].length - 1) {
						if (map[x + direction[0]][y + direction[1]] == '.') {
							map[x][y] = '.';
							x += direction[0];
							y += direction[1];
							map[x][y] = car[1];
						}
					}
					break;
				case 'L': // left
					direction = dir[2];
					map[x][y] = car[2];
					if (x + direction[0] >= 0 && y + direction[1] >= 0 
							&& x + direction[0] <= map.length - 1 
							&& y + direction[1] <= map[0].length - 1) {
						if (map[x + direction[0]][y + direction[1]] == '.') {
							map[x][y] = '.';
							x += direction[0];
							y += direction[1];
							map[x][y] = car[2];
						}
					}
					break;
				case 'R': // right
					direction = dir[3];
					map[x][y] = car[3];
					if (x + direction[0] >= 0 && y + direction[1] >= 0 
							&& x + direction[0] <= map.length - 1 
							&& y + direction[1] <= map[0].length - 1) {
						if (map[x + direction[0]][y + direction[1]] == '.') {
							map[x][y] = '.';
							x += direction[0];
							y += direction[1];
							map[x][y] = car[3];
						}
					}
					break;
				case 'S': // shoot
					int xtemp = x + direction[0], ytemp = y + direction[1];
					while (xtemp >= 0 && ytemp >= 0 && xtemp < map.length && ytemp < map[0].length) {
						if (map[xtemp][ytemp] == '*') {
							map[xtemp][ytemp] = '.';
							break;
						} else if (map[xtemp][ytemp] == '#') {
							break;
						} else {
							xtemp += direction[0];
							ytemp += direction[1];
						}
					}
					break;
				}
			}
			System.out.print("#" + testCase + " ");
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		} // end of testCase
	} // end of main
} // end of class
