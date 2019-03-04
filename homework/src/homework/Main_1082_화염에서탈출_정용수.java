package homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1082_화염에서탈출_정용수 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		List<data> man = new ArrayList<>();
		List<data> man2 = new ArrayList<>();
		List<data> fire = new ArrayList<>();
		List<data> fire2 = new ArrayList<>();
		char[][] map = new char[R+2][C+2];
		int endi = 0;
		int endj = 0;
		for(int i = 1; i<=R; i++) {
			String str = br.readLine();
			for(int j = 0; j<C; j++) {
				char ch = str.charAt(j);
				map[i][j+1] = ch;
				if(ch == 'D') {
					endi = i;
					endj = j+1;
				}
				if(ch == 'S') {
					man.add(new data(i, j+1, 0));
				}
				if(ch == '*') {
					fire.add(new data(i, j+1, 0));
				}
			}
		}
		boolean isT = false;
		int cnt = 0;
		while(true) {
			for(data f : fire) {
				if(map[f.i+1][f.j] == '.' || map[f.i+1][f.j] == 'v') {
					map[f.i+1][f.j] = '*';
					fire2.add(new data(f.i+1, f.j, f.cnt+1));
				}
				if(map[f.i][f.j+1] == '.' || map[f.i][f.j+1] == 'v') {
					map[f.i][f.j+1] = '*';
					fire2.add(new data(f.i, f.j+1, f.cnt+1));
				}
				if(map[f.i-1][f.j] == '.' || map[f.i-1][f.j] == 'v') {
					map[f.i-1][f.j] = '*';
					fire2.add(new data(f.i-1, f.j, f.cnt+1));
				}
				if(map[f.i][f.j-1] == '.' || map[f.i][f.j-1] == 'v') {
					map[f.i][f.j-1] = '*';
					fire2.add(new data(f.i, f.j-1, f.cnt+1));
				}
			}
			fire.clear();
			for(data f : fire2) {
				fire.add(new data(f.i, f.j, f.cnt));
			}
			fire2.clear();
		
			for(data f : man) {
				if(map[f.i+1][f.j] == '.') {
					map[f.i+1][f.j] = 'v';
					man2.add(new data(f.i+1, f.j, f.cnt+1));
				}
				if(map[f.i][f.j+1] == '.') {
					map[f.i][f.j+1] = 'v';
					man2.add(new data(f.i, f.j+1, f.cnt+1));
				}
				if(map[f.i-1][f.j] == '.') {
					map[f.i-1][f.j] = 'v';
					man2.add(new data(f.i-1, f.j, f.cnt+1));
				}
				if(map[f.i][f.j-1] == '.') {
					map[f.i][f.j-1] = 'v';
					man2.add(new data(f.i, f.j-1, f.cnt+1));
				}
				
				if(map[f.i+1][f.j] == 'D') {
					isT = true;
					break;
				}
				if(map[f.i][f.j+1] == 'D') {
					isT = true;
					break;
				}
				if(map[f.i-1][f.j] == 'D') {
					isT = true;
					break;
				}
				if(map[f.i][f.j-1] == 'D') {
					isT = true;
					break;
				}
			}
			
			man.clear();
			for(data f : man2) {
				man.add(new data(f.i, f.j, f.cnt));
			}
			man2.clear();
			cnt++;
			if(isT) {
				break;
			}
			
			if(cnt > R*C) {
				break;
			}
		}
		
		if(isT) {
			System.out.println(cnt);
		} else {
			System.out.println("impossible");
		}
	}
	
	static class data {
		int i; 
		int j;
		int cnt;
		
		public data(int i, int j, int cnt) {
			this.i = i;
			this.j = j;
			this.cnt = cnt;
		}
		
		
		
	}
}
