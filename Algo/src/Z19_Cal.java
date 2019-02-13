import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 *  +, * 계산기
 * 12 + 5 * 2 + 3 + 4 * 2
 */

public class Z19_Cal {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] stack = new int[30];
		int top = -1;
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		
		stack[++top] = Integer.parseInt(st.nextToken()); // 첫번째 피연산자를 숫자로 변환해서 스택에 저장
		while(st.hasMoreTokens()) {
			char op = st.nextToken().charAt(0); // 연산자
			int num = Integer.parseInt(st.nextToken());
			if(op == '+') {
				stack[++top] = num;
			} else { // *
				int pre = stack[top];
				stack[top] = pre * num;;
			}
		}
		int sum = 0;
		for(int i = 0; i <= top; i++) {
			sum += stack[i];
		}
		System.out.println(sum);
		
		
//		List<Integer> list = new ArrayList<>();
//		int cnt = 0;
//		int cnt2 = 0;
//		int acnt = 0;
//		int mcnt = 0;
//		int[] add = new int[10000];
//		int[] mul = new int[10000];
//		while (st.hasMoreTokens()) {
//			String key = st.nextToken();
//			if(key.equals("+")) {
//				add[acnt++] = cnt2++;
//			} else  if (key.equals("*")) {
//				mul[mcnt++] = cnt2++;
//			} else {
//				list.add(Integer.parseInt(key));
//			}
//		}
//		for(int i = 0; i<mcnt; i++) {
//			int index = mul[i];
//			list.set(index-i, list.get(index-i)*list.get(index+1-i));
//			list.remove(index+1-i);
//		}
//		int sum = 0;
//		for(int num2 : list) {
//			sum += num2;
//		}
//		System.out.println(sum);
	}
}
