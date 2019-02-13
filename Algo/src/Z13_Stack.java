import java.util.Stack;

/**
 *	Stack : LIFO = 후입선출
 */

public class Z13_Stack {
	static int[] stack = new int[5];
	static int top = -1; //꼭대기 데이터의 위치를 가리킬 index
	public static void main(String[] args) {
		push(1);// 스택에 값을 넣기
		push(2);// 스택에 값을 넣기
		push(3);// 스택에 값을 넣기
		push(4);// 스택에 값을 넣기
		stack[++top] = 5;// 스택에 값을 넣기
		
		System.out.println(pop()); // 꼭대기(top)데이터를 삭제후 리턴받음;
		System.out.println(pop()); // 꼭대기(top)데이터를 삭제후 리턴받음;
		System.out.println(pop()); // 꼭대기(top)데이터를 삭제후 리턴받음;
		System.out.println(pop()); // 꼭대기(top)데이터를 삭제후 리턴받음;
		System.out.println(stack[top--]);
		
		Stack<Integer> s = new Stack<Integer>();
		s.push(3);
		s.isEmpty();
		
		System.out.println(s.size());
		s.pop();
		
		
	} // end of main
	
	/** 스택 에 데이터 넣기 */
	public static void push(int data) {
		if(isFull()) {
			System.out.println("overflow");
			return;
		}
		stack[++top] = data;
	}
	
	/** 스택의 데이터 삭제후 리턴 */
	public static int pop() {
		if(isEmpty()) {
			System.out.println("underflow");
			return -1;
		} else {
			return stack[top--];
		}
	}
	
	/** 스택이 꽉 찼는지 확인 */
	public static boolean isFull() {
		return stack.length -1 == top;
	}
	
	/** 스택이 비어있는지 확인 */
	public static boolean isEmpty() {
		return top < 0;
	}
	
} // end of class
