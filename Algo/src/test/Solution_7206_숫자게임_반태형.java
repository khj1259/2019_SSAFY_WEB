package test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Solution_7206_숫자게임_반태형 {
	static int[] ten= {10,100,1000,10000,100000};
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		for(int test_case=1;test_case<=T;++test_case) {
			int n=sc.nextInt();
			ans = 0;
			go(n, 0);
			System.out.println("#"+test_case+" "+ans);
		}
	}
	public static void go(int num, int turn) {
		if (num < 10) {
			if (turn > ans) ans = turn;
			return;
		}
		int len = getlength(num) - 1;
		for (int i = 1; i < (1 << len); ++i) {
			int temp = 1;
			int now = num;
			for (int j = len - 1; j >= 0; --j) {
				if ((i&(1 << j))>0) {
					temp *= (now / ten[j]);
					now %= ten[j];
				}
			}
			go(temp*now, turn + 1);
		}
	}
	public static int getlength(int num) {
		if (num == 0) return 1;
		int len = 0;
		while (num>0) {
			num /= 10;
			len++;
		}
		return len;
	}
	
	
}
