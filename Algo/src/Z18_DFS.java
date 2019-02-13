import java.util.Arrays;

public class Z18_DFS {

	public static void main(String[] args) {
		
		int[][] G = { // 그래프에서 연결된 정점들의 간선정보를 저장
				{}, // 정점 0에 인접한 정점, 안씀 버림
				{2,3}, // 정점 1에 인접한 정점
				{1,4,5}, // 정점 2에 인접한 정점
				{1,7}, // 정점 3에 인접한 정점
				{2,6}, // 정점 4에 인접한 정점
				{2,6}, // 정점 5에 인접한 정점
				{4,5,7}, // 정점 6에 인접한 정점
				{3,6}, // 정점 7에 인접한 정점
		};
		
		int[][] tree = new int[8][8];
		tree[1][2] = 1;
		tree[2][1] = 1;
		tree[1][3] = 1;
		tree[3][1] = 1;
		tree[2][4] = 1;
		tree[4][2] = 1;
		tree[2][5] = 1;
		tree[5][2] = 1;
		tree[4][6] = 1;
		tree[6][4] = 1;
		tree[5][6] = 1;
		tree[6][5] = 1;
		tree[6][7] = 1;
		tree[7][6] = 1;
		tree[3][7] = 1;
		tree[7][3] = 1;
		
		int[] stack = new int[10];
		int top = -1;
		boolean[] visited = new boolean[8];
		
		// 시작 정점 하나를 결정 후 방문, 스ㅐㄱ에 넣고, 반복을 시작
		int v = 1; // 시작정점 A를 의미;
		System.out.print(v+ " "); //방문해서 할일
		visited[v] = true; //방문여부 체크
		stack[++top] = v; // 마지막의 갈림길을 확인하기 위해 지나가는 정점들을 저장
		
		//반복, 스택에서 값을 꺼내서 인접한 정점중에 방분 안한 정점을 찾아서 방문
		
		while(top > -1) { //반복종료 : 스택이 비어지면 종료
			v = stack[top]; // 마지막 정점을 읽어옴(삭제는 안함)
			int w = -1; // 다음 갈 정점, 플래그 변수 역할
			for (int i = 0; i < G[v].length; i++) { //인접한 정점 만큼 반복
				if(!visited[G[v][i]]) {// 방문하지 않았으면
					w = G[v][i]; // 다음갈 정점을 저장
					System.out.print(w + " ");//방문해서 할일
					visited[w] = true; //방문여부 체크
					stack[++top] = w; //스택에 마지막 갈림길 저장
					break; //확인이 되면 반복을 빠져나감
				}
			}
			if(w == -1) { // 인접한 정점중에 방문 안한 정점이 없음
				top--;
			}
		}
		
		
		
//		
//		int[] visit = new int[8];
//		int top = 0;
//		int[] log = new int[8];
//		visit[1] = 1;
//		log[0] = 1;
//		int key;
//		int cnt = 0;
//X:		while (top >= 0) {
//			key = log[top];
//			for(int i = G[key].length-1; i>=0; i--) {
//				if(visit[G[key][i]] == 0) {
//					visit[G[key][i]] = 1;
//					log[++cnt] = G[key][i];
//					top++;
//					continue X;
//				}
//			}
//			top--;
//		}
		
	}
}
