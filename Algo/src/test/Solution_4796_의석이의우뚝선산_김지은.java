package test;
import java.io.IOException;
import java.util.Scanner;

public class Solution_4796_의석이의우뚝선산_김지은 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();
		for (int testCase = 1; testCase <= TC; testCase++) {
			int N = sc.nextInt();
			int[] h = new int[N];
			for (int i = 0; i < N; i++) {
				h[i] = sc.nextInt();
			}

			int cntUp = 0;
			int cnt = 0;
			boolean flag = false; //내려가면 true
			for (int i = 0; i < N - 1; i++) {
				if (h[i] < h[i + 1]) {
					if (flag) {
						cntUp = 0;
						flag = false;
					}
					cntUp++;
				} else if (h[i] == h[i + 1]) {
					cntUp = 0;
				} else { //내려감
					flag = true;
					cnt += cntUp;
				}
			}

			System.out.println("#" + testCase + " " + cnt);
		} // end of for testCase
	} // end of main
} // end of class
