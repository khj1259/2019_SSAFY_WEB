package homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main_1462_보물섬_유성종 {
	public static boolean[][] visit;
	public static int R,C;
	public static String[] map;
	public static int[] row = {0,0,1,-1};
	public static int[] col = {1,-1,0,0};
	static class Coord{
		int r, c;
		int dist;
		Coord(int r,int c, int dist){
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String[] ss = s.split(" ");
		R = Integer.parseInt(ss[0]);
		C = Integer.parseInt(ss[1]);
		visit = new boolean[R][C];
		map = new String[R];
		for (int i = 0; i < R; i++) {
			map[i]=br.readLine();
		}
		LinkedList<Coord> q = new LinkedList<Coord>(); 
		int max = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(!visit[i][j]&&map[i].charAt(j)=='L') {
					q.add(new Coord(i,j,0));
					visit[i][j]=true;
					while(!q.isEmpty()) {
						Coord temp = q.getFirst();
						q.pop();
						for (int k = 0; k < 4; k++) {
							int rr = temp.r + row[k];
							int cc = temp.c + col[k];
							if(rr>=R||cc>=C||rr<0||cc<0) continue;
							if(!visit[rr][cc]&&map[rr].charAt(cc)=='L') {
								q.add(new Coord(rr,cc,temp.dist+1));	
								visit[rr][cc]=true;
							}
						}
						if(max<temp.dist) {
							max=temp.dist;
						}
					}
				}
				clear();
			}
		}
		System.out.println(max);
	}

	public static void clear() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				visit[i][j]=false;
			}
		}
	}

}
