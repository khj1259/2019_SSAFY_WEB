import java.util.Arrays;

/**
 * 연습문제 1. 아파트 색칠하기
 */
public class Z45_DP_APT {
	public static void main(String[] args) {
		System.out.println(f(8));
	}// end main

	public static int f(int n) {
		int[] memo = new int[n+1];
		memo[1] = 2;
		memo[2] = 3;
//		f(n) = f(n-1) + f(n-2); // 점화식
		for (int i = 3; i <= n; i++) {
			memo[i] = memo[i-1] + memo[i-2];
		}
		System.out.println(Arrays.toString(memo));
		return memo[n];
	}
}// end class
