import java.util.Arrays;

public class Solution_병합정렬_정용수 {

	public static void main(String[] args) {
		int arr[] = {69,10,30,2,16,8,31,22};
		System.out.println(Arrays.toString(arr));
		arr = merge_sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	static int[] merge_sort(int[] arr) {
		if(arr.length == 1) {
			return arr;
		} else {
			int length = arr.length;
			int[] left = new int[length/2];
			int[] right = new int[length-left.length];
			int cnt = 0;
			for (int i = 0; i < left.length; i++) {
				left[i] = arr[cnt++]; 
			}
			for (int i = 0; i < right.length; i++) {
				right[i] = arr[cnt++];
			}
			
			left = merge_sort(left);
			right = merge_sort(right);
			System.out.println("left : " + Arrays.toString(left));
			System.out.println("right : " + Arrays.toString(right));
			return merge(left, right);
		}
	}
	
	static int[] merge(int[] left, int[] right) {
		int[] result = new int[left.length+right.length];
		int leftcnt = 0;
		int rightcnt = 0;
		int cnt = 0;
		while(leftcnt < left.length || rightcnt < right.length) {
			if(leftcnt < left.length && rightcnt < right.length) {
				if(left[leftcnt] < right[rightcnt]) {
					result[cnt++] = left[leftcnt++]; 
				} else {
					result[cnt++] = right[rightcnt++];
				}
			} else if (leftcnt == left.length) {
				result[cnt++] = right[rightcnt++];
			} else if (rightcnt == right.length) {
				result[cnt++] = left[leftcnt++];
			} 
		}
		
		return result;
	}
}
