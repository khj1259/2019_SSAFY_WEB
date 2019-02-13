
public class Z30_비트 {
	public static void main(String[] args) {
		int n = 0b100110111; // 9자리
		
//		자리수 구하기
//		8.0 <= log(밑수2) n < 0.9
//		8 <= (int)(log(밑수2)n) < 9
//		(int)(log(밑수2)n) + 1 = 9
		int 자리수 = (int)(Math.log(n) / Math.log(2)) + 1;
		System.out.println(자리수); // 9
		
		for(int i = 0; i < 9; i++) {
			System.out.print((n&(1<<i)) == 0 ? 0 : 1);
		}
		
//		System.out.println((n & 0b1) == 0 ? 0 : 1); // 1 << 0
//		System.out.println((n & 0b10) == 0 ? 0 : 1);// 1 << 1
//		System.out.println((n & 0b100) == 0 ? 0 : 1);//1 << 2
		
		
		
		
		
	}//end main
}//end class
