import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *	최소 신장 트리
 *	Prim	: 선택한 정점에서 인접한 간선중 최소 가중치의 간선을 선택해 나간다.
 *		Gready 설계기법
 *		우선순위큐를 구현해야함(힙을 구현)
 *	KRUSKAL : 최소 가중치의 간선을 선택해 나감
 *		서로소 집합을 구현해야함
 *
 inputdata : 정점개수 v, 간선개수 e , e개의 간선정보 정점1 정점 2 가중치
 7 11 
 0 1 32
 1 2 21
 5 4 40
 0 2 31
 5 3 18
 0 5 60
 2 4 46
 2 6 25
 4 6 51
 0 6 51
 3 4 34
 
 */

public class Z37_Prim_정용수 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		int[][] tree = new int[V][V];
		
		
		for(int i = 0; i < E; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int val = sc.nextInt();
			tree[x][y] = val;
			tree[y][x] = val;
		}
		
		Map<Integer, Vertices> map = new HashMap<>();
		Map<Integer, Vertices> map2 = new HashMap<>();
		List<Vertices> list = new ArrayList<>();
		for(int i = 0; i<V; i++) {
			if(i== 0) {
				Vertices v = new Vertices(0, i, i);
				map.put(i, v);
				list.add(v);
			} else {
				Vertices v = new Vertices(Integer.MAX_VALUE, i, i);
				map.put(i, v);
				list.add(v);
			}
		}
		
		Collections.sort(list);
		
		for(int j = 0; j < V; j++) {
			Vertices e = list.get(0);
			for(int i = 0; i<V; i++) {
				Vertices v = map.get(i);
				if(v != null &&  tree[e.ver][i] != 0 && tree[e.ver][i] < v.key) {
					v.key = tree[e.ver][i];
					v.pi = e.ver;
				}
			}
			map.remove(e.ver);
			map2.put(e.ver, e);
			list.remove(0);
			Collections.sort(list);
		}
		
		System.out.println("v\tpi\tval");
		for(int i = 0; i<V; i++) {
			Vertices v = map2.get(i);
			System.out.println(v.ver + "\t" + v.pi + "\t" + v.key);
		}
	}
	
	public static class Vertices implements Comparable<Vertices> {
		int key; //가중치
		int pi; //부모
		int ver;
		
		public Vertices(int key, int pi, int ver) {
			this.key = key;
			this.pi = pi;
			this.ver = ver;
		}

		public int compareTo(Vertices o) {
			return this.key - o.key;
		}
	}
}
