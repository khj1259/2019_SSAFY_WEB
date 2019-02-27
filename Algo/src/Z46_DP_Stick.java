import java.util.Arrays;

/**
 * 연습문제2 막대기
 */
public class Z46_DP_Stick {
	public static void main(String[] args) {
		System.out.println(f(6));
	}// end main

	public static int f(int n) {
		int[] memo = new int[n + 1];
		memo[1] = 2;
		memo[2] = 5;
		for (int i = 3; i <= n; i++) {
			memo[i] = 2 * memo[i - 1] + memo[i - 2];
		}
		System.out.println(Arrays.toString(memo));
		return memo[n];
	}
}// end class
