package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3378_스타일리쉬들여쓰기_홍휘진 {
	
	static int p,q;
	static int[] ansArray;
	
	static int findIndent(String line) {
		if (line.charAt(0) == '.') {
			int idx = 1;
			while (idx < line.length() && line.charAt(idx) == '.')
				idx++;
			return idx;
		}
		return 0;
	}
	
	static int findIndentAns(String line, int[] indent, int[] gualho) {
		int indentNum = 0;
		for (int i = 0; i < gualho.length; i++) {
			if (gualho[i] != 0 && indent[i] == 0) {
				return -1;
			}
			indentNum += indent[i] * gualho[i];
		}
		return indentNum;
	}
	
	static void nextGualHo(String line, int[]gualho) {
		for (int j = 0; j < line.length(); j++) {
			switch (line.charAt(j)) {
			case '(':
				gualho[0]++;
				break;
			case ')':
				gualho[0]--;
				break;
			case '{':
				gualho[1]++;
				break;
			case '}':
				gualho[1]--;
				break;
			case '[':
				gualho[2]++;
				break;
			case ']':
				gualho[2]--;
				break;
			default:
				break;
			}
		}
	}
	
	static boolean detectMaster(String[] lines, int[]indent) {
		int []gualho = new int[3];
		for (int i = 0; i < p; i++) {
			int lineIndex = findIndent(lines[i]);
			int masterAns = findIndentAns(lines[i], indent, gualho);
			if (masterAns != lineIndex) {
				return false;
			}
			nextGualHo(lines[i], gualho);
		}
		return true;
	}
	
	static void recordingAns(String[] mylines, int []indent) {
		int []gualho = new int[3];
		for (int i = 0; i < q; i++) {
			int nowAns = findIndentAns(mylines[i], indent, gualho);
			if(ansArray[i] != 0 && ansArray[i] != nowAns) {
				ansArray[i] = -1;
			}
			else {
				ansArray[i] = nowAns;
			}
			nextGualHo(mylines[i], gualho);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());
			
			int []indent = new int[3];
			String[] lines = new String[p];
			for (int i = 0; i < p; i++) {
				lines[i] = br.readLine().trim();
			}
			ansArray = new int[q];
			String[] mylines = new String[q];
			for (int i = 0; i < q; i++) {
				mylines[i] = br.readLine().trim();
			}
			
			for (int i = 0; i < 20; i++) {
				indent[0]++;
				for (int j = 0; j < 20; j++) {
					indent[1]++;
					for (int k = 0; k < 20; k++) {
						indent[2]++;
						if(detectMaster(lines, indent)) {
							recordingAns(mylines, indent);
						}
					}
					indent[2] = 0;
				}
				indent[1] = 0;
			}
			
			System.out.print("#" + t + " ");
			for (int i = 0; i < q; i++) {
				System.out.print(ansArray[i] + " ");
			}
			System.out.println();
		} // end of for
	}
}
