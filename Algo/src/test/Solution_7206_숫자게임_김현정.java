package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * AD 수준 정도로 예상
 * 숫자 사이사이를 쪼개는 방법을 바이너리카운팅을 이용, 각 쪼갠값을 곱해서 곱한 값으로 재귀호출
 * 
 * 재귀호출 (중복호출 많이 발생) -> 메모이제이션(저장) best! -> DP(작은해부터 구해서 큰해를 찾는 방법) Bottom up 방식  
 */
public class Solution_7206_숫자게임_김현정 {
	public static int[] memo = new int[100000]; // f 함수를 호출한 결과를 저장할 배열
	//한번만 배열객체를 생성해서 재활용하는 이유 : f 함수의 호출한 결과 값은 동일하기 때문에 어떤 테스트케이스에서 한번이라도 구했으면, 재활용
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine().trim());
		for(int testCase = 1; testCase <= TC; testCase++) {
			int N = Integer.parseInt(br.readLine().trim());
			System.out.println("#"+testCase+" "+f(N));
		}//end testCase
		
	}//end main

	/** 숫자 N으로 쪼갤 수 있는 최대 턴수를 리턴하는 메서드 */
	public static int f(int N) {
		if (N < 10) {
			return 0;
		}
		String s = N + ""; // 숫자를 문자열로 만들기
		int len = s.length() - 1; // 쪼갤 개수
		int maxCnt = 0; // 구한 턴 수 중 최대값을 저장할 변수
		
		for (int i = 1; i < (1<<len); i++) { // 쪼개는 방법을 바이너리 카운팅 이용, 0은 안쪼개는 경우라서 안함 1부터 시작
//			System.out.printf("%4s: ", Integer.toBinaryString(i));
			
			int mul = 1; // 곱셈 연산자에 대한 항등원 초기화
			int num = s.charAt(0) - '0'; // 첫번째 자리수의 문자를 숫자로 변환
			for(int j = 0; j < len; j++) { // 비트마스킹
				if((i&1<<j) == 0) { // 안쪼갬
					num = num * 10 + s.charAt(j+1) - '0'; // 연결된 숫자로 계산
				}else { // 쪼갬
					mul *= num;
//					System.out.print(num+", ");
					num = s.charAt(j+1) - '0';
				}
			}
			mul *= num;
//			System.out.print(num+", ");
//			System.out.println(mul);
//			int cnt = f(mul); 
			if(mul >= 10 && memo[mul] == 0) { // 아직 구하지 않은 경우
				memo[mul] = f(mul); // mul 을 쪼갤 수 있는 최대 턴수를 받아옴 
			}
			if(maxCnt < memo[mul]) maxCnt = memo[mul];
		}
		return maxCnt + 1; //처음 쪼개는 턴수 1 추가
	}
//	- 1<<n : 2^n을 의미. 모든 부분집합의 갯수
//	- i&(1<<j) : i의 j번째 비트가 1인지 아닌지 판단한다.
//	  &연산자는 두 개의 비트가 모두 1이어야 1을 리턴한다.
}//end class
