package workshop;

import java.util.Scanner;

public class Solution_1256_K번째접미어_김현정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for (int tc = 1; tc <= T; tc++) {
			int K = Integer.parseInt(sc.nextLine());
			String str = sc.nextLine();

			// str 문자열의 모든 접미사 생성
			int[] sa = new int[str.length()]; // Suffix Array : index 번째에서 시작하는 str문자열의 접미사
			for (int i = 0; i < sa.length; i++) {
				sa[i] = i; // 초기화
			}
			// str 문자열의 접미사를 정렬
			for (int i = 0; i < sa.length; i++) { // 선택정렬
				int minIndex = i;
				for (int j = i; j < sa.length; j++) {
//					str.substring(sa[minIndex]) ~~  str.substring(sa[j])
					if (str.substring(sa[minIndex]).compareTo(str.substring(sa[j])) > 0) {
						minIndex = j;
					}
				}
//				minIndex <-> i	swap
				int temp = sa[minIndex];
				sa[minIndex] = sa[i];
				sa[i] = temp;
			}

			System.out.println("#" + tc + " " + str.substring(sa[K - 1]));

		} // end testCase

	}// end main
}// end class
