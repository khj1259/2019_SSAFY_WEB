package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7208_지도칠하기_김현정 {
	private static int N;
	private static int[] color;
	private static int[][] map;
	private static int min;
	private static int[] nc;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			color = new int[N]; // 나라별 초기 색상
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				color[j] = Integer.parseInt(st.nextToken());
			}
			
			map = new int[N][N]; //인접행렬
			for(int i=0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			min = Integer.MAX_VALUE; // 최소 변경량
			nc = new int[N]; // 새로 칠한 각 나라의 색상 -> 원본과 비교해서 몇개가 다른지 구할것임
			DFS(0, 0);
			
			System.out.println("#"+tc+" "+min);
		}//end testCase
	}//end main

	/** 현재 step 단계의 나라색상을 채우기, 재귀호출, cnt: 현재 단계까지 오면서 색상을 바꾼 나라의 개수 */
	public static void DFS(int step, int cnt) {
		if(step == N) { // 종료조건
			if(min > cnt) {
				min = cnt;
			}
		}else { // 반복조건
			//현재 step 단계의 나라를 모든 색깔로 칠하고 재귀호출
go:			for (int i = 1; i <= 4; i++) { // 색깔 4가지 종류 1~4
				nc[step] = i;
				// 인접한 국가와 색상이 다른 경우만 진행
				for (int j = 0; j < step; j++) { // 현재국가 이전에 칠한 나라들의 색상과 비교
					if(map[step][j] == 1 && nc[j] == i) { // step 나라 색상이 인접한 나라 색상과 같으면
						continue go;
					}
				}
				
				if(color[step] != nc[step]) { //현재 선택한 나라의 색상이 초기 색상과 비교해서 변경량을 보냄
					// min > cnt+1 만 진행하자
					if(min > cnt + 1) { // 가지치기
						DFS(step + 1, cnt + 1);
					}
				} else {
					DFS(step + 1, cnt);
				}
			}
		}
	}//end DFS()
	
}//end class
