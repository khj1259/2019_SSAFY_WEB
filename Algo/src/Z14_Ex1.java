
public class Z14_Ex1 {

	public static void main(String[] args) {
		char[] stack = new char[10000];
		int top = -1;
		
		boolean isTrue = true;
		String s = "((()))(())(()()";
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '(') {
				stack[++top] =	s.charAt(i); 
			} else if(s.charAt(i) == ')') {
				if(top < 0) {
					isTrue = false;
					break;
				} else {
					if(stack[top--] != '(') {
						isTrue = false;
						break;
					}
				}
			}
		}
		isTrue = top < 0 ? true : false; 
		
		if(isTrue) {
			System.out.println("정답");
		} else {
			System.out.println("오답");
		}
		
	}
}
