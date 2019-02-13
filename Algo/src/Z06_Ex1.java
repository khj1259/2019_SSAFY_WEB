import java.util.Random;

public class Z06_Ex1 {
	public static void main(String[] args) {
		
//		double d = Math.random(); // java.lang 패키지는 임포트 없이 사용가능 - stl사용 불가일때도 이건 됨
		
		Random ran = new Random();
//		int num = ran.nextInt(10) + 1; //1<= num < 11
		
		int[][] m = new int[7][7];
		for (int i = 1; i < m.length-1; i++) {
			for (int j = 1; j < m[i].length-1; j++) {
				m[i][j] = ran.nextInt(10) + 1;
			}
		}
		
		for (int i = 1; i < m.length -1; i++) {
			m[i][0] = m[i][1];
			m[i][m.length-1] = m[i][m.length-2];
			m[0][i] = m[1][i];
			m[m.length-1][i] = m[m.length-2][i];
		}
		
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.printf(" %2d", m[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		
		int[] di = {-1, 1, 0, 0}; // 행의 차이값 상 하 좌 우
		int[] dj = {0, 0, -1, 1}; // 열의 차이값

		int total = 0;
		//인접칸과의 절대값 구하기
		for (int i = 1; i < m.length-1; i++) {
			for (int j = 1; j < m[i].length-1; j++) {
				int sum = 0; // i, j 칸에서 인접칸과의 절대값의 합
				for (int k = 0; k < dj.length; k++) {
					if(i+di[k] < 0 || j+dj[k] < 0 || i+di[k] == m.length || j+dj[k] == m.length) continue;
					int num = m[i][j] - m[i+di[k]][j+dj[k]]; // 상 하 좌 우
					if(num < 0) {
						num = -num;
					}
					sum += num;
				}
				total += sum;
				System.out.printf(" %2d", sum);
			}
			System.out.println();
		}
		
		
		Random r = new Random(); // 임포트
		
		int[][] tree = new int[7][7];
		int cnt = 0;
		for(int i =1 ; i < tree.length; i++) {
			for (int j = 1; j < tree[i].length; j++) {
				tree[i][j] = r.nextInt(10)+1;
			}
		}
		
		int[] dx = {0,0,1,-1};
		int[] dy = {-1,1,0,0};
		
		int sum = 0;
		
		for(int i =1 ; i < 6; i++) {
			for (int j = 1; j < 6; j++) {
				for(int k = 0; k<4; k++) {
					if(tree[i+dy[k]][j+dx[k]] != 0) {
						sum += Math.abs(tree[i][j] - tree[i+dy[k]][j+dx[k]]);
					}
				}
			}
		}
		
		System.out.println(sum);
		
		
		
	}
}
