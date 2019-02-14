/**
 * 순열 backtracking
 * 반복문 - n의 개수가 동적으로 바뀌는 것에 대응하기 어렵다
 * 재귀함수 1.(어제)swap   - 조금 더 좋은 방법
 * 재귀함수 2.(오늘)후보군 구하기
 */
public class Z33_Backtracking_Perm {
	public static int[] arr = { 1, 3, 5, 7 };

	public static void main(String[] args) {
		// arr 배열의 순열을 구해보자
		int[] a = new int[arr.length];
		backtrack(a, 0, a.length);
	}// end main

	public static void backtrack(int[] a, int k, int input) {
		int[] c = new int[a.length]; // 후보군을 저장할 배열

		if (k == input) { // 종료파트
			process_solution(a, k);
		} else { // 재귀파트
			int ncands = make_candidates(a, k, input, c); // ncands 후보군의 개수를 리턴받음
			for (int i = 0; i < ncands; i++) { // 후보군의 개수만큼만 반복
				a[k] = c[i];
				backtrack(a, k + 1, input);
			}
		}
	}// end backtrack

	/** a[]:각 비트의 사용여부를 저장한 배열, k:현재단계, input:종료단계, c[]:후보군을 저장할 배열, return ncands후보군의 개수 */
	public static int make_candidates(int[] a, int k, int input, int[] c) {
		boolean[] in_perm = new boolean[a.length]; // 이전 단계까지 사용한 숫자를 체크할 배열(플래그 변수)
		for (int i = 0; i < k; i++) {
			in_perm[a[i]] = true;
		}
		int ncands = 0; // 후보군의 개수
		for (int i = 0; i < in_perm.length; i++) {
			if (!in_perm[i]) { // 사용하지 않은 숫자를 후보군으로 넣기
				c[ncands] = i;
				ncands++;
			}
		}

		return ncands;
	}

	/** 완성된 배열을 보고, 순열을 출력하는 메서드 */
	public static void process_solution(int[] a, int k) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
}// end class
