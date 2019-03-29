import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo33_서울_06_김현정 {
	private static char[][] map;
	private static boolean find;
	private static int rr, cc;
	private static char block;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int R = Integer.parseInt(st.nextToken()); // 행  
			int C = Integer.parseInt(st.nextToken()); // 열
			map = new char[R+2][C+2]; //도면
			for(int i = 0; i < R; i++) {
				String tmp = br.readLine();
				for(int j = 0; j < C; j++) {
					map[i+1][j+1] = tmp.charAt(j);
				}
			}
			
			find = false;
			rr = 0; cc = 0;
			block = ' ';
			
b:			for(int i = 1; i <= R; i++) {
				for(int j = 1; j <= C; j++) {
					if(map[i][j] == '-') {
						left(i, j);
						right(i, j);
						if(find) break b;
					}else if(map[i][j] == '|') {
						up(i, j);
						down(i, j);
						if(find) break b;
					}else if(map[i][j] == '+') {
						left(i, j);
						right(i, j);
						up(i, j);
						down(i, j);
						if(find) break b;
						
					}else if(map[i][j] == '1') {
						right(i, j);
						down(i, j);
						if(find) break b;
					}else if(map[i][j] == '2') {
						up(i, j);
						right(i, j);
						if(find) break b;
					}else if(map[i][j] == '3') {
						up(i, j);
						left(i, j);
						if(find) break b;
					}else if(map[i][j] == '4') {
						left(i, j);
						down(i, j);
						if(find) break b;
					}
						
				}
			}
			
			
			System.out.println("#"+tc+" "+rr+" "+cc+" "+block);
		}//end TestCase
		
		
	}//end main
	
	public static void up(int r, int c) {
		if(map[r-1][c]=='.') {
			rr = r-1;
			cc = c;
			find = true;
			if((map[r-1][c-1] == '-' || map[r-1][c-1] == '+'|| map[r-1][c-1] == '1'|| map[r-1][c-1] == '2')&&
				(map[r-1][c+1]=='-'||map[r-1][c+1]=='+'||map[r-1][c+1]=='3'||map[r-1][c+1]=='4')&&
				(map[r-2][c]=='-'||map[r-2][c]=='+'||map[r-2][c]=='1'||map[r-2][c]=='4')) {
				block = '+';
			}else if(map[r-1][c-1] == '-' || map[r-1][c-1] == '+'|| map[r-1][c-1] == '1'|| map[r-1][c-1] == '2' ) {
				block = '4';
			}else if(map[r-1][c+1]=='-'||map[r-1][c+1]=='+'||map[r-1][c+1]=='3'||map[r-1][c+1]=='4') {
				block = '1';
			}else if(map[r-2][c]=='-'||map[r-2][c]=='+'||map[r-2][c]=='1'||map[r-2][c]=='4') {
				block = '|';
			}
		}
	}
	public static void down(int r, int c) {
		if(map[r+1][c]=='.') {
			rr = r+1;
			cc = c;
			find = true;
			if((map[r+1][c-1]=='-'||map[r+1][c-1]=='+'||map[r+1][c-1]=='1'||map[r+1][c-1]=='2')&&
				(map[r+1][c+1]=='-'||map[r+1][c+1]=='+'||map[r+1][c+1]=='3'||map[r+1][c+1]=='4')&&
				(map[r+2][c]=='|'||map[r+2][c]=='+'||map[r+2][c]=='2'||map[r+2][c]=='3')) {
				block = '+';
			}else if(map[r+1][c-1]=='-'||map[r+1][c-1]=='+'||map[r+1][c-1]=='1'||map[r+1][c-1]=='2') {
				block = '3';
			}else if(map[r+1][c+1]=='-'||map[r+1][c+1]=='+'||map[r+1][c+1]=='3'||map[r+1][c+1]=='4') {
				block = '2';
			}else if(map[r+2][c]=='|'||map[r+2][c]=='+'||map[r+2][c]=='2'||map[r+2][c]=='3') {
				block = '|';
			}
		}
	}
	public static void left(int r, int c) {
		if(map[r][c-1]=='.') {
			rr = r;
			cc = c-1;
			find = true;
			if((map[r-1][c-1]=='|'||map[r-1][c-1]=='+'||map[r-1][c-1]=='1'||map[r-1][c-1]=='4')&&
				(map[r+1][c-1]=='|'||map[r+1][c-1]=='+'||map[r+1][c-1]=='2'||map[r+1][c-1]=='3')&&
				(map[r][c-2]=='-'||map[r][c-2]=='+'||map[r][c-2]=='1'||map[r][c-2]=='2')) {
				block='+';
			}else if(map[r-1][c-1]=='|'||map[r-1][c-1]=='+'||map[r-1][c-1]=='1'||map[r-1][c-1]=='4') {
				block = '2';
			}else if(map[r+1][c-1]=='|'||map[r+1][c-1]=='+'||map[r+1][c-1]=='2'||map[r+1][c-1]=='3') {
				block = '1';
			}else if(map[r][c-2]=='-'||map[r][c-2]=='+'||map[r][c-2]=='1'||map[r][c-2]=='2') {
				block = '-';
			}
		}
		
	}
	public static void right(int r, int c) {
		if(map[r][c+1]=='.') {
			rr = r;
			cc = c+1;
			find = true;
			if((map[r-1][c+1]=='|'||map[r-1][c+1]=='+'||map[r-1][c+1]=='1'||map[r-1][c+1]=='4')&&
				(map[r+1][c+1]=='|'||map[r+1][c+1]=='+'||map[r+1][c+1]=='2'||map[r+1][c+1]=='3')&&
				(map[r][c+2]=='-'||map[r][c+2]=='+'||map[r][c+2]=='3'||map[r][c+2]=='4')) {
				block='+';
			}else if(map[r-1][c+1]=='|'||map[r-1][c+1]=='+'||map[r-1][c+1]=='1'||map[r-1][c+1]=='4') {
				block = '3';
			}else if(map[r+1][c+1]=='|'||map[r+1][c+1]=='+'||map[r+1][c+1]=='2'||map[r+1][c+1]=='3') {
				block = '4';
			}else if(map[r][c+2]=='-'||map[r][c+2]=='+'||map[r][c+2]=='3'||map[r][c+2]=='4') {
				block = '-';
			}
		}
		
	}
	
}//end class








