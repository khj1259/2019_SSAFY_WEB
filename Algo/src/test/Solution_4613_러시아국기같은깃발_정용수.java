package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_4613_러시아국기같은깃발_정용수 {
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= testcase; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] count = new int[N][3];
			for(int i = 0; i<N; i++) {
				String str = br.readLine();
				for(int j = 0; j<M; j++) {
					if(str.charAt(j) == 'W') {
						count[i][0]++;
					} else if(str.charAt(j) == 'B') {
						count[i][1]++;
					} else if(str.charAt(j) == 'R') {
						count[i][2]++;
					}
				}
			}
			int result = Integer.MAX_VALUE;;
			for(int i = 1; i<N-1; i++) {
				for (int index = 1; index <N-i; index++) {
					int cnt = 0;
					for(int j = 1; j<index; j++) {
						cnt += count[j][1]+count[j][2];  
					}
					for(int j = index; j<index+i; j++) {
						cnt += count[j][0]+count[j][2];
					}
					for(int j = i+index; j<N-1; j++) {
						cnt += count[j][0]+count[j][1];
					}
					if(result > cnt) result = cnt;
					
					cnt = 0;
				}
				
			}
			result += count[0][1]+count[0][2];
			result += count[N-1][0]+count[N-1][1];
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
	
	
}
