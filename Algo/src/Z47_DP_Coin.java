import java.util.Arrays;

/**
 * 동전 거스름돈 최소 개수
 *
 */
public class Z47_DP_Coin {
	public static void main(String[] args) {
		System.out.println(f(8));
	}//end main

	public static int f(int n) {
		int[] C = new int[n+1]; // 동전 거스름돈의 동전의 최소 개수(최적의 해)
		
		// 1원 동전을 고려한 경우
		for(int i = 1; i <= n; i++) {
			C[i] = i;
		}
		System.out.println(Arrays.toString(C));
		
		// 4원 동전을 고려한 경우
		for(int i = 4; i <= n; i++) {
			if(C[i] > C[i-4] + 1) {
				C[i] = C[i-4] + 1;
			}
		}
		System.out.println(Arrays.toString(C));
		
		// 6원 동전을 고려한 경우
		for(int i = 6; i <= n; i++) {
			if(C[i] > C[i-6] + 1) {
				C[i] = C[i-6] + 1;
			}
		}
		System.out.println(Arrays.toString(C));
		
		return C[n];
	}
}//end class
