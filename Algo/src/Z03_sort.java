import java.util.Arrays;

/**
 * [정렬]
 * 카운팅 정렬 	O[N]	//가장빠른 정렬방법 : 제약사항- 정렬할 데이터가 정수(0 이상의 정수 - 음수가있을경우 전체를 다 같은값을 더해서 0이상으로 만들어야함) 
 * 					//메모리를 사용한다.
 * 
 * 퀵정렬 	O[NlogN]//구현하기 어렵다, 시간이 중간정도 빠르다.
 * 병합정렬	O[NlogN]
 * 힙정렬		O[NlogN]
 * 
 * 거품정렬	O[N^2]	//구현하기 쉽다, 상대적으로 시간이 많이 걸린다.
 * 선택정렬	O[N^2]
 * 삽입정렬	O[N^2]
 *
 */


public class Z03_sort {
	public static void main(String[] args) {
		
		//거품 정렬 - 배열의 현재값과 다음인덱스를 비교해서 현재값이 더 크면 스왑 인덱스 순차적으로 끝까지 진행 하는게 한사이클 
		/*
		int[] a = {5,3,7,1,9,2,8,6,4}; //9개 8~0
		System.out.println(Arrays.toString(a));
		//(n-1) * (n/2) = 0.5n^2 - 0.5 -> O[n^2]
		for (int i = a.length - 1; i >= 0; i--) { //  정렬할 범위의 시작위치 - (내가 이해하기엔 정렬할 범위의 종료위치 - 사이클에 종료시점 0~i까지) 
			for (int j = 0; j < i; j++) { //   실제 정렬할 범위 
				if(a[j] > a[j+1]) { // 두개씩 비교해서 큰값을 뒤로 교환 - 등호를 바꾸면 내림차순가능
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
			System.out.println("i:"+i+","+Arrays.toString(a));
			if(i == a.length/2) { //중간에 빠져나오기 - 가지치기,백트래킹이라함
				break;
			}
		}
		System.out.println(Arrays.toString(a));
		*/
		
		int[] b = {2,3,1,0,2,2,1,1,1,2,3,2}; // 0~3;
		int max = Integer.MIN_VALUE;// 카운팅 정렬할 데이터의 최대값을 미리 알아야한다(최소값도 알면 메모리를 절약할 수 있다)
		//n+n+n O[n]
		
		for (int i = 0; i < b.length; i++) {
			if(max < b[i]) max = b[i];
		}
		
		//1이 몇번 사용되었는가.
		int[] cnt = new int[max+1]; // 각 숫자의 개수를 카운팅 할 배열
		for (int i = 0; i < b.length; i++) {
			cnt[b[i]]++;
		}

		System.out.println(Arrays.toString(cnt));

		//오름차순으로 출력하기
		for (int i = 0; i < cnt.length; i++) {
			for (int j = 0; j < cnt[i]; j++) {
				System.out.print(i+" ");
			}
		}
		System.out.println();
		

		
		//최빈수 출력
		int index = 0;
		for (int i = 0; i < cnt.length; i++) {
			if (cnt[index] < cnt[i]) {
				cnt[index] = cnt[i];
			}
		}

		System.out.println(index);		
		
		
		
		
	} // end of main
} //end of class
