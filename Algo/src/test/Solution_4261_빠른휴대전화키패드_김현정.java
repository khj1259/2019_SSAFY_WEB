package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution_4261_빠른휴대전화키패드_김현정 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String S = st.nextToken();
			int N = Integer.parseInt(st.nextToken());
			String[] word = new String[N];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N; i++) {
				word[i] = st.nextToken();
			}
			//입력 끝
			//1, 2:abc, 3:def, 4:ghi, 5:jkl, 6:mno, 7:pqrs, 8:tuv, 9:wxyz
			HashMap<Character, Integer> keypad = new HashMap<>();
			keypad.put('a', 2);
			keypad.put('b', 2);
			keypad.put('c', 2);
			keypad.put('d', 3);
			keypad.put('e', 3);
			keypad.put('f', 3);
			keypad.put('g', 4);
			keypad.put('h', 4);
			keypad.put('i', 4);
			keypad.put('j', 5);
			keypad.put('k', 5);
			keypad.put('l', 5);
			keypad.put('m', 6);
			keypad.put('n', 6);
			keypad.put('o', 6);
			keypad.put('p', 7);
			keypad.put('q', 7);
			keypad.put('r', 7);
			keypad.put('s', 7);
			keypad.put('t', 8);
			keypad.put('u', 8);
			keypad.put('v', 8);
			keypad.put('w', 9);
			keypad.put('x', 9);
			keypad.put('y', 9);
			keypad.put('z', 9);
			int cnt = 0;
			for(int i = 0; i < word.length; i++) {
				StringBuilder sb = new StringBuilder();
				for(int j = 0; j < word[i].length(); j++) {
					sb.append(keypad.get(word[i].charAt(j)));
				}
				if(S.equals(sb.toString())) {
					cnt++;
				}
			}
			System.out.println("#"+tc+" "+cnt);
			
		}//end testCase
	}//end main
}//end class
