package homework;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1082_화염에서탈출_반태형 {
	static String[] a;
	static int n,m;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();m=sc.nextInt();
		int sx=-1,sy=-1,ex=-1,ey=-1;
		Queue<Integer> qx = new LinkedList<>();
		Queue<Integer> qy = new LinkedList<>();
		Queue<Integer> waterqx = new LinkedList<>();
		Queue<Integer> waterqy = new LinkedList<>();
		int[][] d = new int[n][m];
		String[] a=new String[n];
		for(int i=0;i<n;++i) {
			a[i]=sc.next();
			for(int j=0;j<m;++j) {
				if(a[i].charAt(j)=='D') {
					ex=i;
					ey=j;
				}
				else if(a[i].charAt(j)=='S') {
					sx=i;
					sy=j;
					qx.add(i);
					qy.add(j);
					a[i]=a[i].substring(0, j)+'.'+a[i].substring(j+1);
				}
				else if(a[i].charAt(j)=='*') {
					waterqx.add(i);
					waterqy.add(j);
				}
			}
		}
		d[sx][sy]=1;
		int[] dx = {0,0,-1,1};
		int[] dy = {-1,1,0,0};
		while(!qx.isEmpty()||!waterqx.isEmpty()) {
			int k=waterqx.size();
			while(k-->0) {
				int x=waterqx.poll();
				int y=waterqy.poll();
				for(int dir=0;dir<4;++dir) {
					int nx=x+dx[dir];
					int ny=y+dy[dir];
					if(nx>=0&&nx<n&&ny>=0&&ny<m) {
						if(a[nx].charAt(ny)=='.') {
							a[nx]=a[nx].substring(0, ny)+'*'+a[nx].substring(ny+1);
							waterqx.add(nx);
							waterqy.add(ny);
						}
					}
				}
			}
			k=qx.size();
			while(k-->0) {
				int x=qx.poll();
				int y=qy.poll();
				for(int dir=0;dir<4;++dir) {
					int nx=x+dx[dir];
					int ny=y+dy[dir];
					if(nx>=0&&nx<n&&ny>=0&&ny<m) {
						if((a[nx].charAt(ny)=='.'||a[nx].charAt(ny)=='D') && d[nx][ny]==0) {
							d[nx][ny]=d[x][y]+1;
							qx.add(nx);
							qy.add(ny);
						}
					}
				}
			}
		}
		if(d[ex][ey]>0) System.out.println(d[ex][ey]-1);
		else System.out.println("impossible");
		
	}

	
}
