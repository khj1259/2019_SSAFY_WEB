package homework;

import java.util.LinkedList;
import java.util.Scanner;

public class Main_1082_화염에서탈출_김현정 {
	public static boolean[][] visit;
	//public static int R,C;
	public static String[][] map;
	public static int[] row = {0,0,1,-1};
	public static int[] col = {1,-1,0,0}; //우좌하상
	static class Coord{
		int r, c;
		int dist;
		Coord(int r,int c, int dist){
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] rc = sc.nextLine().split(" ");
		int R = Integer.parseInt(rc[0]); //행
		int C = Integer.parseInt(rc[1]); //열
		visit = new boolean[R][C];
		map = new String[R][C];
		int sx=0, sy=0; //시작점
		int dx=0, dy=0; //도착점(집)
		int fx=0, fy=0; //불
		for (int i = 0; i < R; i++) {
			map[i]=sc.nextLine().split("");
			for(int j=0; j<map[i].length; j++) {
				if(map[i][j].equals("S")) {
					sx = i;
					sy = j;
				}
				if(map[i][j].equals("D")) {
					dx = i;
					dy = j;
				}
				if(map[i][j].equals("*")) {
					fx = i;
					fy = j;
				}
			}
		}
		System.out.println(sx+" "+sy);
		System.out.println(dx+" "+dy);
		System.out.println(fx+" "+fy);
		LinkedList<Coord> q = new LinkedList<Coord>();
		q.add(new Coord(sx, sy, 0));
		visit[sx][sy] = true;
		
		int min = 0;
		while(!q.isEmpty()) {
			Coord temp = q.getFirst();
			q.pop();
			for (int k = 0; k < 4; k++) {
				int rr = temp.r + row[k];
				int cc = temp.c + col[k];
				if(rr>=R||cc>=C||rr<0||cc<0) continue;
				//불 상하좌우 옮김
				if(fx-1 >= 0) map[fx-1][fy] = "*";
				if(fx+1 < R) map[fx+1][fy] = "*";
				if(fy-1 >= 0) map[fx][fy-1] = "*";
				if(fy+1 < C) map[fx][fy+1] = "*";
				if(!visit[rr][cc]) {
					if(map[rr][cc].equals("D")) {
						q.add(new Coord(rr,cc,temp.dist+1));	
						visit[rr][cc]=true;
						break;
					}
					if(map[rr][cc].equals(".")) {
						q.add(new Coord(rr,cc,temp.dist+1));	
						visit[rr][cc]=true;
					}
				}
			}
			if(min>temp.dist) {
				min=temp.dist;
			}
		}
		
		System.out.println(min);
			
	}//end main
}//end class
