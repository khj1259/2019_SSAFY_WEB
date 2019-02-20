package workshop;

import java.util.Scanner;

public class Solution_2007_패턴마디의길이_김현정{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for(int tc=1; tc<=T; tc++) {
			String st = sc.nextLine();
			int answer = 0;
			for(int i=0; i<st.length(); i++) {
				
				String st1 = st.substring(0, i+1);
				String st2 = st.substring(i+1, i+st1.length()+1);
				if(st1.equals(st2)) {
					answer = st1.length();
					break;
				}
			}
			
			
			System.out.println("#"+tc+" "+answer);
		}
	}//end main
}//end class
