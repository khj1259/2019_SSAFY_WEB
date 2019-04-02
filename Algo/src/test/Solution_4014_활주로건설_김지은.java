package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_4014_활주로건설_김지은 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= TC; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); // 6 <= N <= 20
			int X = Integer.parseInt(st.nextToken()); // 2 <= X <= 4
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int cntFlat = 1, cnt = 0;

			for (int i = 0; i < N; i++) {
				boolean canMake = true, down = false;
				cntFlat = 1;
				X: for (int j = 0; j < N - 1; j++) {
					if (map[i][j] == map[i][j + 1]) {
						cntFlat++;
						if (down && cntFlat >= X) {
							canMake = true;
							down = false;
							cntFlat = 0;
						}
					} else if (map[i][j] < map[i][j + 1]) {
						if (map[i][j + 1] - map[i][j] == 1) {
							if (cntFlat >= X) {
								canMake = true;
								cntFlat = 1;
							} else {
								canMake = false;
								cntFlat = 1;
								break X;
							}
						} else {
							canMake = false;
							cntFlat = 1;
							break X;
						}
					} else if (map[i][j] > map[i][j + 1]) {
						if (map[i][j] - map[i][j + 1] == 1) {
							if (down) {
								canMake = false;
								cntFlat = 1;
								break X;
							}
							cntFlat = 1;
							down = true;
						} else {
							canMake = false;
							cntFlat = 1;
							break X;
						}
					}
				}
				if (down) {
					canMake = false;
				}
				if (canMake) {
					cnt++;
				}
			}

			for (int j = 0; j < N; j++) {
				boolean canMake = true, down = false;
				cntFlat = 1;
				X: for (int i = 0; i < N - 1; i++) {
					if (map[i][j] == map[i + 1][j]) { // 평지인 경우
						cntFlat++;
						if (down && cntFlat >= X) { // 내려와서 평지일 때, 경사로의 길이가 충족되면 경사로 설치 가능
							canMake = true;
							down = false;
							cntFlat = 0;
						}
					} else if (map[i][j] < map[i + 1][j]) { // 올라가는 경우
						if (map[i + 1][j] - map[i][j] == 1) { // 한 계단 위
							if (cntFlat >= X) { // 경사로의 길이가 충족되면 경사로 설치 가능
								canMake = true;
								cntFlat = 1;
							} else { // 경사로 설치 불가, 활주로 건설 불가
								canMake = false;
								cntFlat = 1;
								break X;
							}
						} else { // 두 계단 차이면 활주로 건설 불가
							canMake = false;
							cntFlat = 1;
							break X;
						}
					} else if (map[i][j] > map[i + 1][j]) { // 내려가는 경우
						if (map[i][j] - map[i + 1][j] == 1) { // 한 계단 아래
							if (down) { // 연속되어 내려가는 경우, 활주로 설치 불가
								canMake = false;
								cntFlat = 1;
								break X;
							}
							cntFlat = 1;
							down = true;
						} else { // 두 계단 차이면 활주로 건설 불가
							canMake = false;
							cntFlat = 1;
							break X;
						}
					}
				}
				if (down) {
					canMake = false;
				}
				if (canMake) {
					cnt++;
				}
			}
			System.out.println("#" + testCase + " " + cnt);
		} // end of for testCase
	} // end of class
} // end of main
