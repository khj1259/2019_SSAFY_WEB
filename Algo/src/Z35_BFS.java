import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 교재 301쪽 연습문제2
 * input
 * 1 2 1 3 2 4 2 5 4 6 5 6 6 7 3 7
 * 
 * output
 * 1 2 3 4 5 7 6 or 1 3 2 7 5 4 6
 *
 */
public class Z35_BFS {
	public static void main(String[] args) {
		//그래프를 저장하는 방식 : 인접행렬, 인접리스트, 간선배열
		int[][] G = new int[8][8]; // 정점 0번 안씀
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		StringTokenizer st = new StringTokenizer(input, " ");
		while(st.hasMoreTokens()) {
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			G[s][e] = 1;
			G[e][s] = 1;
		}
		int[] q = new int[100]; // 선형 큐 생성
		int front = -1;
		int rear = -1;
		boolean[] visited = new boolean[8]; // 0은 안씀
		
		int v = 1; // 시작정점
		q[++rear] = v; // 시작정점 v를 큐에 삽입
		visited[v] = true; // 정점 v를 방문한 것으로 표시
		while(front != rear) { // 큐가 비어있지 않은 경우 반복
			v = q[++front];//큐의 첫번째 원소 반환 (책에서 t => v로 씀)
			System.out.print(v+" ");// 방문
			
//			for (int i = 1; i < visited.length; i++) {// v정점과 인접한 정점에 대해서
			for (int i = visited.length-1; i >=0; i--) {// v정점과 인접한 정점에 대해서
				if(G[v][i] != 0 && !visited[i]) { // 인접한 정점 && 방문하지 않은 정점
					q[++rear] = i; // 큐에 넣기
					visited[i] = true; // 방문한 것으로 표시
				}
			}
		}
		
	}//end of main
}//end of class
