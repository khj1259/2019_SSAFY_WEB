package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4301_콩많이심기_정용수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=testcase; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int result = 0;
			int a = Integer.parseInt(st.nextToken());
			int ca = a/4*2;
			if(a%4 >=2) {
				ca += 2;
			} else {
				ca += a%4;
			}
			int b = Integer.parseInt(st.nextToken());
			int cb = b/4*2;
			if(b%4 >=2) {
				cb += 2;
			} else {
				cb += b%4;
			}
			result = ca*cb + (a-ca)*(b-cb);
			System.out.println("#"+tc+" "+result);
		}
	}
}
