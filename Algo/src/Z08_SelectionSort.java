import java.util.Arrays;

/**
 * 선택정렬
 * 
 */
public class Z08_SelectionSort {
	public static void main(String[] args) {
		
		int[] m = {4,7,1,8,5,9,6,3,2};
		// 0 ~ 8(m.length-1) 	0 <-> minIndex
		//1~8					1 <-> minIndex				
		//2~8					2 <-> minIndex				
		//3~8					3 <-> minIndex				
		//4~8					4 <-> minIndex				
		//5~8					5 <-> minIndex				
		//6~8					6 <-> minIndex				
		//7~8					7 <-> minIndex				
		//8~8					8 <-> minIndex
		
		System.out.println(Arrays.toString(m) + "최초");
		for (int i = 0; i < m.length; i++) { // 정렬할 영역의 범위의 시작 index
			//최소값의 인덱스를 찾는다
			int minIndex = i; // 정렬할 영역 범위의 시작 index
			for (int j = i; j < m.length; j++) {
				if (m[minIndex] > m[j]) {
					minIndex = j;
				}
			}
			
			//i번째와 최소값의 인덱스를 스왑
			int temp = m[i];
			m[i] = m[minIndex];
			m[minIndex] = temp;
			System.out.println(Arrays.toString(m));
		}
		System.out.println(Arrays.toString(m) + "완료");
		
		
	} // end of main
} // end of class
