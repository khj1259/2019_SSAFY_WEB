package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_5643_Professional_키순서_서민규 {
	
	public static int[][] a;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine().trim()); // 학생 수
			int M = Integer.parseInt(br.readLine().trim()); // 비교 횟수

			a = new int[N+1][N+1]; // 인접행렬, 0번은 안씀
			for (int i = 1; i < a.length; i++) {
				a[i][0] = -1; // 큰친구목록을 저장할 변수를 사용하지 않는 숫자 -1로 초기화
			}
			
			for(int i=0; i<M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int small = Integer.parseInt(st.nextToken());
				int tall = Integer.parseInt(st.nextToken());
				a[small][tall] = 1;
			}
			
			System.out.println("재귀호출 전");
			for (int i = 1; i < a.length; i++) {
				System.out.println(Arrays.toString(a[i]));
			}
			
			for(int i=1; i<a.length; i++) {
				up(i); // 나보다 큰 애들을 순회
			}
			for (int i = 1; i < a.length; i++) {
				for (int j = 1; j < a.length; j++) { // 나보다 작은 애들의 숫자를 카운팅, 0번행에 저장
					a[0][i] += a[j][i]; // 진입차수
				}
			}
			
			System.out.println("재귀호출 후");
			for (int i = 0; i < a.length; i++) {
				System.out.println(Arrays.toString(a[i]));
			}
			
			int cnt = 0; // 관계를 알 수 있는 사람들 수
			for (int i = 1; i < a.length; i++) {
				if(a[0][i] + a[i][0] == N-1) {
					cnt++;
				}
			}
			
			System.out.println("#"+tc+" "+cnt);
		} // end testCase

	}// end main

	/** v 정점에 대해서 인접한 큰 친구들을 탐색, 나보다 큰 친구가 가지고 있는 큰친구목록을 나의 인접행렬에 추가등록*/
	public static void up(int v) {
		if(a[v][0] != -1) { // 방문했던 정점이면, 이미 큰 친구목록을 구해서 저장한 상태이므로 가지치기
			return;
		}
		
		for (int i = 1; i < a.length; i++) {
			if(a[v][i] == 1) { // 인접한 정점이면
				up(i); // 재귀 호출
				for (int j = 1; j < a.length; j++) { // i의 큰 친구목록을 v의 큰 친구목록에 업데이트
					a[v][j] = a[i][j] == 1? 1 : a[v][j];
				}
			}
		}
		int sum = 0; // v 정점보다 큰 친구들의 숫자를 셈
		for (int i = 1; i < a.length; i++) {
			sum += a[v][i];
		}
		a[v][0] = sum; //인접행렬의 0번째 칸을 사용
	}
	
	
}// end class
