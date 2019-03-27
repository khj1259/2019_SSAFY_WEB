package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_5643_Professional_키순서_김현정 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine().trim()); // 학생 수
			int M = Integer.parseInt(br.readLine().trim()); // 비교 횟수

			ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

			for (int i = 0; i <= N; i++) {
				graph.add(new <Integer>ArrayList());
			}

			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph.get(a).add(b);
			}

			boolean[] visited = new boolean[N+1];
			
			
//			//그래프 출력 확인
//			for (int i = 1; i <= N; i++) {
//				Iterator<Integer> iter = graph.get(i).iterator();
//				System.out.print(i);
//				if (iter.hasNext())
//					System.out.print("-");
//				while (iter.hasNext())
//					System.out.print(iter.next() + " ");
//				System.out.println("");
//			}
			
			

		} // end testCase

	}// end main
}// end class
