package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2613_토마토고 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken()); //상자의 가로칸 수
		int N = Integer.parseInt(st.nextToken()); //상자의 세로칸 수
		
		int[][] box = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		
		
	}
}
