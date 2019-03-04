package homework;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1462_보물섬_이재우 {
	static boolean visit[][];
	static String map[][];
	static int ga, se;
	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, -1, 0, 1 }; // 하 좌 상 우
	static int dist[][];
	static int ans = 0;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		se = s.nextInt();
		ga = s.nextInt();

		map = new String[se][ga];
		for (int i = 0; i < se; i++) {
			map[i] = s.next().split("");
		}

		for (int i = 0; i < se; i++) {
			for (int j = 0; j < ga; j++) {
				Queue<Point> q = new LinkedList<Point>();
				visit = new boolean[se][ga];
				dist = new int[se][ga];
				
				if(map[i][j].equals("W")) continue;
				
				
				visit[i][j] = true;
				q.add(new Point(i, j));
				int temp = 0;

				while (!q.isEmpty()) {
					Point p = q.poll();
					int x = p.x;
					int y = p.y;

					for (int k = 0; k < 4; k++) {
						int nx = dx[k] + x;
						int ny = dy[k] + y;

						if (0 <= nx && nx < ga && 0 <= ny && ny < se) {
							if (!visit[ny][nx] && map[ny][nx].equals("L")) {
								q.add(new Point(ny, nx));
								dist[ny][nx] = dist[y][x] + 1;
								visit[ny][nx] = true;

								if (temp < dist[ny][nx]) {
									temp = dist[ny][nx];
								}
							}
						}
					}
				}
				if (ans < temp) {
					ans = temp;
				}
			}
		}
		System.out.println(ans);
	}

	public static class Point {
		int x;
		int y;

		Point(int y, int x) {
			this.x = x;
			this.y = y;
		}
	}
}
