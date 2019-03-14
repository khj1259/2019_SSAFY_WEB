package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1053_피보나치_조동희 {
	static int n;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 행렬의 곱..?
		/*
			x y x2 y2
			z k z2 k2
			=> x*x2+y*z2  x*y2+y*k2
			   z*x2+k*z2  z*y2+k+k2
			   
			A*B = B*A 가 되므로 분할정복?
		*/
		while(true) {
			n = Integer.parseInt(br.readLine());
			if(n==-1) break;
			int[][] result = merge(n);
	//		System.out.println(result[0][0]+" "+result[0][1]);
	//		System.out.println(result[1][0]+" "+result[1][1]);
			sb.append(result[0][1]%10000).append('\n');
		}// end of while
		System.out.println(sb);
	}// end of main
	
	static int[][] arr = {{1,1},{1,0}};
	static int[][] zero = {{1,0},{0,1}};
	public static int[][] merge(int cnt) {
		if(cnt==1) {
			return arr;
		}else if(cnt==0) {
			return zero;
		}
		int[][] a = null;
		int[][] b = null;
		if(cnt%2==0) {
			a = merge(cnt/2);
			b = a;
		}else {
			a = merge(cnt-1);
			b = merge(1);
		}
		int[][] result = {{a[0][0]*b[0][0]%10000+a[0][1]*b[1][0]%10000,a[0][0]*b[0][1]%10000+a[0][1]*b[1][1]%10000},
				{a[1][0]*b[0][0]%10000+a[1][1]*b[1][0]%10000,a[1][0]*b[0][1]%10000+a[1][1]*b[1][1]%10000}};
		return result;
	}
}// end of class
