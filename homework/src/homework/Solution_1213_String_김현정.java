package homework;

import java.util.Scanner;

public class Solution_1213_String_김현정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc=1; tc<=10; tc++) {
			sc.nextLine(); // 테스트케이스 번호
			String find = sc.nextLine();
			String st = sc.nextLine();
			
			String[] parts = st.split(find);
			int answer = parts.length-1;
			if(st.startsWith(find)) {
				answer++;
			}
			if(st.endsWith(find)) {
				answer++;
			}
			System.out.println("#"+tc+" "+answer);
		}
	}//end main
}//end class
