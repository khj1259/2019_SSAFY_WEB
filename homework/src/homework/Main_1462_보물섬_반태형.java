import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static String[] a;
	static int n,m;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ans=0;
		n=sc.nextInt();m=sc.nextInt();
		a = new String[n];
		for(int i=0;i<n;++i) a[i]=sc.next();
		for(int i=0;i<n;++i) {
			for(int j=0;j<m;++j) {
				if(a[i].charAt(j)=='L') {
					int temp=bfs(i,j);
					if(ans<temp) ans=temp;
				}
			}
		}
		System.out.println(ans-1);
	}

	public static int bfs(int sx, int sy) {
		int[][] d = new int[n][m];
		int cnt=0; d[sx][sy]=1;
		int[] dx = {0,0,-1,1};
		int[] dy = {-1,1,0,0};
		Queue<Integer> qx = new LinkedList<>();
		Queue<Integer> qy = new LinkedList<>();
		qx.add(sx); qy.add(sy);
		while(!qx.isEmpty()) {
			int x=qx.peek();
			int y=qy.peek();
			qx.poll(); qy.poll();
			cnt=d[x][y];
			for(int dir=0;dir<4;++dir) {
				int nx=x+dx[dir];
				int ny=y+dy[dir];
				if(nx>=0&&nx<n&&ny>=0&&ny<m&&d[nx][ny]==0&&a[nx].charAt(ny)=='L') {
					qx.add(nx);qy.add(ny);
					d[nx][ny]=d[x][y]+1;
				}
			}
		}
		return cnt;
	}
}
