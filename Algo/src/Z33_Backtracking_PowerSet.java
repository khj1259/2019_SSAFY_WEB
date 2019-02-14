/**
 * PowerSet
 * 반복문 - n의 개수가 동적으로 바뀌는 것에 대응하기 어렵다
 * 바이너리 카운팅
 * 백트래킹
 *
 */
public class Z33_Backtracking_PowerSet {
	public static int[] arr = {1,3,5}; // 부분집합을 구하고자 하는 원래 배열
	
	public static void main(String[] args) {
		//arr 배열의 모든 부분집합을 구해보자(powerset)
		boolean[] a = new boolean[arr.length];
		backtrack(a, 0, a.length);
	}//end main
	
	/** a[]:각 비트의 사용여부를 저장한 배열, k:현재단계, input:종료단계 */
	public static void backtrack(boolean[] a, int k, int input) {
		boolean[] c = new boolean[a.length]; // 후보군을 저장할 배열
		
		if(k == input) { // 종료파트
			process_solution(a, k);
		} else { // 재귀파트
			int ncands = make_candidates(a, k, input, c); // ncands 후보군의 개수를 리턴받음
			for(int i=0; i<ncands; i++) { // 후보군의 개수만큼만 반복
				a[k] = c[i];
				backtrack(a, k+1, input);
			}
		}
	}//end backtrack
	
	/**  a[]:각 비트의 사용여부를 저장한 배열, k:현재단계, input:종료단계, c[]:후보군을 저장할 배열, return ncands후보군의 개수 */
	public static int make_candidates(boolean[] a, int k, int input, boolean[] c) {
		c[0] = true;
		c[1] = false;
		return 2;
	}
	
	/** 완성된 배열을 보고, 부분집합을 출력하는 메서드 */
	public static void process_solution(boolean[] a, int k) {
		for(int i = 0; i < a.length; i++) {
			if(a[i]) {
//				System.out.print(i+" "); // 인덱스
				System.out.print(arr[i]+" ");
			}
		}
		System.out.println();
	}
	
}//end class
