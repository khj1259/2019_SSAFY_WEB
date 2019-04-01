package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3289_서로소집합_김현정 {
	private static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			arr = new int[n+1]; // 부모를 저장할 배열
			for (int i = 1; i < arr.length; i++) {
				arr[i] = i;
			}
			
			String answer = "";
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int cal = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(cal == 0) {
					union(a, b);
				}else { //cal == 1
					int x = findset(a);
					int y = findset(b);
					if(x==y) {
						answer += "1";
					}else {
						answer += "0";
					}
				}
			}
			System.out.println("#"+tc+" "+answer);
		}//end testCase
	}//end main
	
	public static void union(int a, int b) {
		int x = findset(a);
		int y = findset(b);
		
		arr[x] = y;
	}
	
	public static int findset(int x) {
		if(arr[x] == x) {
			return x;
		}else {
			arr[x] = findset(arr[x]);
			return arr[x];
		}
	}
}//end class
