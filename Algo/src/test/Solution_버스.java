package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * BFS => 호출상태를 콜스택에 많이 쌓아야 함, 메모리를 낭비
 * DFS : 메모리는 BFS에 비해서 절약되지만, 많은 중복호출이 발생
 * 메모이제이션
 */
public class Solution_버스 {
	private static int N;
	private static int[][] m;
	private static int[][][] memo;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		
		long time = System.currentTimeMillis();
		for(int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine().trim());
			m = new int[N+1][N+1]; // 오른쪽, 하단에 한줄씩 여백 안씀
			
			for(int i = 0; i < m.length; i++) {
				m[i][N] = 1;
				m[N][i] = 1;
			}
			
			for(int i=0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < N; j++) {
					m[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			memo = new int[N][N][3]; // 행, 열, mode, 계산한 경로의 개수를 저장할 배열
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < 3; k++) {
						memo[i][j][k] = -1; // 계산했었는지 안했는지 구분하기 위해 
					}
				}
			}//초기화
			
			int cnt = 0 ; // 경로의 개수
			if(m[0][0] == 0 && m[0][1] ==0) { // 가로로 시작
				cnt += gogosing(0, 0, 0);
			}
			if(m[0][0] == 0 && m[1][0] ==0) { // 세로로 시작
				cnt += gogosing(0, 0, 2);
			}
			System.out.println("#"+testCase+" "+cnt);
		}//end testCase
		System.out.println(System.currentTimeMillis() - time + "ms");
	}//end main
	
	/** 현재 좌표에서 도착지까지 갈수있는 경로의 수를 리턴하는 메서드 
	 *  r행, c열, mode방향 - 0:가로, 1:대각, 2:세로,   (r,c)버스의 꼬리좌표*/
	public static int gogosing(int r, int c, int mode) {
		if(memo[r][c][mode] != -1) { // 호출해서 저장한 적이 있으면, 저장한 값을 사용해라
			return memo[r][c][mode];
		}
		
		int cnt = 0; // 현재 좌표에서 도착지까지 갈 수 있는 경로의 수
		if(mode == 0) { // 0가로
			if(r == N-1 && c+1 == N-1) { // 도착했냐?
				return 1;
			} else {// 도착하지 않았다면 재귀호출
				if(m[r][c+2] == 0) { // 가로 -> 가로
					cnt += gogosing(r, c+1, 0);
				}
				if(m[r][c+2] == 0 && m[r+1][c+2] == 0 && m[r+1][c+1] == 0) { // 가로 -> 대각
					cnt += gogosing(r, c+1, 1);
				}
			}
		} else if(mode == 1) { // 1대각
			//재귀호출
			if(m[r+1][c+2] == 0) { // 대각 -> 가로
				cnt += gogosing(r+1, c+1, 0);
			}
			if(m[r+1][c+2] == 0 && m[r+2][c+1] == 0 && m[r+2][c+2] == 0) { // 대각 -> 대각
				cnt += gogosing(r+1, c+1, 1);
			}
			if(m[r+2][c+1] == 0) { // 대각 -> 세로
				cnt += gogosing(r+1, c+1, 2);
			}
		}else { // 2세로
			if(r+1 == N-1 && c == N-1) {// 도착했냐?
				return 1;
			} else {// 도착하지 않았다면 재귀호출
				if(m[r+1][c+1] == 0 && m[r+2][c] == 0 && m[r+2][c+1] == 0) { // 세로->대각
					cnt += gogosing(r+1, c, 1);
				}
				if(m[r+2][c] == 0) { // 세로 -> 세로
					cnt += gogosing(r+1, c, 2);
				}
			}
		}
		memo[r][c][mode] = cnt;
		
		return cnt;
	}// end gogosing()
}//end class

