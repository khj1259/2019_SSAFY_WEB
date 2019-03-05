package homework;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main_2634_사냥꾼_김현정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt(); 
		int N = sc.nextInt();
		int L = sc.nextInt(); 
		
		int[] gun = new int[M];
		for(int i=0; i<M; i++) {
			gun[i] = sc.nextInt();
		}
		Arrays.sort(gun);
		
		int[][] animal = new int[N][2];
		for(int i=0; i<N; i++) {
			animal[i][0] = sc.nextInt();
			animal[i][1] = sc.nextInt();
		}
		
		Arrays.sort(animal, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if((o1[0]+o1[1]) == (o2[0]+o2[1])) {
					return o1[0] - o2[0];
				}
				return (o1[0]+o1[1]) - (o2[0]+o2[1]);
			}
		});
		
		//다시 풀어보기!!
		
//		int cnt = 0;
//		int idx = 0;
//		for(int j=0; j<N; j++) {
//			if(animal[j][1] > L) continue;
//			for(int i=idx; i<M; i++) {
//				int length = Math.abs(gun[i]-animal[j][0]) + animal[j][1];
//				if(length > L && animal[j][0] > gun[i]) {
//					break;
//				}else if(length > L) {
//					continue;
//				}else {
//					cnt++;
//					idx = j;
//				}
//			}
//		}
		
//		System.out.println(cnt);
	}//end main
}//end class
