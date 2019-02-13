/**
 * 순열
 */
public class Z02_Perm {
	public static void main(String[] args) {
		
		int[] arr = {4,7,9};
		
		for(int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				if (i == j) continue;
				for (int k = 0; k <= 2; k++) {
					if (i == k || j == k) continue;
					System.out.println(arr[i]+","+arr[j]+","+arr[k]);
				} 
			}
		}
		
		
		
//		123
//		132
//		213
//		231
//		312
//		321
		
		
		
	} // end of main
} // end of class
