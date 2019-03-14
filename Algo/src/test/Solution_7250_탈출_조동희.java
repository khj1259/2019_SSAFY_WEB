package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7250_탈출_조동희 {
	static int n,m,k,sx,sy,vx,vy,front,rear;
	static int[][] arr;
	static boolean[][] visited,visited2;
	static Pair[] q = new Pair[1000001];
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		visited = new boolean[1001][1001];
		visited2 = new boolean[1001][1001];
xx:		for(int z=1;z<=tc;z++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken()); // 행
			m = Integer.parseInt(st.nextToken()); // 열
			k = Integer.parseInt(st.nextToken()); // 몸 줄이는 시간
			arr = new int[n+2][m+2];
			// 벽을 쏘다니는 스캇과 불속을 다니는 악당을 위한 방문 배열
			// q변수 초기화
			front = 0; rear = 0;
			sx = 0; sy = 0;
			vx = 0; vy = 0;
			for(int i=1;i<=n;i++) {
				String t = br.readLine();
				for(int j=0,k=1;j<m;j++,k++) {
					arr[i][k] = t.charAt(j);
					visited[i][k] = false;
					visited2[i][k] = false;
					if(t.charAt(j)=='S') { // 스캇
						sx = i; sy = k;
					}else if(t.charAt(j)=='F') { // 번지는 불
						q[++rear] = new Pair(i,k,0,0,'F');
					}else if(t.charAt(j)=='V') { // 악당
						vx = i; vy = k;
					}
				}
			}
			
			// 스캇, 악당 넣어주기, 악당이 먼저 도착하면 끝나도록 악당먼저
			if(vx!=0&&vy!=0) {
				q[++rear] = new Pair(vx,vy,0,0,'V');
				visited2[vx][vy] = true;
			}
			q[++rear] = new Pair(sx, sy, 0,k,'S');
			visited[sx][sy] = true;
			sb.append('#').append(z).append(' ');
			while(front<rear) {
				int size = rear - front;
				for(int k=0;k<size;k++) {
					Pair t = q[++front];
					// 악당과 스캇중 출구에 도착하면
					if(arr[t.x][t.y]=='E') {
						// 악당이 먼저
						if(t.who=='V') {
							sb.append(-1).append('\n');
							continue xx;
						}else {
							sb.append(t.cnt).append('\n');
							continue xx;
						}
					}
					for(int i=0;i<4;i++) {
						int tx = t.x+dx[i];
						int ty = t.y+dy[i];
						if(arr[tx][ty]=='X'||arr[tx][ty]==0) continue;
						if(t.who=='F') fire(tx,ty);
						else if(t.who=='V') akdang(tx,ty);
						else if(t.who=='S') skat(tx,ty,t.k,t.cnt);
					}
				}// end of size				
			}// end of while
		}// end of tc
		System.out.println(sb);
	}// end of main
	
	public static void skat(int x, int y,int kk,int cnt) {
		// 스캇
		// 출발점 S 부터 시작해서 W는 K 만큼 통과 가능
		if(visited[x][y]||arr[x][y]=='F') return;
		// 움직일 공간이 W라면 k를 쓰고 지나가자
		if(arr[x][y]=='W') {
			if(kk>=1)
				q[++rear] = new Pair(x, y, cnt+1,kk-1,'S');
		}else{
			// 그냥 길이면 그냥 보내자(k 초기화)
			q[++rear] = new Pair(x, y, cnt+1,k,'S');
			visited[x][y] = true;
		}
	}

	public static void akdang(int x, int y) {
		// 악당
		// 출발점 V 부터 시작해서 A와 F(불) 통과 가능
		if(visited2[x][y]||arr[x][y]=='W') return;
		// X 빼고는 다 지나갈 수 있다.
		q[++rear] = new Pair(x, y, 0, 0, 'V');
		visited2[x][y] = true;
	}

	public static void fire(int x,int y) {
		// 불 W,X에는 불이 안붙는다.
		// 그 외에는 옮겨 붙는다.
		if(arr[x][y]=='W'||arr[x][y]=='F'||arr[x][y]=='E') return;
		arr[x][y] = 'F';
		q[++rear] = new Pair(x, y, 0, 0, 'F');
	}
	
	static class Pair{
		int x,y,cnt,k,who;
		public Pair(int x, int y, int cnt, int k,int who) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.k = k;
			this.who = who;
		}
	}
}// end of class