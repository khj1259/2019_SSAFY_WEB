import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Algo32_서울_06_김현정 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine().trim()); // 사람 수
			int[] number = new int[N+1]; // 친구들이 뽑은 번호, 0번 안씀
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i = 1; i <= N; i++) {
				number[i] = Integer.parseInt(st.nextToken());
			}
			
			ArrayList<Integer> friends = new ArrayList<>();
			friends.add(1); // 첫번째는 무조건 0번
			for (int i = 2; i < number.length; i++) {
				//현재 줄서있는 친구들 배열 사이즈 - 뽑은 번호 가  들어갈 index
				int idx = friends.size() - number[i];
				friends.add(idx, i);
			}
			
			int answer = 0;
			for (int i = 0; i < friends.size()-1; i++) {
				answer += friends.get(i) - friends.get(i+1);
			}
			
			System.out.println("#"+tc+" "+answer);
			
			
		}//end testCase
		
	}//end main
}//end class
