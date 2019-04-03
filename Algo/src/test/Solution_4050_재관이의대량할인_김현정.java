package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_4050_재관이의대량할인_김현정 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine().trim());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] price = new int[N];
			for(int i = 0; i < N; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			//입력 끝
			
			Arrays.sort(price);
			int sum = 0;
			int cnt = 0;
			for(int i = price.length-1; i >= 0; i--) {
				cnt++;
				if(cnt%3 == 0) {
					continue;
				}else {
					sum += price[i];
				}
			}
			
			System.out.println("#"+tc+" "+sum);
		}//end testCase
	}//end main
}//end class
