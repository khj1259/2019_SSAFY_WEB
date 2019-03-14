package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1238_SW문제해결기본10일차_Contact_김현정 {
	private static boolean[] visit;
	private static int[][] m;
	private static int N;
	private static Queue<Integer> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc = 1; tc <= 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 입력받을 데이터 개수
			int start =Integer.parseInt(st.nextToken()); // 시작 정점
			m = new int[101][101];
			visit = new boolean[101];
			q = new LinkedList<>();
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<N/2; i++) {
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				m[r][c] = 1;
			} // 인접행렬 만들기
			
			
			int answer = go(start); // BFS
			System.out.println("#"+tc+" "+answer);
		}//end testCase
	}//end main

	public static int go(int v) {
		int i;
		visit[v] = true;
		q.offer(v);
		int max = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			max = 0;
			for(int j = 0; j < size; j++) { // 동시에 진행하기 위해
				int n = q.poll();
				
				for(i=1; i<=100; i++) {
					if(m[n][i]==1 && !visit[i]) {
						visit[i] = true;
						q.offer(i);
					}
				}
				if(max < n) {
					max = n;
				}
			}
		}
		
		return max;
	}
}//end class
