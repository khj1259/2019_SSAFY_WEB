import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo2_서울_06_김현정 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= TC; testCase++) {
			int W = Integer.parseInt(br.readLine());// 밀가루 무게, 3 <= W <= 5000
			int N = Integer.parseInt(br.readLine());// 봉투의 개수, 2 <= N <= 3
			
			int[] pack = new int[N]; // 밀가루 봉투 무게종류
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < pack.length; i++) {
				pack[i] = Integer.parseInt(st.nextToken());
			}
			
			final int M = Integer.MAX_VALUE;
			
			int[] dp = new int[W+1];
			// 첫번째 종류 봉투를 먼저 저장
			for (int i = 0; i < dp.length; i++) {
				if(i%pack[0] == 0) {
					dp[i] = i/pack[0];
				}else {
					dp[i] = M;
				}
			}
//			System.out.println(Arrays.toString(dp));
			// 두번째 봉투부터는 반복문으로 한꺼번에 저장
			for (int i = 1; i < pack.length; i++) { // 봉투 종류
				for (int j = pack[i]; j < dp.length; j++) {
					if(dp[j-pack[i]] != M && dp[j] > dp[j-pack[i]]+1) {
						dp[j] = dp[j-pack[i]] + 1;
					}
				}
			}
//			System.out.println(Arrays.toString(dp));
			
			System.out.println("#"+testCase+" "+(dp[W] == M ? -1 : dp[W]));
		}//end testCase
	}//end main
	
}//end class
