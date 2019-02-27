import java.util.Arrays;

/**
 * 0-1 Knapsack : DP 로 풀기
 */
public class Z49_배낭01 {
	public static void main(String[] args) {
		System.out.println(f(10));
	}//end main

	public static int f(int n) {
		int[][] item = {{10, 5}, {40, 4}, {30, 6}, {50, 3}}; //{가격(만원), 무게(kg)}
		int[][] K = new int[item.length+1][n+1]; // [반영할 item][배낭의 무게]
		
		for(int i = 0; i < item.length; i++) {
			for(int w = 0; w < item[i][1]; w++) { // 임시 배낭의 무게
				K[i+1][w] = K[i][w]; // 임시 배낭의 무게보다 물건의 무게가 무거우면, 이전 값을 가져오기
			}
			for(int w = item[i][1]; w <= n; w++) { // 임시 배낭의 무게
				int now = item[i][0] + K[i][w-item[i][1]]; // 현재 item을 반영한 경우
				int pre = K[i][w]; // 현재 item을 반영하지 않은 경우
				K[i+1][w] = now >= pre ? now : pre;
			}
		}
		
		//배열 출력
		for (int i = 0; i < K.length; i++) {
			System.out.println(Arrays.toString(K[i]));
		}
		return K[item.length][n];
	}
}//end class
