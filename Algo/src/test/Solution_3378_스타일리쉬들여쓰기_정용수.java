package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Solution_3378_스타일리쉬들여쓰기_정용수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= testcase; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int[] result = new int[q];
			String[] srr = new String[p];
			String[] srr2 = new String[q];
			for(int i = 0; i<p; i++) {
				srr[i] = br.readLine();
			}
			for(int i = 0; i<q; i++) {
				srr2[i] = br.readLine();
				result[i] = -2;
			}
			for(int R = 1; R < 21; R++) {
				for(int S = 1; S <21; S++) {
chk1:				for(int C = 1; C <21; C++) {
						int cnt1 = 0;
						int cnt2 = 0;
						int cnt3 = 0;
						for(int i = 0; i<srr.length; i++) {
							boolean isDot = true;
							int dotcnt = 0;
							int pcnt1 = 0;
							int mcnt1 = 0;
							int pcnt2 = 0;
							int mcnt2 = 0;
							int pcnt3 = 0;
							int mcnt3 = 0;
							for(int j = 0; j < srr[i].length(); j++) {
								if(isDot && srr[i].charAt(j) == '.') {
									dotcnt++;
								} else {
									isDot = false;
									if(dotcnt != R*cnt1+S*cnt2+C*cnt3) {
										continue chk1;
									}
									if(srr[i].charAt(j) == '(') {
										pcnt1++;
									} else if(srr[i].charAt(j) == ')') {
										mcnt1++;
									} else if(srr[i].charAt(j) == '{') {
										pcnt2++;
									} else if(srr[i].charAt(j) == '}') {
										mcnt2++;
									} else if(srr[i].charAt(j) == '[') {
										pcnt3++;
									} else if(srr[i].charAt(j) == ']') {
										mcnt3++;
									}
								}
							}
							dotcnt=0;
							cnt1 = cnt1+pcnt1-mcnt1;
							cnt2 = cnt2+pcnt2-mcnt2;
							cnt3 = cnt3+pcnt3-mcnt3;
						}
						
						cnt1 = 0;
						cnt2 = 0;
						cnt3 = 0;
						
						for(int i = 0; i<srr2.length; i++) {
							int pcnt1 = 0;
							int mcnt1 = 0;
							int pcnt2 = 0;
							int mcnt2 = 0;
							int pcnt3 = 0;
							int mcnt3 = 0;
							for(int j = 0; j < srr2[i].length(); j++) {
								if(j==0) {
									if(result[i] != -2 && result[i] != R*cnt1+S*cnt2+C*cnt3) {
										result[i] = -1;
									} else {
										result[i] = R*cnt1+S*cnt2+C*cnt3;
									}
								}
								if(srr2[i].charAt(j) == '(') {
									pcnt1++;
								} else if(srr2[i].charAt(j) == ')') {
									mcnt1++;
								} else if(srr2[i].charAt(j) == '{') {
									pcnt2++;
								} else if(srr2[i].charAt(j) == '}') {
									mcnt2++;
								} else if(srr2[i].charAt(j) == '[') {
									pcnt3++;
								} else if(srr2[i].charAt(j) == ']') {
									mcnt3++;
								}
							}
							cnt1 = cnt1+pcnt1-mcnt1;
							cnt2 = cnt2+pcnt2-mcnt2;
							cnt3 = cnt3+pcnt3-mcnt3;
						}
					}
				}
			}
			
			sb.append("#").append(tc).append(" ");
			for(int i = 0 ; i<q; i++) {
				sb.append(result[i]+" ");	
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
