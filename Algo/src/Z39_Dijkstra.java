import java.util.Arrays;

/**
 * 다익스트라 Dijkstra
 * 하나의 정점에서 시작해서 각각의 정점까지 최단거리를 구하는 알고리즘
 * 음이 아닌 가중치에서만 사용 가능
 * O(n^2)
 * 
 * 모든 정점에서 출발해서 각각의 모든 정점까지의 최단거리를 구하려면?
 * 다익스트라 * n(정점의 개수만큼 반복) = O(n^3)
 * = 플로이드 워샬 알고리즘 O(n^3) 코드가 간단
 * 
 */
public class Z39_Dijkstra {
	public static void main(String[] args) {
		final int M = Integer.MAX_VALUE;
		int[][] G = {
				{0, 3, 5, M, M, M},
				{M, 0, 2, 6, M, M},
				{M, 1, 0, 4, 6, M},
				{M, M, M, 0, 2, 3},
				{3, M, M, M, 0, 6},
				{M, M, M, M, M, 0}
		};
		
		int s = 0; // 시작정점
		int[] D = G[s].clone(); // 시작정점의 진출차수를 기준으로 가중치 배열을 초기화
		boolean[] used = new boolean[G.length]; // 사용한 정점을 저장할 배열 visited
		
		for (int i = 0; i < G.length; i++) { // 정점의 개수만큼 반복: 한 사이클 돌면, 정점 1개가 선택됨
			// 사용하지 않은 정점 중, 최소가중치 정점을 찾아서 추가
			int minIndex = -1; // 최소가중치의 index
			int min = M; // 최소가중치 값
			
			for (int j = 0; j < D.length; j++) {
				if(!used[j] && min > D[i]) {
					minIndex = j;
					min = D[j];
				}
			}
			//최소 가중치를 가진 정점을 선택, 정점번호 : minIndex
			used[minIndex] = true; // 사용한 집합에 표시
			
			// 최소 가중치의 정점을 선택해서 그 정점을 통해서 갈 수 있는 인접한 정점의 값을 업데이트
			for (int j = 0; j < D.length; j++) {
				// 사용하지 않은 정점 && 인접한 저점 && 가중치가 작아지면 업데이트
				if(!used[j] && G[minIndex][j] != M 
						&& D[j] > D[minIndex] + G[minIndex][j]) {
					
				}
			}
		}
		System.out.println(Arrays.toString(D)); // 가중치 배열
		
		System.out.println(D[1]); // a정점에서 출발해서 b 정점까지의 최단거리 
		System.out.println(D[2]); // a정점에서 출발해서 c 정점까지의 최단거리 
		System.out.println(D[3]); // a정점에서 출발해서 d 정점까지의 최단거리
	}//end main
}//end class
