/**
 *	교재 Gravity 문제
 */
public class Z01_Gravity {
	public static void main(String[] args) {
		
		//아이디어 이용
		int[] arr = {7,4,2,0,0,6,0,7,0};
		int maxCnt = 0; // 최대낙차
		for (int i = 0; i < arr.length; i++) {
			int cnt = 0; // 각칸의 박스 낙차수 카운팅
			for (int j = i+1; j < arr.length; j++) {
				if(arr[i] > arr[j]) {
					cnt++;
				}
			}
			if(maxCnt < cnt) maxCnt = cnt;
		}
		
		System.out.println(maxCnt);
		
//		int[] arr = {7,4,2,0,0,6,0,7,0};
//		int[][] box = new int[8][9];
//		
//		//1차원배열의 원소를 기준으로 2차원배열에 박스를 밑에서부터 쌓기
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = 0; j < arr[i]; j++) {
//				box[box.length-j-1][i] = 1; //박스의 위치 표시
//			}
//		}
//		
//		// 오른쪽으로 90 도 회전
//		int[][] nbox = new int[9][8]; // 9행 8열 - 90도 회전한 2차원 배열
//		for (int i = 0; i < box.length; i++) {
//			for (int j = 0; j < box[i].length; j++) {
//				nbox[j][7-i] = box[i][j];
//			}
//		}
//		
//		int maxCnt = 0; //각 박스의 낙차들의 최대값을 저장할 변수
//		// 중력을 아래쪽으로 발생시켜서 이동
//		for (int i = nbox.length - 2; i >= 0 ; i--) { // 9행 8~0 (맨아래는 안해서 -2 를 줌)
//			for (int j = 0; j < nbox[i].length; j++) { // 8열 0~7
//				//박스가 떨어지려면, 인덱스 체크 && 나는 박스 && 아래칸은 공간
//				int cnt = 0; //nbox[i][j] 의 박스가 몇칸 떨어졌는지 누적할 변수
//				for (int k = 0; i+k+1 < nbox.length && nbox[i+k][j] == 1 && nbox[i+k+1][j] == 0; k++) {
//					nbox[i+k][j] = 0;
//					nbox[i+k+1][j] = 1;
//					cnt++;// 각 박스마다 낙차를 구하기
//				}
//				if(maxCnt < cnt) maxCnt = cnt;// 각 박스들의 낙차의 최대값을 구하기
//			}
//		}
//		
//		//배열의 값을 임시로 출력
//		System.out.println(maxCnt);
		
	}// end of main
}// end of class
