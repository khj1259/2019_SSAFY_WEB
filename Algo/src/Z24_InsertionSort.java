import java.util.Arrays;
import java.util.Random;

/**
 *	삽입정렬 
 */

public class Z24_InsertionSort {

	public static void main(String[] args) {
		long time = System.currentTimeMillis(); //현재 시스템의 시각 1970.01.01 0:0:0.0ms long
//		int[] arr= {4, 1, 7, 0, 5, 6, 8, 2, 9, 3};
		Random ran = new Random();
		int[] arr = new int[60000]; // 6만개 1298ms
		for (int i = 0; i < arr.length; i++) {
			arr[i] = ran.nextInt(arr.length);
		}
		
//		for (int i = 1; i < arr.length; i++) { // 삽입할대상
//			for (int j = i-1; j >= 0; j--) { // 이미 정렬된 범위의 뒤에서 앞으로 비교
//				if(arr[j+1] < arr[j]) {
//					int temp = arr[j+1];
//					arr[j+1] = arr[j];
//					arr[j] = temp;
//				} else {
//					break;
//				}
//			}
//		}

		for (int i = 1; i < arr.length; i++) {
			int index = -1;
			for (int j = i-1; j >= 0; j--) {
				if(arr[i] < arr[j]) {
					index = j;
				}
			}
			int temp = arr[i];
			if(index != -1) {
				System.arraycopy(arr, index, arr, index+1, i-index); //영역을 통째로 복사
				arr[index] = temp;
			}
		}
		
		System.out.println(Arrays.toString(arr));
		System.out.println(System.currentTimeMillis() - time + "ms");
	}
}
