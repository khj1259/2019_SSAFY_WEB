package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1350_최대신장트리_정용수 {
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		for(int i = 0; i<N+1; i++) {
			arr[i] =i;
		}
		edge[] earr = new edge[M];
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			earr[i] = new edge(a, b, c);
		}
		
		Arrays.sort(earr);
		int result = 0;
		for(int i = 0; i<M; i++) {
			int a = findset(earr[i].i);
			int b = findset(earr[i].j);
			if(a != b) {
				arr[a] = b;
				result += earr[i].w;
			}
		}
		
		System.out.println(result);
		
	}
	
	static class edge implements Comparable<edge> {
		int i, j, w;

		public edge(int i, int j, int w) {
			super();
			this.i = i;
			this.j = j;
			this.w = w;
		}
		
		@Override
		public int compareTo(edge o) {
			return o.w - this.w;
		}
		
	}
	
	static int findset(int x) {
		if(arr[x] == x) {
			return x;
		} else {
			arr[x] = findset(arr[x]);
			return arr[x];
		}
	}
	
	static void union(int x, int y) {
		int a = findset(x);
		int b = findset(y);
		
		arr[a] = b;
	}
	
}
