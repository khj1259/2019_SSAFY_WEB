import java.util.Arrays;
import java.util.Scanner;

/**
 * MST(Minimum Spanning Tree) 최소 신장 트리
 * Prim(프림) : 선택한 정점에서 인접한 간선중에 최소 가중치의 정점을 선택해 나간다
 * 	ㄴGreedy 설계기법
 * 	  우선순위큐를 구현해야함(힙)
 * KRUSKAL : 최소 가중치의 간선을 선택해 나간다
 * 	ㄴ서로 소 집합(Disjoint Set) 을 구현해야함 
 */
/*
 * input <정점의 개수 : V, 간선의 개수 E, E개의 간선 정보 (정점1 정점2 가중치)>
7 11
0 1 32
0 2 31
0 5 60
0 6 51
1 2 21
2 4 46
2 6 25
3 4 34
5 3 18
5 4 40
4 6 51
 */
public class KRUSKAL_양희동 {
	public static int[] p;	// 부모를 저장할 배열
	public static int[] rank;	// 깊이
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();	// 정점의 개수
		int E = sc.nextInt();	// 간선의 개수
		
		p = new int[V];	// 부모를 저장할 배열
		rank = new int[p.length];	// 깊이
		
		Edge[] G = new Edge[E];	// 간선의 정보를 저장할 배열 = 간선배열
		for (int i = 0; i < E; i++) {
			G[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		
		// KRUSKAL : 서로 소 집합을 활용
		// 모든 정점들을 원소 1개짜리의 집합으로 만든다
		for (int i = 0; i < p.length; i++) {
			makeSet(i);
		}
		
		// 가중치를 기준으로 간선배열을 정렬한다
		Arrays.sort(G);	// compareTo 구현해야한다
		
		// 반복(간선이 N-1개 선택할 때까지)
		for (int i = 0, cnt = 0; i < E && cnt < V; i++) {
			// 가중치가 낮은 간선을 선택한다, 사이클이 발생하지 않는 정점
			Edge e = G[i];
			int pa = findSet(e.a);
			int pb = findSet(e.b);
			if(pa != pb) {	// 다른 집합일 때 (사이클이 발생하지 않음) 만 합치기
				union(pa, pb);	// 두 정점의 집합을 하나의 집합으로 합침
				System.out.println(e.a + "-" + e.b + " " + e.val);
				cnt++;
			}
		}
		
		
		
	}	// end of main
	
	/** 멤버 x를 포함하는 새로운 집합을 생성 */
	public static void makeSet(int x) {
		p[x] = x;	// 부모를 저장, 자기자신의 index or -1
	}
	
	/** 멤버 x, y를 포함하는 두 집합을 통합(서로 다른 집합일 때만 합쳐야함) */
	public static void union(int x, int y) {
		link(findSet(x), findSet(y));
	}
	
	/** 멤버 x를 포함하는 집합을 찾아서 대표자를 리턴 */
	public static int findSet(int x) {
		if (p[x] == x) {
			return x;
		} else {
			p[x] = findSet(p[x]);	// path Compression 대표자를 찾으면 저장
			return p[x];
		}
	}
	
	/** x대표자와 y대표자의 집합을 합침 */
	public static void link(int px, int py) {
		if(rank[px] > rank[py]) {
			p[py] = px;	// 작은 쪽을 큰쪽에 붙인다
		} else {
			p[px] = py;
			if(rank[px] == rank[py]) {
				rank[py]++;	// 두 대표자의 랭크값이 같은 경우는 랭크값이 1 증가한다
			}
		}
	}
	
	/** p배열을 출력하는 메서드 */
	public static void printSet() {
		System.out.print("index  : ");
		for (int i = 0; i < p.length; i++) {
			System.out.printf("%2d ", i);
		}
		System.out.println();
		
		System.out.print("parent : ");
		for (int i = 0; i < p.length; i++) {
			System.out.printf("%2d ", p[i]);
		}
		System.out.println();
		
		System.out.print("rank   : ");
		for (int i = 0; i < rank.length; i++) {
			System.out.printf("%2d ", rank[i]);
		}
		System.out.println("\n");		
	}
	
	public static class Edge implements Comparable<Edge> {
		int a;	// 정점1
		int b;	// 정점2
		int val;	// 가중치
		public Edge(int a, int b, int val) {
			this.a = a;
			this.b = b;
			this.val = val;
		}
		
		@Override
		public int compareTo(Edge e) {	// 간선의 가중치를 기준으로 정렬한다
			return this.val - e.val;
		}
	}	// end of class Edge
}