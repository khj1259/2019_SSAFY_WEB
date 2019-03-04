import java.util.Arrays;

/**
 * 문자열 검색을 빠르게 하려면
 * 보이어무어 알고리즘
 * 
 * 문자열 검색을 빠르게 하려면
 * 특정 문자열에서 모든 부분문자열을 정렬된 상태로 알고싶다면
 * 특정 문자열의 모든 접미사를 구함 -> 접미사를 정렬 -> 각 접미사의 모든 접두사를 구함
 * 
 * 트라이(Trie) : 문자열의 잡합을 표현하는 트리
 * Compressed Trie : 어떤 문자열의 접미사들을 트라이로 압축된 표현
 * 
 * 접미어 트리(Suffix Tree) : Compressed Trie 문제점
 * 		(접미사가 다른 접미사의 접두어가 되는 경우 구분이 불가, 문자열 끝에 $를 표시해서 작업)을 해결
 * 		생성 시간복잡도 O[n^2] => O[n log n] => O[n]
 * 접미어 배열(Suffix Array) : 접미어들의 시작 index만 저장해서 문자열을 표현하는 방법
 * 		(접미어 트리에 비해) 메모리를 절약 1/4, 속도 느리다
 * 		생성 시간복잡도 O[n log n] (정렬을 해야하기 때문에)
 * LCP 배열 : 최장 공통 접두어(Longest Common Prefix), 접미어 배열 사용시 보조적으로 필요하다
 * 		두 문자열 사이의 공통 접두어의 길이
 * 
 */
public class Z40_SuffixArray {
	public static void main(String[] args) {
		String s = "banana";
		
		// s 문자열의 모든 접미사 생성
		int[] sa = new int[s.length()]; // Suffix Array : index 번째에서 시작하는 s문자열의 접미사
		for (int i = 0; i < sa.length; i++) {
			sa[i] = i; // 초기화
		}
		// s 문자열의 접미사를 정렬
		for (int i = 0; i < sa.length; i++) { // 선택정렬
			int minIndex = i;
			for (int j = i; j < sa.length; j++) {
//				s.substring(sa[minIndex]) ~~  s.substring(sa[j])
				if(s.substring(sa[minIndex]).compareTo(s.substring(sa[j])) > 0) {
					minIndex = j;
				}
			}
//			minIndex <-> i	swap
			int temp = sa[minIndex];
			sa[minIndex] = sa[i];
			sa[i] = temp;
		}
		
		int[] LCP = new int[s.length()]; // 최장공통접두어를 저장할 배열 (최장공통접두어의 길이)
//		LCP[4] = s.substring(sa[3]) 과 s.substring(sa[4]) 의 최장공통접두어의 개수
		for (int i = 1; i < LCP.length; i++) {
			String s1 = s.substring(sa[i-1]);
			String s2 = s.substring(sa[i]);
			while( s1.length() > LCP[i]
				&& s2.length() > LCP[i]
				&& s1.charAt(LCP[i]) == s2.charAt(LCP[i])) {
				LCP[i]++;
			}
		}
		System.out.println(Arrays.toString(LCP) + " : LCP");
		
		// Suffix Array를 활용해서 접미사 문자열을 출력
		System.out.println(Arrays.toString(sa) + " : Suffix Array");
		for (int i = 0; i < sa.length; i++) {
			String str = s.substring(i); // 접미사
			System.out.println("<"+str+">");
			// s 문자열의 정렬된 모든 접미사의 모든 접두사를 생성
//			for (int j = 1; j <= str.length(); j++) { // 접미사로 만들수있는 모든 접두사 == 부분문자열
			for (int j = LCP[i]+1; j <= str.length(); j++) { // 중복된 접두사는 제거하고 출력
				System.out.println(str.substring(0, j)); 
			}
			System.out.println(str.length() + " : 접두사의 개수"); // == 해당 접미사의 길이
			System.out.println(LCP[i]+" : 최장공통 접두사의 개수");
			System.out.println(str.length()-LCP[i]+" : 유효한 부분 문자열의 개수");
		}
		
		// s문자열에서 만들수 있는 모든 부분문자열에서 사전식 정렬상태에서 k번째 문자열을 출력하시오
		int k = 13;
		int index = k;
		for (int i = 0; i < sa.length; i++) {
			String str = s.substring(sa[i]); // 접미사
			//str.length()-LCP[i] : 중복 제거한 부분 문자열 갯수
			if(index - (str.length()-LCP[i]) > 0) {
				index = index - (str.length()-LCP[i]);
			} else {
				System.out.println(k + "번째 문자열 : "+str.substring(0, LCP[i]+index));
				break;
			}
		}
		
		
		
		
	}//end main
}//end class
