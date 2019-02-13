
public class Z07_PowerSet2 {

	public static void main(String[] args) {
		
		int[] arr = {-13, -3, -2, 5, 8};
		int[] temp = new int[5];
		for(int i = 0; i< (1<<arr.length); i++) {
			temp = new int[5];
			for(int j = 0; j<arr.length; j++) {
				if((i & 1<<j) != 0) temp[j] = arr[j];
			}
			int sum = 0;
			boolean isZero = false;
			for(int j = 0; j<temp.length; j++) {
				if(temp[j] != 0) isZero = true;
				sum += temp[j];
			}
			if(sum == 0 && isZero) {
				for(int j = 0; j<temp.length; j++) {
					System.out.print(temp[j]+" ");
				}
				System.out.println();
			}
		}
	}
}
