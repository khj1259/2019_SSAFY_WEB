/**
 * PowerSet : 어떤 한 집합의 모든 부분집합을 원소로 하는 집합
 *	반복문, 바이너리카운팅, 재귀
 */
public class Z07_PowerSet {

	public static void main(String[] args) {
		int[] arr = {5,2,8,3};
		
		for(int i = 0; i < (1 << arr.length); i++) {
			for(int j = 0; j<arr.length; j++) {
				if((i & 1<<j) != 0) System.out.print(arr[j]); 
			}
//			if((i & 1<<0) != 0) System.out.print(arr[0]); 
//			if((i & 1<<1) != 0) System.out.print(arr[1]); 
//			if((i & 1<<2) != 0) System.out.print(arr[2]); 
//			if((i & 1<<3) != 0) System.out.print(arr[3]);
			System.out.println();
		}
		
		
//		for(int i = 0; i<2; i++) {
//			for(int j = 0; j<2; j++) {
//				for(int k = 0; k<2; k++) {
//					for(int m = 0; m<2; m++) {
//						if (i==1) System.out.print(arr[0]+" ");
//						if (j==1) System.out.print(arr[1]+" ");
//						if (k==1) System.out.print(arr[2]+" ");
//						if (m==1) System.out.print(arr[3]+" ");
//						System.out.println("===>    "+i+","+j+","+k+","+m);
//						
//					}
//				}
//			}
//		}
	}
}
