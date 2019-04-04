package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_5672_올해의조련사_홍휘진 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= tc; t++) {
			int n = Integer.parseInt(br.readLine().trim());
			char []arr = new char[n];
			for (int i = 0; i < n; i++) {
				arr[i] = br.readLine().charAt(0);
			}
			StringBuilder sb = new StringBuilder();
			int s = 0;
			int e = n-1;
			while(s <= e) {
				if(arr[s] < arr[e]) {
					sb.append(arr[s++]);
				} else if (arr[s] == arr[e]) {
					int tempS = s+1;
					int tempE = e-1;
					while (tempS < tempE && arr[tempS] == arr[tempE]) {
						tempS++;
						tempE--;
					}
					if (tempS < tempE && arr[tempS] < arr[tempE]) {
						sb.append(arr[s++]);
					}
					else
						sb.append(arr[e--]);
				} else {
					sb.append(arr[e--]);
				}
			}
			System.out.println("#" + t + " " + sb);
			
		}
	}
}
