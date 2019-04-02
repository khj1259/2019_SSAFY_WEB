package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution_4261_빠른휴대전화키패드_홍휘진 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Character, String> dict = new HashMap<>();
		dict.put('b', "2");
		dict.put('a', "2");
		dict.put('c', "2");
		dict.put('d', "3");
		dict.put('e', "3");
		dict.put('f', "3");
		dict.put('g', "4");
		dict.put('h', "4");
		dict.put('i', "4");
		dict.put('j', "5");
		dict.put('k', "5");
		dict.put('l', "5");
		dict.put('m', "6");
		dict.put('n', "6");
		dict.put('o', "6");
		dict.put('p', "7");
		dict.put('q', "7");
		dict.put('r', "7");
		dict.put('s', "7");
		dict.put('t', "8");
		dict.put('u', "8");
		dict.put('v', "8");
		dict.put('w', "9");
		dict.put('x', "9");
		dict.put('y', "9");
		dict.put('z', "9");

		int tc = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String pattern = st.nextToken();
			int n = Integer.parseInt(st.nextToken());
			int ans = 0;
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < n; i++) {
				String now = st.nextToken();
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < now.length(); j++) {
					sb.append(dict.get(now.charAt(j)));
				}
				if (pattern.equals(sb.toString()))
					ans++;
			}
			System.out.println("#" + t + " " + ans);
		} // end of for
	}
}