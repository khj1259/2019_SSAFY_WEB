package homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_1082_화염에서탈출_홍휘진 {

	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { 1, -1, 0, 0 };
	static char[][] map;
	static int r, c;
	static boolean [][]check;
	static Deque<Node> b = new ArrayDeque<>();

	static class Node {
		int x;
		int y;
		int t;

		Node(int x, int y, int t) {
			this.x = x;
			this.y = y;
			this.t = t;
		}

		public String toString() {
			return "(x=" + x + ", y=" + y + ", t=" + t + ")";
		}
		
	}

	static void burn() {
		if(b.isEmpty())
			return;
		int prev = b.peek().t;
		while (!b.isEmpty() && b.peek().t == prev) {
			Node now = b.poll();
			for (int k = 0; k < 4; k++) {
				int ni = now.x + dx[k];
				int nj = now.y + dy[k];
				if (ni < 0 || ni >= r || nj < 0 || nj >= c)
					continue;
				if (map[ni][nj] == '.') {
					map[ni][nj] = '*';
					b.add(new Node(ni, nj, now.t + 1));
				}
			}

		}
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			map = new char[r][c];
			Node start = new Node(0, 0, 0);
			Node end = new Node(0, 0, 0);
			for (int i = 0; i < r; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < c; j++) {
					if (map[i][j] == 'S')
						start = new Node(i, j, 0);
					if (map[i][j] == 'D')
						end = new Node(i, j, 0);
					if (map[i][j] == '*')
						b.add(new Node(i, j, 0));
				}
			}
			check = new boolean[r][c];
			Deque<Node> q = new ArrayDeque<>();
			int prev = -1;
			q.add(start);
			check[start.x][start.y] = true;
			while (!q.isEmpty()) {
				Node now = q.poll();
				if (prev != now.t) {
					prev = now.t;
					burn();
				}
				for (int i = 0; i < 4; i++) {
					int nx = now.x + dx[i];
					int ny = now.y + dy[i];

					if (nx < 0 || nx >= r || ny < 0 || ny >= c || check[nx][ny])
						continue;

					if (nx == end.x && ny == end.y) {
						System.out.println(now.t + 1);
						return;
					}

					if (map[nx][ny] != '*' && map[nx][ny] != 'X') {
						check[nx][ny] = true;
						q.add(new Node(nx, ny, now.t + 1));
					}
				}

			}
			System.out.println("impossible");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
