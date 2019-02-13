import java.util.Arrays;

public class Z08_SelectioinSortTest {
	public static void main(String[] args) {
		
		int[][] tree = {{9,20,2,18,11,26,37},
						{19,1,25,3,21,27,38},
						{8,24,10,17,7,28,39},
						{15,4,16,5,6,29,40},
						{12,13,22,23,14,30,41},
						{31,32,33,34,35,36,42},
						{43,44,45,46,47,48,49}};
		
		int[] arr = new int[tree.length * tree.length];
		int index = 0;
		for(int i = 0; i<tree.length; i++) {
			for(int j = 0; j<tree.length; j++) {
				arr[index++] = tree[i][j];
			}
		}
		
		for(int i = 0; i < arr.length; i++) {
			index = i;
			for(int j = i; j<arr.length; j++) {
				if(arr[index] > arr[j]) {
					index = j;
				}
			}
			
			int temp = arr[i];
			arr[i] = arr[index];
			arr[index] = temp;
		}
		
		index = 0;
		int leng = tree.length;
		for (int i = 0; i<leng; i++) {
			int k = i;
			if(i%2 == 0) {
				k = i/2;
			} else {
				k = i/2 +1;
			}
			int t = k;
			
			//가로그리기
			for(int j = i; j<leng; j++) {
				if(i%2 == 0) {
					tree[k][t] = arr[index++];
				} else {
					tree[leng-k][leng-1-t] = arr[index++];
				}
				t++;
			}
			t= k+1;		
			
			//세로그리기
			for(int j = i+1; j<leng; j++) {
				if(i%2 == 0) {
					tree[t][leng-1-k] = arr[index++];
				} else {
					tree[leng-t][k-1] = arr[index++];
				}
				t++;
			}
		}
		for(int i =0; i<tree.length; i++)
		System.out.println(Arrays.toString(tree[i]));
		
	}
}
