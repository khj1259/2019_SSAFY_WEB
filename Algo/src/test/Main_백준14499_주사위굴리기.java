package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준14499_주사위굴리기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); //지도 세로크기
		int M = Integer.parseInt(st.nextToken()); //지도 가로크기
		int x = Integer.parseInt(st.nextToken()); //주사위 x좌표
		int y = Integer.parseInt(st.nextToken()); //주사위 y좌표
		int K = Integer.parseInt(st.nextToken()); //명령의 개수
		int[][] map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		//동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4
		int[] cube = new int[7];
		//주사위 전개도 : 1:아래, 2:뒤, 3:오른쪽, 4:왼쪽, 5:앞, 6:위
		for(int i = 0; i < K; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num == 1 && y+1 < M) { //동쪽
				y++;
				int tmp = cube[1];
				cube[1] = cube[3];
				cube[3] = cube[6];
				cube[6] = cube[4];
				cube[4] = tmp;
				if(map[x][y] == 0) {
					map[x][y] = cube[1];
				}else {
					cube[1] = map[x][y];
					map[x][y] = 0;
				}
				System.out.println(cube[6]);
			}else if(num == 2 && y-1 >= 0) { //서쪽
				y--;
				int tmp = cube[1];
				cube[1] = cube[4];
				cube[4] = cube[6];
				cube[6] = cube[3];
				cube[3] = tmp; 
				if(map[x][y] == 0) {
					map[x][y] = cube[1];
				}else {
					cube[1] = map[x][y];
					map[x][y] = 0;
				}
				System.out.println(cube[6]);
			}else if(num == 3 && x-1 >= 0) { //북쪽
				x--;
				int tmp = cube[1];
				cube[1] = cube[2];
				cube[2] = cube[6];
				cube[6] = cube[5];
				cube[5] = tmp;
				if(map[x][y] == 0) {
					map[x][y] = cube[1];
				}else {
					cube[1] = map[x][y];
					map[x][y] = 0;
				}
				System.out.println(cube[6]);
			}else if(num == 4 && x+1 < N) { //남쪽
//				System.out.println("남");
				x++;
				int tmp = cube[1];
				cube[1] = cube[5];
				cube[5] = cube[6];
				cube[6] = cube[2];
				cube[2] = tmp;
				if(map[x][y] == 0) {
					map[x][y] = cube[1];
				}else {
					cube[1] = map[x][y];
					map[x][y] = 0;
				}
				System.out.println(cube[6]);
			}
		}
	}//end main
}//end class
