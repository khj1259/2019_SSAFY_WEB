package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_4366_정식이의은행업무_홍휘진 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
go:		for (int t = 1; t <= tc; t++) {
			String twoJin = br.readLine().trim();
			String threeJin = br.readLine().trim();
			StringBuilder sb2 = new StringBuilder(twoJin);
			StringBuilder sb3 = new StringBuilder(threeJin);
			
			for (int i = twoJin.length()-1; i >= 0; i--) {
				if(sb2.charAt(i) == '0') sb2.setCharAt(i, '1');
				else sb2.setCharAt(i, '0');
				
				for (int j = threeJin.length()-1; j>=0 ; j--) {
					for (int k = 0; k < 3; k++) {
						if (sb3.charAt(j) == k + '0') {
							sb3.setCharAt(j, (char) (((k + 1) % 3) + '0'));
							long two = Long.parseLong(sb2.toString(), 2);
							if (Long.parseLong(sb3.toString(), 3) == two) {
								System.out.println("#" + t + " " + two);
								continue go;
							}
							sb3.setCharAt(j, (char) (((k + 2) % 3) + '0'));
							if (Long.parseLong(sb3.toString(), 3) == two) {
								System.out.println("#" + t + " " + two);
								continue go;
							}
						}
					}
					sb3.setCharAt(j, threeJin.charAt(j));
				}
				sb2.setCharAt(i, twoJin.charAt(i));
			}
			
			
		} // end of for
	}
}
