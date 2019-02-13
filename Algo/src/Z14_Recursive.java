/**
 *	재귀 함수 
 */
public class Z14_Recursive {

	public static int fact(int n) {
		if(n <= 1) {
			return 1;
		} else {
			return n * fact(n-1);
		}
	}
	
	public static int f(int n) {
		if(n >= 2 && memo[n] == 0) {
			memo[n]=f(n-1) + f(n-2);
		}
		return memo[n];
	}
	public static int[] memo = new int[51];
	public static void main(String[] args) {
		
//		memo[0] = 0;
//		memo[1] = 1;
//		System.out.println(f(50));
		
//		DP동적 계획법 : f(8) 7 6 5 4 3 2 1 0 어차피 다  필요한 부품들 이니까 작은해부터 구해서 올라오자
		int[] dp = new int[9];
		dp[0] = 0;
		dp[1] = 1;
		for(int i = 2; i <dp.length; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		System.out.println(dp[8]);
	} // end of main
	
} // end of class
