/**
 * 검색
 * 순차검색 : O[N]
 * 이진검색 : O[logN] - 데이터가 정렬된 상태여야 한다.
 * 해시검색 : O[1]
 */


public class Z08_BinarSearch {
	
	public static void binarySearch(int[] m, int key, int l, int r) {
		if(l>r) {
			System.out.println("못찾음");
		} else {
			int mid = (l+r) / 2; //중간 index;
			if(key == m[mid]) {
				System.out.println("찾음"+mid);
			} else if(key < m[mid]) { //작은쪽 영역으로 재설정
				binarySearch(m, key, l, mid-1);
			} else if(key > m[mid]) { //큰쪽 영역으로 재설정
				binarySearch(m, key, mid+1, r);
			}
		}
	}
	
	
	public static void main(String[] args) {
		
		int[] m = {0,1,2,3,4,5,6,7,8,9};
		int key = 0;
		binarySearch(m, key, 0, 9);
		
//		int[] m = {0,1,2,3,4,5,6,7,8,9};
//		int key = 80;
//		int l = 0; //검색범위의 왼쪽 끝 index
//		int r = 9; //검색범위의 오른쪽 끝 index m.lenght-1
//		
//		while(l <= r) {
//			int mid = (l+r) / 2; //중간 index;
//			if(key == m[mid]) {
//				System.out.println("찾음"+mid);
//				break;
//			} else if(key < m[mid]) {
//				r = mid-1;
//			} else if(key > m[mid]) {
//				l = mid+1;
//			}
//		}
//		if(l > r) System.out.println("못 찾음");
		
		
	} // end of main
} // end of class
