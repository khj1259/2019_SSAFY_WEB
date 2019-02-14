package workshop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1247_SW문제해결응용3일차_최적경로_김현정 {
	static int min=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine()); // 고객의 수
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			int[][] arr = new int[N+2][2];// 회사, 집, 고객~
			while(st.hasMoreTokens()) {
				for(int i=0; i<arr.length; i++) {
					arr[i][0] = Integer.parseInt(st.nextToken());
					arr[i][1] = Integer.parseInt(st.nextToken());
				}
			}
			//회사 -> 고객들  -> 집
			//두 위치 (x1, y1)와 (x2, y2) 사이의 거리는 |x1-x2| + |y1-y2|으로 계산된다.
			min=0;
			int length = perm(arr, 2);
			System.out.println("#"+tc+" "+length);
			
			
		}//end testCase
		
		
	}//end main
	
	public static int perm(int[][] arr, int pivot) {
		if (pivot == arr.length) {
//			int min=0;
			if(min==0) {
				min = length(arr);
			}else {
				if(min>length(arr)) {
					min = length(arr);
				}
			}
		}
		for (int i = pivot; i < arr.length; i++) {
			swap(arr, i, pivot);
			perm(arr, pivot + 1);
			swap(arr, i, pivot);
		}
		return min;
	}

	public static void swap(int[][] arr, int i, int j) {
		int temp = arr[i][0];
		int temp2 = arr[i][1];
		
		arr[i][0] = arr[j][0];
		arr[i][1] = arr[j][1];
		
		arr[j][0] = temp;
		arr[j][1] = temp2;
	}

	public static int length(int[][] arr) {
		int sum = 0;
		sum = Math.abs(arr[0][0]-arr[2][0])+Math.abs(arr[0][1]-arr[2][1]);
		for (int i = 2; i < arr.length-1; i++) {
			sum += Math.abs(arr[i][0]-arr[i+1][0])+Math.abs(arr[i][1]-arr[i+1][1]);
		}
		sum += Math.abs(arr[arr.length-1][0]-arr[1][0])+Math.abs(arr[arr.length-1][1]-arr[1][1]);
		return sum;
	}
}//end class
