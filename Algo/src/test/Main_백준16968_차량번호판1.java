package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준16968_차량번호판1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] rule = br.readLine().split("");
		//c:문자 26가지, d:숫자 10가지
		int cnt = 1;
		int c = 26;
		int d = 10;
		for (int i = 0; i < rule.length; i++) {
			if(rule[i].equals("d")) {
				if(i-1 >= 0 && rule[i-1].equals("d")) {
					d = 9;
				}else {
					d = 10;
				}
				cnt *= d;
			}else {
				if(i-1 >= 0 && rule[i-1].equals("c")) {
					c = 25;
				}else {
					c = 26;
				}
				cnt *= c;
			}
		}
		
		System.out.println(cnt);
		
	}//end main
}//end class
