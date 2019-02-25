package test;

import java.util.Arrays;
import java.util.Scanner;
/*
 * Greedy (탐욕기법):
 * 1. 각 방앞의 복도를 배열로 만든 뒤, 
 * 2. 학생이 이동하는 동선의 배열칸을 1씩 증가시킨다.
 * 3. 배열의 각 칸의 크기 중 최대값이 학생이동시 필요한 최소 단위시간
 */
public class Solution_4408 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			int N = sc.nextInt();
			
			// 복도배열 : 1번 2번방 -> index 0, 399번 400번방 -> index 199
			int[] room = new int[200]; //복도
			
			for(int i=0; i<N; i++) {
				//입력받은 방번호 -> 복도배열의 인덱스로 변환 작업
				int x = (sc.nextInt()-1)/2;// 현재 방번호
				int y = (sc.nextInt()-1)/2;// 돌아갈 방번호
				
				// x가 더 클수도 있고, y가 더 클 수도 있다.
				if(x > y) { // x가 y보다 작거나 같도록 swap
					int tmp = x;
					x = y;
					y = tmp;
				}
				//x2 = Math.min(a,b);
				//y2 = Math.max(a,b);
				
				for(int j = x; j <= y; j++) {
					//지나가는 복도 배열 인덱스 증가
					room[j]++;
				}
				
			}
			//복도번호배열 정렬 - 제일 마지막이 가장 큰 수
			Arrays.sort(room);
			
			System.out.println("#"+tc+" "+room[199]);
		}//end testCase
		
	}//end main
}//end class
