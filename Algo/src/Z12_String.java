
public class Z12_String {
	public static void main(String[] args) {
		
		String s = "abc"; // 길이만큼 칸을 만듬
		System.out.println(s + "xyz");
		
		
		//기본적으로 파라미터 글자 + 16칸의 빈공간을 만듬 파라미터로 숫자를 넣을땐 그 숫자만큼 길이로 만듬
		StringBuilder sb = new StringBuilder("abc"); //단일 쓰레드 
		StringBuffer sb2 = new StringBuffer(); // 멀티 쓰레드 synchronized 
		
		
		String a = "algorithm";
		String b = "";
		for(int i = a.length()-1; i>=0; i--) 
		{
			b += a.charAt(i);
		}
		a.contains(sb2);
		System.out.println(b);

	}
}
