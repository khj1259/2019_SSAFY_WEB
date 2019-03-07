package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 지렁이의 개수는 짝수개, 둘씩 짝을 지어준다
 * 짝을 지어주는 모든 경우의 수를 생각해본다
 * 	각각의 짝으로 만드는 벡터를 구함 -> 벡터들의 전체 합 구함 -> 벡터 전체 합의 크기를 구함  => 크기의 최소값을 찾기
 * 
 * 	전체 벡터의 합 = 출발위치의 지렁이 좌표합 - 도착위치의 지렁이 좌표합
 * 		출발위치끼리는 변경되어도 전체 벡터의 합은 동일
 * 		도착위치끼리는 변경되어도 전체 벡터의 합은 동일
 * 	결국, 출발위치의 그룹, 도착위치의 그룹 으로 분할하는 문제 = 출발위치에 올수 있는 N/2마리의 지렁이를 찾는 조합문제
 * 	1번 방법 : 196 ms, 선택한 지렁이를 tr 배열에 저장해놓고, 조합이 완성되면 처음부터 덧셈한다
 *  2번 방법 : 160 ms, 지렁이 한마리 선택할 때마다 덧셈을 한 결과를 매개변수로 가지고 다닌다
 */
public class Solution_1494_사랑의카운슬러_서민규 {
	public static int[][] m; // 지렁이의 좌표를 저장할 배열
//	public static int[][] tr; // 선택한 지렁이
	public static long min; // 벡터 크기의 최소값
	public static int sumX, sumY; // 전체 X, Y좌표의 합
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= TC; testCase++) {
			int N = Integer.parseInt(br.readLine()); // 지렁이의 개수, 2 <= N <= 20, N은 짝수
			m = new int[N][2]; // 지렁이 좌표를 저장할 배열
			sumX = sumY = 0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken()); // -100,000 <= x, y <= 100,000
				int y = Integer.parseInt(st.nextToken());
				m[i][0] = x;
				m[i][1] = y;
				sumX += x;
				sumY += y;
			}
//			tr = new int[N/2][2]; // 선택한 지렁이를 저장할 배열
			min = Long.MAX_VALUE; // 벡터의 최소값 저장할 변수 초기화
			comb(N, N/2, 0, 0);
			
			System.out.println("#"+testCase+" "+min);
		} // end of for testCase
	} // end of main
	/** 조합                                           (n, c, 현재까지 선택한 지렁이의 x좌표합, y좌표합) */
	public static void comb(int n, int r, int sX, int sY) {
		if (n < r) {
			return;
		} else if (r == 0) { // 하나의 조합이 완성됨
			int sumUnselectX = sumX - sX; // 선택하지 않은 지렁이들의 x좌표합
			int sumUnselectY = sumY - sY;
			long vX = sX - sumUnselectX;
			long vY = sY - sumUnselectY;
			long v = vX * vX + vY * vY;
			if (min > v) min = v;
		} else {
			comb(n-1, r-1, sX+m[n-1][0], sY+m[n-1][1]); // 선택한 경우
			comb(n-1, r, sX, sY); // 선택하지 않은 경우
		}
	}
} // end of class
























