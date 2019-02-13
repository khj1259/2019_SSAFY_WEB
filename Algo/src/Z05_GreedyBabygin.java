import java.util.Arrays;

/**
 * 베이비진 탐욕기법
 * 6개의 숫자카드에서 사용된 숫자를 카운팅
 * @author student
 *
 */


public class Z05_GreedyBabygin {
	public static void main(String[] args) {
		int[] num = {0,1,9,3,4,5};
		int[] cnt = new int[12];
		for (int i = 0; i < num.length; i++) {
			cnt[num[i]]++;
		}
		System.out.println(Arrays.toString(cnt));
	
		cnt[10] = cnt[0];
		cnt[11] = cnt[1];
		int i = 0;
		int chk = 0;
		while(i < 10) {//	0~9
			//run인지 확인, cnt 배열의 각 값이 3이상이면
			if(cnt[i] >= 3) { //트리플랫
				System.out.println("트리플랫");
				cnt[i] -= 3;
				chk++;
				continue;
			}
			if(cnt[i] >= 1 && cnt [i+1] >= 1 && cnt[i+2] >= 1) {
				System.out.println("런");
				cnt[i]--; 
				cnt[i+1]--; 
				cnt[i+2]--;
				chk++;
				continue;
			}
			i++;
		}
		
		if(chk == 2) System.out.println("ok");
		else System.out.println("no");
	}
}
