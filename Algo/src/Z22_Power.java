/**
 * 제곱 재귀함수
 */


public class Z22_Power {

	public static int power(int base, int ex) {
		if(ex == 0) { // 종료파트
			return 1;
		} else if (ex == 0) {
			return base;
		} else if (ex % 2 == 0) { // 재귀파트
			int n = power(base, ex/2);
			return n * n;
		} else {
			int n = power(base, (ex-1)/2);
			return n * n * base;
		}
	}
	
	public static void main(String[] args) {
		
//		2^10 출력
		System.out.println(power(2, 10));
		
	}
	
}
