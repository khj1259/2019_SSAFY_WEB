import java.util.Arrays;

class Z49_배낭01_DP_조동희 {
	public static void main(String[] args) {
		int n = 4,w = 10;
		int[][] k = new int[n+1][w+1];
//		int[][] item = {{10,5},{40,4},{30,6},{50,3}};
		
		int[] mulgan = {0,5,4,6,3};
		int[] value = {0,10,40,30,50};
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=w;j++) {
				if(mulgan[i]>j) k[i][j] = k[i-1][j];
				else k[i][j] = Math.max(k[i-1][j-mulgan[i]]+value[i],k[i-1][j]);
			}
		}
		for(int i=0;i<=n;i++)
			System.out.println(Arrays.toString(k[i]));
		System.out.println(k[n][w]);
		
	}// end of main
}// end of class