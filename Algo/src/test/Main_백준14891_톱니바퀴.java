package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준14891_톱니바퀴 {
	private static String[][] circle;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//12시방향부터 시계방향 순서대로 주어진다. N극은 0, S극은 1로
		circle = new String[5][8];
		for(int i = 1; i <= 4; i++) {
			circle[i] = br.readLine().split("");
		}
		
		int K = Integer.parseInt(br.readLine().trim());
		for(int i = 0; i < K; i++) {
			int[] flag = new int[5]; //각 톱니바퀴의 회전방향 저장
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken()); //1시계, -1반시계
			
			flag[num] = dir;
			for(int j = num+1; j <= 4; j++) {
				if(!(circle[j][6].equals(circle[j-1][2]))) {
					flag[j] = flag[j-1] * (-1);
				}else {
					break;
				}
			}
			for(int j = num-1; j >= 1; j--) {
				if(!(circle[j][2].equals(circle[j+1][6]))) {
					flag[j] = flag[j+1] * (-1);
				}else {
					break;
				}
			}
			
			for(int j = 1; j <= 4; j++) {
				if(flag[j] == 1) {
					right(j);
				}else if(flag[j] == -1) {
					left(j);
				}
			}
		}
		
		int sum = 0;
		if(circle[1][0].equals("1")) sum += 1;
		if(circle[2][0].equals("1")) sum += 2;
		if(circle[3][0].equals("1")) sum += 4;
		if(circle[4][0].equals("1")) sum += 8;
		System.out.println(sum);
		
	}//end main
	
	//시계방향
	public static void right(int num) {
		String idx7 = circle[num][7];
		for(int i = 7; i >= 1; i--) {
			circle[num][i] = circle[num][i-1];
		}
		circle[num][0] = idx7;
	}
	
	//반시계방향
	public static void left(int num) {
		String idx0 = circle[num][0];
		for(int i = 0; i < 7; i++) {
			circle[num][i] = circle[num][i+1];
		}
		circle[num][7] = idx0;
	}
	
}//end class
