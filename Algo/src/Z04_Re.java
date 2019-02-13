import java.util.Arrays;

/**
 * 재귀 함수- 함수 내에서 자기 자신을 다시 호출하는 함수	
 */
public class Z04_Re {
	
	public static void a(int i) { // 재귀함수의 골격
		if(i >= 4) { // 종료파트
			System.out.println();
		} else { // 재귀파트
			System.out.print(i+" ");
			a(i+1);
		}
		
	}
	
	public static void main(String[] args) {
		
		for (int i = 0; i < 4; i++) {
			System.out.print(i+" ");
		}
		System.out.println();
		
		a(0);
//		0 1 2 3 4 5
		b(0, 5);
		c(0, 10, 2);
//		1~10 까지의 합
		d(10);
//		1~10 까지 합을 리턴
		sum = 0;
		System.out.println(e(10));
		
		int num = 1234;
//		int sum = 0;
//		for (; num>0;) {
//			sum += num%10;
//			num = num/10;
//		}
//		System.out.println(sum);
		
		
		//3자리 이진수로 만들수 있는 모든 경우의수를 출력
//		for (int i = 0; i < 2; i++) {
//			for (int j = 0; j < 2; j++) {
//				for (int k = 0; k < 2; k++) {
//					System.out.println(""+i+j+k);
//				}
//			}
//		}
		
		System.out.println(f(num,(""+num).length())); // 각자리 숫자의 합을 리턴하는 함수;
		//5자리 3진수로 만들수 있는 모든 경우의수를 출력
		
		
		//g(0, t);
		//순열로 재귀함수 구현
		System.out.println("===========순열출력==========");
		System.out.println();
		long a = System.currentTimeMillis();
		test2(0, new int[8]);
//		k(0, new int[9]);
		long b= System.currentTimeMillis();
		System.out.println(b-a);
	} //end of main
	static int www[] = {4,6,8,9};
	public static void test(int n, int[] arr) {
		if(n >= arr.length) {//종료파트
			System.out.println(Arrays.toString(arr));
		} else {//반복 재귀파트
			for(int i = 0; i<www.length; i++) {
				boolean isUse = false;
				for (int j = 0; j < n; j++) {
					if(arr[j] == www[i]) {
						isUse = true;
						break;
					}
				}
				if(!isUse) {
					arr[n] = www[i];
					test(n+1,arr);
				}
			}
		}
	}
	
	public static void test2(int n, int[] arr) {
		if(n >= arr.length) {//종료파트
			//System.out.println(Arrays.toString(arr));
		} else {//반복 재귀파트
			for(int i = 0; i<arr.length; i++) { // 0~10 까지의 숫자로 
				boolean isUse = false;  // 사용한 적이 있는지 플래그
				for (int j = 0; j < n; j++) {
					if(arr[j] == i) {
						isUse = true;
						break;
					}
				}
				if(!isUse) {
					arr[n] = i;
					test2(n+1,arr);
				}
			}
		}
	}
	
	
	public static void k(int n, int[] arr) {
		if(n >= arr.length) {//종료파트
			//System.out.println(Arrays.toString(arr));
//			for (int i = 0; i < arr.length; i++) {
//				System.out.println(www[arr[i]]);
//			}
		} else {//반복 재귀파트
			boolean[] chk = new boolean[arr.length]; // 사용한 숫자를 체크
			for ( int i = 0; i<n; i++) {
				chk[arr[i]] = true;
			}
			for(int i = 0; i<chk.length; i++) {
				if(!chk[i]) {
					arr[n] = i;
					k(n+1,arr);
				}
			}
		}
	}
	
	public static void g(int n, int[] arr) {
		if(n >= arr.length) {//종료파트
			System.out.println(Arrays.toString(arr));
		} else {//반복 재귀파트
			for(int i = 0; i<10; i++) {
				boolean isNum = false;
				for(int j = 0; j<arr.length; j++) {
					if(arr[j] == i) {
						isNum = true;
						break;
					}
				}
				
				if(!isNum) {
					arr[n] = i;
					g(n+1, arr);
				} else {
					continue;	
				}
				
			}
		}
	}
	
	public static void b(int i, int end) {
		if (i >= end) { //종료파트
			System.out.println();
		} else { //재귀파트
			System.out.print(i+" ");
			b(i+1,end);
		}
	}
	
	public static void c(int i, int end, int plus) {
		if (i >= end) {
			System.out.println();
		} else {
			System.out.print(i+" ");
			c(i+plus, end, plus);
		}
	}
	static int sum;
	public static void d(int i) {
		if(i == 0) {
			System.out.println(sum);
		} else {
			sum += i;
			d(i-1);
		}
	}
	
	public static int e(int i) {
		if(i == 0) {
			return 0;
		} else {
			return i+e(i-1);
		}
	}
	
	public static int f(int i, int leng) {
		if(leng < 1) {
			return 0;
		} else  {
			return i%10 + f(i/10,leng-1);
		}
		
	}
} // end of class
