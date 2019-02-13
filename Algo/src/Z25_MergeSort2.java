import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  병합정렬1 - 리스트사용
 */


public class Z25_MergeSort2 {
	public static List<Integer> mergeSort(List<Integer> li) {
		if(li.size() <=1) {
			return li;
		} else {
			int m = li.size() / 2;
			List<Integer> left = mergeSort(li.subList(0, m));
			List<Integer> right = mergeSort(li.subList(m, li.size()));
			return merge(left, right);
		}
	}
	
	public static List<Integer> merge(List<Integer> left, List<Integer> right) {
		
		List<Integer> result = new ArrayList<>(left.size() + right.size());

		int leftIdx = 0;
		int rightIdx = 0;
		// 양쪽에 다있는경우
		while(left.size() > leftIdx && right.size() > rightIdx) {
			if(left.get(leftIdx) > right.get(rightIdx)) {
				result.add(right.get(rightIdx++));
			} else {
				result.add(left.get(leftIdx++));
			}
		}
		// 왼쪽리스트에만 원소가 있는경우
		result.addAll(left.subList(leftIdx, left.size()));
		// 오른쪽리스트만 원소가 있는경우
		result.addAll(right.subList(rightIdx, right.size()));
		return result;
	}
	
	public static void main(String[] args) {
		Integer[] arr = {69,10,30,2,16,8,31,22};
		List<Integer> list = new ArrayList<>(Arrays.asList(arr));
		list = mergeSort(list);
		System.out.println(list);
		
	} // end of main
} // end of class
