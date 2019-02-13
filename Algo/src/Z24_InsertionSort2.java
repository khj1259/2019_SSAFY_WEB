import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 *	삽입정렬 - 리스트사용
 */

public class Z24_InsertionSort2 {
	public static void main(String[] args) {
		long time = System.currentTimeMillis(); //현재 시스템의 시각 1970.01.01 0:0:0.0ms long
//		int[] arr= {4, 1, 7, 0, 5, 6, 8, 2, 9, 3};
		Random ran = new Random();
		int[] arr = new int[60000];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = ran.nextInt(arr.length);
		}
//		LinkedList<Integer> ll = new LinkedList<>(); //- 3천개 2249ms
		ArrayList<Integer> ll = new ArrayList<>(); // 3천개 16ms, 6만개 2348ms
		for (int i = 0; i < arr.length; i++) { //삽입할대상
//			int index;
//			for(index = 0; index < i; index++) {
//				if(arr[i] < ll.get(index)) {
//					break;
//				}
//			}
//			ll.add(index, arr[i]);
			int index = i;
			for (int j = 0; j < i; j++) {
				if(arr[i] < ll.get(j)) {
					index = j;
					break;
				}
			}
			ll.add(index, arr[i]);
		}
		
		System.out.println(ll);
		System.out.println(System.currentTimeMillis() - time + "ms");
	}
}
