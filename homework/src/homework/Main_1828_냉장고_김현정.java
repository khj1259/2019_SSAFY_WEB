package homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main_1828_냉장고_김현정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 1~100
		int[][] ref = new int[N][2];
		for (int i = 0; i < N; i++) {
			ref[i][0] = sc.nextInt();
			ref[i][1] = sc.nextInt();
		}

		// 최저 온도 기준으로 정렬
		Arrays.sort(ref, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] <= o2[0] ? -1 : 1;
			}
		});

		ArrayList<int[]> list = new ArrayList<>();
		list.add(ref[0]); // 첫 냉장고 온도값만 넣어줌
		int idx = 0; // list의 인덱스

		// list에 최소 필요한 냉장고의 겹치는 범위만을 저장
		// ref의 냉장고와 list의 겹치는 범위를 비교해서 겹치면 update, 안겹치면 insert
		for (int i = 1; i < ref.length; i++) {
			int[] before = list.get(idx);
			int min = before[0];
			int max = before[1];

			// 정렬했으므로 현재 냉장고의 최저온도가 이전 냉장고의 최고 온도보다 낮은지만 검사
			if (ref[i][0] <= max) { // 온도가 겹침
				min = ref[i][0];
				max = max > ref[i][1] ? ref[i][1] : max;
				int[] tmp = { min, max };
				list.set(idx, tmp);
			} else { // 온도가 안겹침
				idx++;
				list.add(ref[i]);
			}
		}
		System.out.println(list.size());

	}// end main
}// end class
