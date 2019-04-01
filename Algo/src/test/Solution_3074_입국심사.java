package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3074_입국심사 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine().trim());
		for(int testCase = 1; testCase <= TC; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); // 심사대 개수
			int M = Integer.parseInt(st.nextToken()); // 사람 수
			int[] t = new int[N]; // 각 심사대에서 소요되는 시간
			for (int i = 0; i < N; i++) {
				t[i] = Integer.parseInt(br.readLine().trim());
			}
			
			//소요시간의 범위 : 0~ 10^18
			long start = 0;
			long end = 100000000L * M;
			long min = Long.MAX_VALUE; // M명이 입국심사할 때 필요한 소요시간의 최소값
			while(start <= end) {
				long mid = (start + end) / 2;
				
				// 입국심사대에 통과하는 인원을 구하기
				long cnt = 0; // mid 시간동안 심사대를 통과한 인원
				for (int i = 0; i < N; i++) {
					cnt += mid / t[i];
				}
				// M명, cnt명을 비교해서 범위를 재조정
				if(cnt < M) {
					start = mid + 1;
				}else if(M <= cnt) { // M == cnt 경우에도 시간을 더 줄여서 다시 확인한다.
					if(min > mid) {
						min = mid;
					}
					end = mid - 1;
				}
			}
			System.out.println("#"+testCase+" "+min);
		}
	}//end main
}//end class
