import java.util.Scanner;

public class Algo1_서울_06_김현정 {
	public static int N;
	public static String[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(sc.nextLine());
			map = new String[N][N];

			for (int i = 0; i < N; i++) {
				map[i] = sc.nextLine().split(" ");
			} // 입력 완료

			int answer = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j].equals("A")) { //상
						answer += up(i, j);
					} else if (map[i][j].equals("B")) {//좌우
						answer += left_right(i, j);
					} else if (map[i][j].equals("C")) {//상하좌우
						answer += up(i, j);
						answer += down(i, j);
						answer += left_right(i, j);
					}
				}
			}
			System.out.println("#"+tc+" "+answer);
		} // end testCase
		
	}// end main

	public static int down(int x, int y) {
		int cnt = 0;
		for (int i = x + 1; i < N; i++) {
			if (map[i][y].equals("S")) {
				cnt++;
			} else {
				break;
			}
		}
		return cnt;
	}

	public static int left_right(int x, int y) {
		int cnt = 0;
		for (int i = y - 1; i >= 0; i--) {
			if (map[x][i].equals("S")) {
				cnt++;
			} else {
				break;
			}
		}
		for (int i = y + 1; i < N; i++) {
			if (map[x][i].equals("S")) {
				cnt++;
			} else {
				break;
			}
		}
		return cnt;
	}

	public static int up(int x, int y) {
		int cnt = 0;
		for (int i = x - 1; i >= 0; i--) {
			if (map[i][y].equals("S")) {
				cnt++;
			} else {
				break;
			}
		}
		return cnt;
	}
}// end class
