package homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 정올_1082_화염에서탈출_조동희 {
	static int n,m;
	static int[][] arr;
	static Pair[] q,fire;
 	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n+2][m+2];
		q = new Pair[n*m+1];
		fire = new Pair[n*m];
		
		int front = 0,rear = 0;
		int front2 = 0,rear2 = 0;
		for(int i=1;i<=n;i++) {
			String t = br.readLine();
			for(int j=1;j<=m;j++) {
				arr[i][j] = t.charAt(j-1);
				// 불 저장
				if(arr[i][j]=='*') {
					fire[++rear2] = new Pair(i, j,0);
				}else if(arr[i][j]=='S') {
					q[++rear] = new Pair(i, j,0);
				}
			}
		}
		
		while(front<rear) {
			// 불 상하좌우 옮기기
			int size = rear2-front2;
			for(int i=0;i<size;i++) {
				Pair f = fire[++front2];
				if(arr[f.x+1][f.y]=='.'||arr[f.x+1][f.y]=='S') {
					arr[f.x+1][f.y]='*';
					fire[++rear2] = new Pair(f.x+1, f.y,0);
				}
				if(arr[f.x-1][f.y]=='.'||arr[f.x-1][f.y]=='S') {
					arr[f.x-1][f.y]='*';
					fire[++rear2] = new Pair(f.x-1, f.y,0);
				}
				if(arr[f.x][f.y+1]=='.'||arr[f.x][f.y+1]=='S') {
					arr[f.x][f.y+1]='*';
					fire[++rear2] = new Pair(f.x,f.y+1,0);
				}
				if(arr[f.x][f.y-1]=='.'||arr[f.x][f.y-1]=='S') {
					arr[f.x][f.y-1] = '*';
					fire[++rear2] = new Pair(f.x,f.y-1,0);
				}
			}
			int size2 = rear-front;
			for(int i=0;i<size2;i++) {
				Pair t = q[++front];
				if(arr[t.x][t.y]=='D') {
					System.out.println(t.cnt);
					return;
				}
				
				// 용사 이동
				if(arr[t.x+1][t.y]=='.'||arr[t.x+1][t.y]=='D') {
					if(arr[t.x+1][t.y]=='D') {
						System.out.println(t.cnt+1);
						return;
					}
					arr[t.x+1][t.y]= 'S';
					q[++rear] = new Pair(t.x+1, t.y,t.cnt+1);
				}
				if(arr[t.x-1][t.y]=='.'||arr[t.x-1][t.y]=='D') {
					if(arr[t.x-1][t.y]=='D') {
						System.out.println(t.cnt+1);
						return;
					}
					arr[t.x-1][t.y]= 'S';
					q[++rear] = new Pair(t.x-1,t.y,t.cnt+1);
				}
				if(arr[t.x][t.y+1]=='.'||arr[t.x][t.y+1]=='D') {
					if(arr[t.x][t.y+1]=='D') {
						System.out.println(t.cnt+1);
						return;
					}
					arr[t.x][t.y+1]='S';
					q[++rear] = new Pair(t.x, t.y+1, t.cnt+1);
				}
				if(arr[t.x][t.y-1]=='.'||arr[t.x][t.y-1]=='D') {
					if(arr[t.x][t.y-1]=='D') {
						System.out.println(t.cnt+1);
						return;
					}
					arr[t.x][t.y-1]='S';
					q[++rear] = new Pair(t.x, t.y-1, t.cnt+1);
				}
			}
			
		}// end of while
		System.out.println("impossible");		
		
	}// end of main
 	
 	static class Pair{
 		int x,y,cnt;
		public Pair(int x, int y,int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
 	}
} // end of class