package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2283_RGB마을_홍휘진 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [][]color = new int[n][3];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				color[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int [][]d = new int[n][3];
		d[0] = color[0];
		for (int i = 1; i < n; i++) {
			d[i][0] = Math.min(d[i-1][1], d[i-1][2]) + color[i][0];
			d[i][1] = Math.min(d[i-1][0], d[i-1][2]) + color[i][1];
			d[i][2] = Math.min(d[i-1][0], d[i-1][1]) + color[i][2];
		}
		System.out.println(Math.min(d[n-1][0], Math.min(d[n-1][1], d[n-1][2])));
		
	}
}
