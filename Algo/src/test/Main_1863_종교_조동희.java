package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_1863_종교_조동희 {
	static int n,m;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n+10];
		for(int i=1;i<=n+2;i++)
			arr[i] = i;
		int result = n;
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine().trim(), " " );
			int a = findSet(Integer.parseInt(st.nextToken()));
			int b = findSet(Integer.parseInt(st.nextToken()));
			if(union(a, b)) {
				result--;
			}
		}
		//[0, 4, 3, 4, 5, 5, 6, 7, 0, 0, 0, 0, 0, 0, 0]
		//[0, 1, 1, 1, 1, 1, 6, 7, 0, 0, 0, 0, 0, 0, 0]
		System.out.println(result);
	}// end of main
	
	public static int findSet(int x) {
		if(x==arr[x]) return x;
		arr[x] = findSet(arr[x]);
		return arr[x];
	}
	
	public static boolean union(int x,int y) {
		int px = findSet(x);
		int py = findSet(y); 
		if(px!=py) {
			arr[py] = px;
			return true;
		}
		return false;
	}
	
}// end of class