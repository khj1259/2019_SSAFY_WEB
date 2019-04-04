package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_5672_올해의조련사_조동희 {
	static int n;
	static char[] arr = new char[2000];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine().trim());
		for(int z=1;z<=tc;z++) {
			n = Integer.parseInt(br.readLine().trim());
			for(int i=0;i<n;i++) {
				arr[i] = br.readLine().charAt(0);
			}
			
			sb.append('#').append(z).append(' ');
			int start = 0, end = n-1;
xx:			for(int i=0;i<n;i++) {
				if(arr[start]<arr[end]) {
					sb.append(arr[start++]);
				}else if(arr[start]>arr[end]){
					sb.append(arr[end--]);
				}else {
					// 양쪽이 같은 경우!!!
					// 사전순 -> 작은 글자가 먼저 나와야한다.
					for(int j=1;;j++) {
						if(start+j<n && end-j>=0) {
							if(arr[start+j]<arr[end-j]) {
								sb.append(arr[start++]);
								continue xx;
							}else if(arr[start+j]>arr[end-j]) {
								sb.append(arr[end--]);
								continue xx;
							}
						}else {
							sb.append(arr[start++]);
							continue xx;
						}
					}
				}
			}
			sb.append('\n');
		}// end of tc
		System.out.println(sb);
	}// end of main
}// end of class