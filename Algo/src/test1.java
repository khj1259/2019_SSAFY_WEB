import java.util.Arrays;

public class test1 {

	public static void main(String[] args) {
		test2(0, new int[6]);
	}
	
	public static void test2(int n, int[] arr) {
		if(n >= arr.length) {//종료파트
			System.out.println(Arrays.toString(arr));
		} else {//반복 재귀파트
			for(int i = 0; i<arr.length; i++) { // 0~10 까지의 숫자로 
				boolean isUse = false;  // 사용한 적이 있는지 플래그
				for (int j = 0; j < n; j++) {
					if(arr[j] == i) {
						isUse = true;
						break;
					}
				}
				if(!isUse) {
					arr[n] = i;
					test2(n+1,arr);
				}
			}
		}
	}
}
