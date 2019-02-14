package test;
//재귀 사용해서 순열만들기
public class test1 {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3};
		perm(arr, 0);
	}

	public static void perm(int[] arr, int pivot) {
		if (pivot == arr.length) {
			print(arr);
			return;
		}
		for (int i = pivot; i < arr.length; i++) {
			swap(arr, i, pivot);
			perm(arr, pivot + 1);
			swap(arr, i, pivot);
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (i == arr.length - 1)
				System.out.println(arr[i]);
			else
				System.out.print(arr[i] + ",");
		}
	}

}
