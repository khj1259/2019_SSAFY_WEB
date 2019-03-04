package com.ssafy;

public class Chocolate {
	public  int[] val= {2, 3, 7, 8, 5, 1, 4};
	public int price, idx, answer, money2, su2;
	public int execute(int money, int su) {		
		//구현하세요.   필요하면  변수, 추가 메서드 구현 가능, 리턴타입 변경도 가능
		money2 = money;
		su2 = su;
		answer = 0;
		cal(0,0,0);
		if(answer != 0) {
			return answer;
		}else {
			return -1;  //  구현시 리턴 변경
		}
	}
	
	public void cal(int idx, int price, int cnt) {
		if(price > money2) {
			return;
		}
		if(cnt == su2 && price == money2) {
			answer++;
			return;
		}
		if(idx == 7) {
			return;
		}
		cal(idx+1, price+val[idx], cnt+1);
		cal(idx+1, price, cnt);
	}
	
	public static void main(String[] args) {
		Chocolate choco=new Chocolate();
		System.out.println(choco.execute(10, 3));  //3
		System.out.println(choco.execute(20, 5));  //2
		System.out.println(choco.execute(20, 7));  //-1
	}
		
}	
		
	
























