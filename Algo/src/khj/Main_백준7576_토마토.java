package khj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준7576_토마토 {
	static int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[][] box = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		BFS(box, N, M);
		
	}//end main
	
	public static void BFS(int[][] box, int N, int M) {
		Queue<Dot> q = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(box[i][j] == 1) {
					//익은 토마토가 있는 모든 위치를 큐에 담는다.
					q.add(new Dot(i,j));
				}
			}
		}
		
		while(!q.isEmpty()) {
			//익은 토마토의 상하좌우는 다음에 익기 때문에 큐에 담아야 한다.
			Dot dot = q.poll();
			for(int i = 0; i < 4; i++) {
				int nextX = dot.x + dx[i];
				int nextY = dot.y + dy[i];
				
				//범위 밖 패스
				if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) {
					continue;
				}
				
				//다음 위치가 익지 않은 토마토가 아니면 패스
				if(box[nextX][nextY] != 0) {
					continue;
				}
				
				//최대 일수를 구하기 때문에 1로 바꾸는 것이 아니라 현재 일수 +1을 해줘야 한다.
				box[nextX][nextY]  = box[dot.x][dot.y] + 1;
				q.add(new Dot(nextX, nextY));
			}
		}
		int max = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(box[i][j] == 0) {
					//토마토가 모두 익지 못한 상황이라면 -1을 출력
					System.out.println(-1);
					return;
				}
				max = Math.max(max, box[i][j]);
			}
		}
		//그렇지 않다면 최대값을 출력한다.
		System.out.println(max -1);
	}
	
	static class Dot{
		int x;
		int y;
		
		public Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}//end class
