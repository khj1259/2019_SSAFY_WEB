import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 중위표기식 - > 후위표기식으로변경하여 출력하기
 * input
 * 6 + 5 * ( 2 - 8 ) / 2
 * 2 + 3 * 4 / 5
 * 
 * output
 * 6 5 2 8 - * 2 / +
 * 2 3 4 * 5 / 5
 */

public class Z20_Cal2 {

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		char[] stackOp = new char[10]; //연산자를 저장할 스택
		char[] stack = new char[500];
		int[] num = new int[50];
		int cnt = 0;
		int top = -1;
		String[] str = sc.nextLine().split(" ");
		for (int i = 0; i < str.length; i++) {
			char c = str[i].charAt(0); //문자열의 첫 글자를 잘라옴
			switch (c) {
			case '(': // 무조건 스택에 저장해라, 우선순위 3
				stackOp[++top] = c;
				break;
			case '*': // 우선순위 2
			case '/': // 우선순위 2
				// 스택을 확인해서 나보다 우선순위가 낮으면 스택에 넣기, 나보다 우선순위가 높거나 같으면 빼기 pop
				while(top >= 0 && (stackOp[top] == '*' || stackOp[top] == '/')) {
					stack[cnt++] = stackOp[top];
					System.out.print(stackOp[top--] + " ");
				}
				stackOp[++top] = c;
				break;
			case '+': // 우선순위 1
			case '-': // 우선순위 1
				while(top >= 0 && (stackOp[top] == '*' || stackOp[top] == '/' || 
						stackOp[top] == '+' || stackOp[top] == '-')) {
					stack[cnt++] = stackOp[top];
					System.out.print(stackOp[top--] + " ");
				}
				stackOp[++top] = c;
				break;
			case ')': // 스택에 넣지는 않음, 스택에서 ( 나올때까지 pop한다
				while(top >= 0 && (stackOp[top] != '(')) {
					stack[cnt++] = stackOp[top];
					System.out.print(stackOp[top--] + " ");
				}
				if(top >= 0 && stackOp[top] == '(') {
					top--;
				}
				break;
			default: //숫자
				stack[cnt++] = c;
				System.out.print(str[i]+" ");
				break;
			}
			
		}
		// 토큰분석 작업이 다 끝난뒤에 스택에 남은 op빼내기
		while(top > -1) {
			stack[cnt++] = stackOp[top];
			System.out.print(stackOp[top--] + " ");
		}
		System.out.println();
		//System.out.println(Arrays.toString(stack));
		
		top = -1;
		int num1 = 0;
		int num2 = 0;
		for(int i = 0; i <cnt; i++) {
			switch (stack[i]) {
			case '*': // 우선순위 2
				num2 = num[top--];
				num1 = num[top--];
				num[++top] = num1 * num2;
				break;
			case '/': // 우선순위 2
				num2 = num[top--];
				num1 = num[top--];
				num[++top] = num1 / num2;
				break;
			case '+': // 우선순위 1
				num2 = num[top--];
				num1 = num[top--];
				num[++top] = num1 + num2;
				break;
			case '-': // 우선순위 1
				num2 = num[top--];
				num1 = num[top--];
				num[++top] = num1 - num2;
				break;
			default: //숫자
				num[++top] = stack[i] - '0';
				break;
			}
		}
		System.out.println(num[0]);
		sc.close();
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String str = br.readLine();
//		StringTokenizer st = new StringTokenizer(str, " ");
//		char[] stack = new char[30];
//		int top = -1;
//		while (st.hasMoreTokens()) {
//			String key = st.nextToken();
//			if(key.equals("(")) {
//				stack[++top] = key.charAt(0);
//			} else if (key.equals("+")){
//				if(top == -1 || stack[top] == '(') {
//					stack[++top] = key.charAt(0);	
//				} else {
//					while(!(top == -1 || stack[top] == '(')) {
//						System.out.print(stack[top--] + " ");
//					}
//					stack[++top] = key.charAt(0);
//				}
//			} else if (key.equals("-")){
//				if(top == -1 || stack[top] == '(') {
//					stack[++top] = key.charAt(0);	
//				} else {
//					while(!(top == -1 || stack[top] == '(')) {
//						System.out.print(stack[top--] + " ");
//					}
//					stack[++top] = key.charAt(0);
//				}
//			} else if (key.equals("*")){
//				if(top == -1 || stack[top] == '(' || stack[top] == '-' || stack[top] == '+' ) {
//					stack[++top] = key.charAt(0);	
//				} else {
//					while(!(top == -1 || stack[top] == '(' || stack[top] == '-' || stack[top] == '+' )) {
//						System.out.print(stack[top--] + " ");
//					}
//					stack[++top] = key.charAt(0);
//				}
//			} else if (key.equals("/")){
//				if(top == -1 || stack[top] == '(' || stack[top] == '-' || stack[top] == '+' ) {
//					stack[++top] = key.charAt(0);	
//				} else {
//					while(!(top == -1 || stack[top] == '(' || stack[top] == '-' || stack[top] == '+' )) {
//						System.out.print(stack[top--] + " ");
//					}
//					stack[++top] = key.charAt(0);
//				}
//			} else if (key.equals(")")){
//				while(stack[top] != '(') {
//					System.out.print(stack[top--]+" ");
//				}
//				top--;
//			} else {
//				System.out.print(key + " ");
//			}
//		}
//		
//		for(int i = top; i>=0; i--) {
//			System.out.print(stack[i] + " ");
//		}
		
	}
}
