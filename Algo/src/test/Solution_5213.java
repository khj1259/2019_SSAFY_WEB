package test;

import java.util.Scanner;

public class Solution_5213 {
	static int MAX = 1000000;
	static long[] oddSum = new long[MAX + 1];//1~N까지 각 숫자별 홀수약수들의 합계 배열 
	static long[] piledOddSum = new long[MAX + 1];//1~N까지 홀수 약수들의 누적 합계 배열
	
	public static void main(String[] args) {
		//1)1~MAX 까지 각 숫자별 홀수 약수들의 합 미리 구해놓기
		for (int i = 1; i <= MAX; i+= 2) {//i=1,3,5,....
			for (int j = 1; i * j <=MAX; j++) {//i의 배수들
				oddSum[i * j] += i; //i의 배수번째 칸마다 i값 누적(1의 배수번째, 3의 배수번째, 5의 배수번째....)
			}
		}
		
		//2)1~N까지의 홀수 약수들의 누적 합 구해 놓기
		piledOddSum[1] = 1;//숫자1의 홀수 약수합은 1. 2부터 시작
		for (int i = 2; i <=MAX; i++) {
			piledOddSum[i] = piledOddSum[i-1] + oddSum[i];
		}		
		
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();// tc num
		
		for (int tc = 1; tc <= N; tc++) {
			int x = s.nextInt();
			int y = s.nextInt();			
			
			//x부터 y까지 숫자들의 홀수 약수의 합을 다 더해서 결과 출력->[y]까지의 누적합에서 [x-1]까지의 누적합을 빼주면 됨
			long result = piledOddSum[y] - piledOddSum[x-1];
			System.out.println("#" + tc + " " + result);			
		}
	}
}






