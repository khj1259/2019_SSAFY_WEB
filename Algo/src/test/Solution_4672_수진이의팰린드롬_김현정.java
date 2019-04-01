package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_4672_수진이의팰린드롬_김현정 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {

			// 가장 개수가 많은 문자를 가운데 두고 
			// 그 뒤로 문자를 양 끝에 붙이기
			// baaabc
			
			String[] W = br.readLine().split("");
			Arrays.sort(W); // 같은 문자끼리 뭉쳐놓기
			int[] cnt = new int[W.length]; // 각 문자의 개수 세기
			int idx = 0;
			for (int i = 0; i < W.length; i++) {
				if (i != 0 && !W[i].equals(W[i - 1])) {
					idx++;
				}
				cnt[idx]++;
			}

			Arrays.sort(cnt); // 제일 긴 문자 찾기위해 정렬
			int n = cnt[cnt.length-1]; // 가장 긴 (개수가 많은) 문자 길이
			int answer = W.length; // 하나짜리 팰린드롬
			answer += (n-1)*(n) / 2; // 가장 긴  문자의 2이상 부분문자열(팰린드롬) : 1~(n-1)까지 합
			
			for (int i = 0; i < cnt.length-1; i++) {
				answer += cnt[i] / 2;
			}

			System.out.println("#" + tc + " " + answer);
		}
	}// end main
}// end class
