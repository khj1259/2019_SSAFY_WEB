package workshop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1240_SW문제해결응용1일차_단순2진암호코드_김현정 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		
		for(int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());//배열의 세로 크기
			int M = Integer.parseInt(st.nextToken());//배열의 가로 크기
			br.readLine();
			int sum1=0;
			int sum2=0;
//			int[][] code = new int[N][M];
			for(int k=0; k<N; k++) {
				String code = br.readLine();//여러번 
				
				if(code.contains("1")) {
					String[] arr = code.split("");
					int last = code.lastIndexOf("1");
					int[] codeArr = new int[8];
					int idx=0;
					
					for(int i=last-55; i<49; i=i+7) {
						String num = "";
						for(int j=i; j<i+7; j++) {
							num += arr[j];
						}
						if(num.equals("0001101")) { //0
							codeArr[idx++] = 0;
						}else if(num.equals("0011001")) {//1
							codeArr[idx++] = 1;
						}else if(num.equals("0010011")) {//2
							codeArr[idx++] = 2;
						}else if(num.equals("0111101")) {//3
							codeArr[idx++] = 3;
						}else if(num.equals("0100011")) {//4
							codeArr[idx++] = 4;
						}else if(num.equals("0110001")) {//5
							codeArr[idx++] = 5;
						}else if(num.equals("0101111")) {//6
							codeArr[idx++] = 6;
						}else if(num.equals("0111011")) {//7
							codeArr[idx++] = 7;
						}else if(num.equals("0110111")) {//8
							codeArr[idx++] = 8;
						}else if(num.equals("0001011")) {//9
							codeArr[idx++] = 9;
						}
					}
					
					
					for(int i=0; i<codeArr.length; i++) {
						if(i+1%2==1) {//홀수자리
							sum1 += codeArr[i];
						}else {//짝수자리
							sum2 += codeArr[i];
						}
					}
				}
				if((sum1*3+sum2)%10==0) {//검증코드 맞음
					System.out.println("#"+testCase+" "+sum1+sum2);
				}else {//검증코드 틀림
					System.out.println("#"+testCase+" "+0);
				}
			}
		}//end testCase
		
	}//end main
}//end class
