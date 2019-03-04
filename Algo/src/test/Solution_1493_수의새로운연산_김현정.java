package test;

import java.util.Scanner;

public class Solution_1493_수의새로운연산_김현정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] pane = new int[1000][1000];
		int number = 1;
		for (int i = 1; i < pane.length; i++) {
			for (int j = 1; j <= i; j++) {
				pane[j][i-j+1] = number++;
			}
		} // 1사분면 점에 번호 붙이기
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int p = sc.nextInt();
			int q = sc.nextInt();
			int px = 0, py =0;
			int qx = 0, qy =0;

d:			for (int i = 1; i < pane.length; i++) {
				for (int j = 1; j < pane.length; j++) {
					if(pane[i][j] == p) {
						px = i;
						py = j;
					}
					if(pane[i][j] == q) {
						qx = i;
						qy = j;
					}
					if(px != 0 && qx != 0) {
						break d;
					} // 좌표를 찾았으므로 빠져나옴
				}
			} // p, q점의 좌표 찾기
			
			System.out.println("#"+testCase+" "+pane[px+qx][py+qy]);
		}
	}
}

