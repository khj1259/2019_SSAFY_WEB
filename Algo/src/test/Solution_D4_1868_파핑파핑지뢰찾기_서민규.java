package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_D4_1868_파핑파핑지뢰찾기_서민규 {
	public static int[] dy = {-1,-1,-1, 0, 0, 1, 1, 1}; // testCase 마다 생성하지 말고, for문 밖으로 빼놓는게 좋음
	public static int[] dx = {-1, 0, 1,-1, 1,-1, 0, 1};
	public static char[][] m;
	public static int[][] cnt;
	public static boolean [][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= TC; testCase++) {
			int N = Integer.parseInt(br.readLine()); // 1 <= N <= 300
			m = new char[N+2][N+2]; // 외곽 한줄씩 빈공간 여분으로 사용하지 않음 
			for (int i = 1; i <= N; i++) {
				String s = br.readLine();
				for (int j = 1; j <= N; j++) {
					m[i][j] = s.charAt(j-1); 
				}
			}

			cnt = new int[N+2][N+2]; // 폭탄의 개수, 외곽 한줄씩 빈공간 여분으로 사용하지 않음 
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (m[i][j] == '*') {
						cnt[i][j] = '*'; // 폭탄표시 (사용하지 않는 숫자로) 
						continue;
					}
					for (int k = 0; k < dy.length; k++) {
						if (m[i+dy[k]][j+dx[k]] == '*') {
							cnt[i][j]++;
						}
					}
				}
			}
//			// 입력을 잘 받았는지 출력해보기
//			for (int i = 0; i <= N+1; i++) {
//				System.out.println(Arrays.toString(m[i]));
//			}
//			
//			for (int i = 0; i <= N+1; i++) {
//				System.out.println(Arrays.toString(cnt[i]));
//			}
			
			visited = new boolean[N+2][N+2]; // 방문 여부, 외곽 한줄씩 빈공간 여분으로 사용하지 않음 
			for (int i = 0; i < visited.length; i++) { // 외곽 넘어가지 않도록 경계 표시
				visited[0][i] = true;
				visited[N+1][i] = true;
				visited[i][0] = true;
				visited[i][N+1] = true;
			}
			int result = 0;
			// cnt[][]에서 0을 찾아서 인접한 칸까지 표시 BFS
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (visited[i][j] == false && cnt[i][j] == 0) {
						bfs(i, j);
						result++;
					}
				}
			}
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (visited[i][j] == false && m[i][j] != '*') {
						result++;
					}
				}
			}
			
			System.out.println("#"+testCase+" "+result);
		} // end of for testCase
	} // end of main
	/** cnt[r][c] 값은 0, 인접한 0과 인접한 숫자의 방문체크 */
	public static int[][] q = new int [900000][2];
	public static void bfs(int r, int c) {
		int front = -1;
		int rear = -1;
		visited[r][c] = true;
		q[++rear][0] = r; 
		q[rear][1] = c; 
		while(front != rear) { // 큐가 비어있지 않으면
			r = q[++front][0]; 
			c = q[front][1];
			// 방문작업
			for (int i = 0; i < dy.length; i++) { // 인접한 칸이 (방문안했고,) 0이 아니면, (폭탄은 방문할 필요없지만 해도 상관없음)
				if (visited[r+dy[i]][c+dx[i]] == false && cnt[r+dy[i]][c+dx[i]] > 0) {
					visited[r+dy[i]][c+dx[i]] = true;
				}
			}			
			
			for (int i = 0; i < dy.length; i++) { // 인접한 칸이 방문안했고 (, 0이면) 큐에 넣기
				if (visited[r+dy[i]][c+dx[i]] == false && cnt[r+dy[i]][c+dx[i]] == 0) {
					q[++rear][0] = r+dy[i];
					q[rear][1] = c+dx[i];
					visited[r+dy[i]][c+dx[i]] = true;
				}
			}
		}
	}
} // end of class