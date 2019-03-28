package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 시작 좌표(r,c)를 정하고, 사각형의 폭(w), 높이(h)를 정한 뒤
 * 사각영역이 지역을 벗어나지 않는지 유효성 검사 후, 
 * 사각형 영역을 순회한다.
 * 디저트카페 번호를 카운팅하면서 겹치는 번호가 있는지 체크
 * 겹치는 번호가 있으면 -1을 리턴
 * 겹치는 번호가 없으면 사각형의 크기(w+h)*2르 ㄹ리턴
 * 최대 사각형 크기의 값을 출력
 */
public class Solution_2105_디저트카페_김현정 {
	private static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());//지역의 한 변 길이 4 <= N <=20
			map = new int[N][N];
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken()); // 디저트 번호, 1 <= <= 100
				}
			}
			// 입력 끝
			//(r,c) w, h 만들어서 , 사각형좌표가 지역을 벗어나지 않는지 체크, 디저트 카페 번호가 중복되지 않는지 체크, 디저트 카페 개수의 최대값
			
			int maxCnt = -1;
			for(int r = 0; r < N; r++) { // 행
				for(int c = 0; c < N; c++) { // 열
					for(int w = 1; w < N; w++) { // 폭
						for(int h = 1; h < N; h++) { // 높이
							if(r+h+w >= N || c+w >= N || c-h < 0) continue;
							
							int cnt = go(r, c, w, h); // 디저트카페 방문 개수(사각형의 크기), -1(디저트카페 번호 중복시)
							if(maxCnt < cnt) maxCnt = cnt;
						}
						
					}
					
				}
			}
			System.out.println("#"+tc+" "+maxCnt);
		}//end testCase
		
	}//end main

	public static int go(int r, int c, int w, int h) {
		boolean[] flag = new boolean[101]; //방문했는지
		
		for(int i = 0; i <= w; i++) {
			if(flag[map[r+i][c+i]]) return -1;
			flag[map[r+i][c+i]] = true;
			if(flag[map[r+h+i][c-h+i]]) return -1;
			flag[map[r+h+i][c-h+i]] = true;
		}
		
		for(int i = 0; i <= h; i++) {
			if(flag[map[r+i][c-i]]) return -1;
			flag[map[r+i][c-i]] = true;
			if(flag[map[r+w+i][c+w-i]]) return -1;
			flag[map[r+w+i][c+w-i]] = true;
		}
		// 디저트카페 번호가 중복이 없으면, 방문한 디저트카페 개수 리턴
		return (w + h) * 2;
	}
}//end class



























