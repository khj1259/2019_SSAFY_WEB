package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//이거는 예전에 했던거 물건 하나씩만 넣을 수 있는거!!
public class Main_1077_배낭채우기1_김현정 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 보석의 가지수
		int W = Integer.parseInt(st.nextToken()); // 배낭의 용량

		int[][] k = new int[N + 1][W + 1];

		int[] weight = new int[N+1];
		int[] value = new int[N+1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int wi = Integer.parseInt(st.nextToken());
			int pi = Integer.parseInt(st.nextToken());
			weight[i] = wi;
			value[i] = pi;
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= W; j++) {
				if (weight[i] > j)
					k[i][j] = k[i - 1][j];
				else
					k[i][j] = Math.max(k[i - 1][j - weight[i]] + value[i], k[i - 1][j]);
			}
		}
		
		for (int i = 0; i <= N; i++) {
			System.out.println(Arrays.toString(k[i]));
		}
		
		System.out.println(k[N][W]);

	}

}
