package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Solution_5643_Professional_키순서_정용수 {
 
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
         
        for (int tc = 1; tc <= testcase; tc++) {
             
        	int N = Integer.parseInt(br.readLine().trim());
        	int M = Integer.parseInt(br.readLine().trim());
            int[][] tree = new int[N+1][N+1] ;
            for (int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                tree[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }
            int result = 0;
            for(int i = 1; i<=N; i++) {
            	int cnt = 0;
            	boolean[] chk = new boolean[N+1];
            	Queue<Integer> que = new LinkedList<>();
            	que.add(i);
            	chk[i] = true;
            	cnt++;
            	//나보다 큰사람 찾기
            	while(!que.isEmpty()) {
            		int key = que.poll();
            		for(int j = 1; j<=N; j++) {
            			if(!chk[j] && tree[key][j] == 1) {
            				que.add(j);
            				chk[j] = true;
            				cnt++;
            			}
            		}
            	}
            	
            	
            	que.add(i);
            	//나보다 작은사람 찾기
            	while(!que.isEmpty()) {
            		int key = que.poll();
            		for(int j = 1; j<=N; j++) {
            			if(!chk[j] && tree[j][key] == 1) {
            				que.add(j);
            				chk[j] = true;
            				cnt++;
            			}
            		}
            	}
            	
            	if(cnt == N) {
            		result++;
            	}
            }
            
            System.out.println("#"+tc+" "+result);
        }
    }
}
