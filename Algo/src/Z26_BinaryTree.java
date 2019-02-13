import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.StringTokenizer;

public class Z26_BinaryTree {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine());
		int[] tree= new int[1<<V];
		tree[1] = 1;
		String s = "1 2 1 3 2 4 3 5 3 6 4 7 5 8 5 9 6 10 6 11 7 12 11 13";
		StringTokenizer st = new StringTokenizer(s, " ");
		
		int[] arr = new int[1<<V];
		arr[1] = 1;
		// 이진트리 삽입
//		while(st.hasMoreTokens()) {
//			int start = Integer.parseInt(st.nextToken()); // 간선의 시작정점
//			int end = Integer.parseInt(st.nextToken()); // 간선의 끝 정점
//			
//			for(int i =1; i<arr.length; i++) { // 0번 정점은 안씀, start 정점값이 저장된 배열의 위치 찾기
//				if(start == arr[i]) {
//					//간선에서 자식 정점을 저장, 왼쪽자식이 없으면 왼쪽에 저장, 왼쪽 자식이 있으면 오른쪽에 저장
//					if(arr[i*2] == 0) { // 왼쪽 자식이 없는경우
//						arr[i*2] = end;
//					} else {//왼쪽자식 있는 경우
//						arr[i*2+1] = end;
//					}
//					break;
//				}
//			}
//		}
//		
//		HashSet<Integer> hs = new HashSet<>();
//		for(int i = 1; i<14; i++) {
//			hs.add(1<<i);
//		}
		
		
//		for (int i = 1; i < arr.length; i++) {
//			if(hs.contains(i)) System.out.println();
//			System.out.print(arr[i]+" ");
//		}
		
		//이진트리 순회
		preOrder(arr, 1);
		System.out.println();
		inOrder(arr, 1);
		System.out.println();
		postOrder(arr, 1);
		
		
		while(st.hasMoreTokens()) {
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			int index = 0;
			for (int i = 1; i < tree.length; i++) {
				if(tree[i] == parent) {
					index = i;
					break;
				}
			}
			if(tree[index*2] == 0) {
				tree[index*2] = child;
			} else {
				tree[index*2 + 1] = child;
			}
		}
		System.out.println(Arrays.toString(tree));
		boolean[] visit= new boolean[64];
		visit[0] = true;
		int node = 1;
		int cnt = 1;
		while(true) {
			if(visit[node] == false && tree[node] != 0) {
				visit[node] = true;
				cnt++;
				System.out.print(tree[node] + " ");
			}
			
			if(node * 2 >= visit.length) {
				node= node/2;
				continue;
			}
			if(visit[node*2] == false && tree[node*2] != 0) {
				node = node*2;
			} else if(visit[node*2] == false && tree[node*2] == 0){
				visit[node*2] = true;
				cnt++;
			} else if(visit[node*2+1] == false && tree[node*2+1] != 0) {
				node = node*2+1;
			} else if(visit[node*2+1] == false && tree[node*2+1] == 0) {
				visit[node*2+1] = true;
				cnt++;
			}else {
				node = node/2;
				//System.out.println(node);
			}
			
			if(cnt == visit.length || node==0) break;
		}
	}
	
	//전위순회
	public static void preOrder(int[] arr, int index) {
		// 부모(나)
		System.out.print(arr[index]+" ");
		
		// 왼쪽자식
		if(index*2 < arr.length && arr[index*2] != 0) {
			preOrder(arr, index*2);
		}
		// 오른쪽자식
		
		if(index*2+1 < arr.length && arr[index*2+1] != 0) {
			preOrder(arr, index*2+1);
		}
	}
	//중위순회
	public static void inOrder(int[] arr, int index) {
		// 왼쪽자식
		if(index*2 < arr.length && arr[index*2] != 0) {
			inOrder(arr, index*2);
		}
		// 부모(나)
		System.out.print(arr[index]+" ");
		// 오른쪽자식
		
		if(index*2+1 < arr.length && arr[index*2+1] != 0) {
			inOrder(arr, index*2+1);
		}
	}
	
	//후위순회
	public static void postOrder(int[] arr, int index) {
		// 왼쪽자식
		if(index*2 < arr.length && arr[index*2] != 0) {
			postOrder(arr, index*2);
		}
		// 오른쪽자식
		if(index*2+1 < arr.length && arr[index*2+1] != 0) {
			postOrder(arr, index*2+1);
		}
		// 부모(나)
		System.out.print(arr[index]+" ");
	}
}
