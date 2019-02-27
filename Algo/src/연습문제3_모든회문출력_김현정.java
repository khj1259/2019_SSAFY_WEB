import java.util.Scanner;

public class 연습문제3_모든회문출력_김현정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine(); 
		
		for (int i = 0; i < str.length(); i++) {
			for (int j = i+1; j < str.length(); j++) {
				if(str.charAt(i) == str.charAt(j)) { // 문자열중 현재 문자와 같은 문자가 있는 인덱스를 찾기
					String part = str.substring(i, j+1);
					String reverse = new StringBuffer(part).reverse().toString();
					if(part.equals(reverse)) {
						System.out.print(part+" ");
					}
				}
			}
		}
		
	}// end main
}// end class
