import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algo31_서울_06_김현정 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			String[] N = br.readLine().split("");
			int[] num = new int[10];
			for (int i = 0; i < N.length; i++) {
				int su = Integer.parseInt(N[i]);
				num[su]++;
			}
			
			int answer = 0;
			
			int sn = num[6]+num[9];
			if(sn%2 == 0) {
				answer = sn/2;
			}else {
				answer = (sn/2) + 1;
			}
			num[6] = 0;
			num[9] = 0;
			
			for(int i = 0; i < num.length; i++) {
				if(answer < num[i]) {
					answer = num[i];
				}
			}
			
			
			System.out.println("#"+tc+" "+answer);
		}
	}// end main
}// end class
