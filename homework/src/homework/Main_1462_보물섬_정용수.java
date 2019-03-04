package homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1462_보물섬_정용수 {
	
	public static int max;
	public static char[][] map;
	public static int min;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		map = new char[W+2][H+2];
		max = 0;
		for(int i = 1; i<=W; i++) {
			String str = br.readLine();
			for(int j = 1; j<=H; j++) {
				map[i][j] = str.charAt(j-1);
			}
		}
		
		for(int i = 1; i<=W; i++) {
			for(int j = 1; j<=H; j++) {
				if(map[i][j] == 'L') {
					int path = move(i,j);
					if(max<path) max = path;
				}
			}
		}
		System.out.println(max);
	}
	
	public static int move(int i1, int j1) {
		
		Queue<man> que = new LinkedList<>();
		char[][] tmap = new char[map.length][map[0].length];
		for(int c = 0; c<tmap.length;c++) {
			tmap[c] = map[c].clone();
		}
		que.add(new man(i1, j1, 0));
		tmap[i1][j1] = 'W';
		int cnt = 0;
		while(!que.isEmpty()) {
			man m = que.poll();
			int i = m.i;
			int j = m.j;
			if(tmap[i-1][j] == 'L') {
				tmap[i-1][j] = 'W';
				que.add(new man(i-1, j, m.mcnt+1));
			}
			if(tmap[i+1][j] == 'L') {
				tmap[i+1][j] = 'W';
				que.add(new man(i+1, j, m.mcnt+1));
			}
			if(tmap[i][j+1] == 'L') {
				tmap[i][j+1] = 'W';
				que.add(new man(i, j+1, m.mcnt+1));
			}
			if(tmap[i][j-1] == 'L') {
				tmap[i][j-1] = 'W';
				que.add(new man(i, j-1, m.mcnt+1));
			}
			cnt = m.mcnt;
		}
		return cnt;
	}
	
	public static class man {
		int i, j, mcnt;
		char[][] tmap;
		public man(int i, int j, int mcnt) {
			this.i = i;
			this.j = j;
			this.mcnt = mcnt;
		}
	}
}
