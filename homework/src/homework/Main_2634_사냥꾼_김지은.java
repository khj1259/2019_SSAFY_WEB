package homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_2634_사냥꾼_김지은 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			int M = Integer.parseInt(st.nextToken()); // 사대의 수
			int N = Integer.parseInt(st.nextToken()); // 동물의 수
			int L = Integer.parseInt(st.nextToken()); // 사정 거리
			
			int[] shotPoint = new int[M]; // 사대의 좌표
			int[][] animalHome = new int[N][2]; // 동물 집의 위치
			int count = 0;
			
			st = new StringTokenizer(br.readLine().trim(), " ");
			for (int i = 0; i < shotPoint.length; i++) {
				shotPoint[i] = Integer.parseInt(st.nextToken());
			} // 사대 위치 초기화
			Arrays.sort(shotPoint);
	
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim(), " ");
				animalHome[i][0] = Integer.parseInt(st.nextToken()); // x
				animalHome[i][1] = Integer.parseInt(st.nextToken()); // y
			} // 동물의 집 위치 초기화
			Arrays.sort(animalHome, new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					if((o1[0]+o1[1]) == (o2[0]+o2[1])) {
						return o1[0] - o2[0];
					}
					return (o1[0]+o1[1]) - (o2[0]+o2[1]);
				}
			});
			
			int idx = 0;
			for (int i = 0; i < shotPoint.length; i++) {
				while (idx < N) {
					if(Math.abs(animalHome[idx][0] - shotPoint[i]) + animalHome[idx][1] > L && animalHome[idx][0] > shotPoint[i]) {
						break;
					} else if(Math.abs(animalHome[idx][0] - shotPoint[i]) + animalHome[idx][1] > L) {
						idx++;
					} else {
						idx++;
						count++;
					}
				}
			}
			
			
			
			System.out.println(count);
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // end of main
} // end of class
