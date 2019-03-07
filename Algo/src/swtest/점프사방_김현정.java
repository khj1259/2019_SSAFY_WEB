package swtest;

import java.util.Scanner;

public class 점프사방_김현정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int X = sc.nextInt(); // 행
			int Y = sc.nextInt(); // 열
			int N = sc.nextInt(); //참가자 수
			int[][] map = new int[X+1][Y+1];
			
			for(int i = 1; i <= X; i++) {
				for(int j = 1; j <= Y; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			int[][] person = new int[N][3];
			for(int i=0; i<N; i++) {
				person[i][0] = sc.nextInt();//시작 행
				person[i][1] = sc.nextInt();//시작 열
				person[i][2] = sc.nextInt();// 횟수
			}
			int f = sc.nextInt(); //함정 수
			for(int i=0; i<f; i++) {
				int fx = sc.nextInt();//함정 행
				int fy = sc.nextInt();//함정 열
				map[fx][fy] = -1;
			}
			
			int money = N * (-1000);
c:			for(int i=0; i<N; i++) {
				int px = person[i][0];
				int py = person[i][1];
				int num = map[px][py];
				for(int j=0; j<person[i][2]; j++) {
					int dir = num/10; //방향
					int su = num%10; //점프 칸수
					if(dir == 1) { // 우
						if(py+su > Y || map[px][py+su] == -1) {
							continue c;
						} 
						py += su;
						num = map[px][py];
					}else if(dir == 2) { // 하
						if(px+su > X || map[px+su][py] == -1) {
							continue c;
						} 
						px += su;
						num = map[px][py];
					}else if(dir == 3) { // 좌
						if(py-su < 0 || map[px][py-su] == -1) {
							continue c;
						} 
						py -= su;
						num = map[px][py];
					}else { // 상
						if(px-su < 0 || map[px-su][py] == -1) {
							continue c;
						} 
						px -= su;
						num = map[px][py];
					}
				}
				money = money + (num*100);
			}
			
			System.out.println("#"+tc+" "+money);
		}//end testCase
	}//end main
}//end class
