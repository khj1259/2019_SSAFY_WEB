package homework;

import java.util.Scanner;

public class Solution_1257_K번째문자열_김현정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for (int tc = 1; tc <= T; tc++) {
			int K = Integer.parseInt(sc.nextLine());
			String str = sc.nextLine(); // 길이 최대 400

			// str 문자열의 모든 접미사 생성
			int[] sa = new int[str.length()]; // Suffix Array : index 번째에서 시작하는 str문자열의 접미사
			for (int i = 0; i < sa.length; i++) {
				sa[i] = i; // 초기화
			}
			// str 문자열의 접미사를 정렬
			for (int i = 0; i < sa.length; i++) { // 선택정렬
				int minIndex = i;
				for (int j = i; j < sa.length; j++) {
//								str.substring(sa[minIndex]) ~~  str.substring(sa[j])
					if (str.substring(sa[minIndex]).compareTo(str.substring(sa[j])) > 0) {
						minIndex = j;
					}
				}
//							minIndex <-> i	swap
				int temp = sa[minIndex];
				sa[minIndex] = sa[i];
				sa[i] = temp;
			}
			
			int[] LCP = new int[str.length()]; // 최장공통접두어를 저장할 배열 (최장공통접두어의 길이)
//			LCP[4] = str.substring(sa[3]) 과 str.substring(sa[4]) 의 최장공통접두어의 개수
			for (int i = 1; i < LCP.length; i++) {
				String s1 = str.substring(sa[i-1]);
				String s2 = str.substring(sa[i]);
				while( s1.length() > LCP[i]
					&& s2.length() > LCP[i]
					&& s1.charAt(LCP[i]) == s2.charAt(LCP[i])) {
					LCP[i]++;
				}
			}
			
			// str문자열에서 만들수 있는 모든 부분문자열에서 사전식 정렬상태에서 k번째 문자열을 출력하시오
			for (int i = 0; i < sa.length; i++) {
				String str2 = str.substring(sa[i]); // 접미사
				
				if(K - (str2.length()-LCP[i]) > 0) {
					K = K - (str2.length()-LCP[i]);
				} else {
					System.out.println("#"+tc+" "+str2.substring(0, LCP[i]+K));
					break;
				}
			}

		} // end testCase

	}// end main
}// end class
