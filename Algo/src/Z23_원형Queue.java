
/**
 * 원형Queue
 */

public class Z23_원형Queue {
	
	public static int q[] = new int[5];
	public static int front = 0; // 첫 원소 한칸 전을 가리킴
	public static int rear = 0; // 마지막 원소를 가리킴

	
	public static boolean isEmpty() {
		return front == rear;
	}
	
	public static int deQueue() {
		if(isEmpty()) { // 큐가 비었으면
			System.out.println("Queue underflow error~!");
			return -1;
		} else { // 데이터가 있으면 넘겨주기
			front++;
			if(front == q.length) front = 0;
//			front = (front+1) % q.length;
			return q[front];
		}
	}
	
	
	public static boolean isFull() {
		return ((rear+1) == q.length ? 0 : rear+1) == front ;
	}
	
	public static void enQueue (int data) {
		if (isFull()) { //공간이 없으면
			System.out.println("Queue overflow error~!");
		} else { // 남아있으면 넣어주기
			rear++;
			if(rear == q.length) {
				rear = 0;
			}
//			rear = (rear+1) % q.length; // 위 코드로 대체 가능
			q[rear] = data;
		}
	}
	
	public static void main(String[] args) {
		// 가장 중요
//		q[++rear] = 1; // 큐에 삽입
//		q[++rear] = 1;
//		q[++rear] = 1;
//		
//		System.out.println(q[++front]); // 큐 삭제
//		System.out.println(q[++front]);
//		System.out.println(q[++front]);
		
		
		enQueue(1);
		enQueue(2);
		enQueue(3);
		enQueue(4);
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());
		enQueue(6); // 배열로 만든 선형큐의 문제점
	} // end of main
} // end of class
