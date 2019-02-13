import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  병합정렬2 - 배열사용
 */

public class Z25_MergeSort3 {
	
	public static void mergeSort(int[] arr, int left, int right) {
		if(right - left <= 1) {
			return;
		} else {
			int mid = (left+right) / 2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid, right);
			
			merge(arr, left, mid, right);
			return;
		}
	}
	
	static int[] temp; // 병합하면서 저장할 임시배열
	public static void merge(int[] arr, int left, int mid, int right) {
		int l = left; // 왼쪽 배열의 인덱스
		int r = mid; // 오른쪽 배열의 인덱스
		int index = 0;
		
		//양쪽이 모두 원소가 남은경우
		while(l < mid && r < right) {
			if(arr[l] < arr[r]) {
				temp[index++] = arr[l++];
			} else {
				temp[index++] = arr[r++];
			}
		}
		
		//왼쪽만 남은경우
		System.arraycopy(arr, l, temp, index, mid-l);
		//오른쪽만 남은경우
		System.arraycopy(arr, r, temp, index, right-r);
		
		//병합된 temp를 원본 arr에 복사
		System.arraycopy(temp, 0, arr, left, right-left);
		
	}
	
	public static void main(String[] args) {
		int[] arr = {6, 4, 8, 5, 7, 2, 9, 3, 0, 1};
		temp = new int[arr.length];
		mergeSort(arr, 0, arr.length); // 원본배열을 직접변경
		System.out.println(Arrays.toString(arr));
		
	} // end of main
} // end of class
