import java.io.*;
import java.util.*;

/*
 * 
 * 00 01 02 03
 * 10 11 12 13
 * 20 21 22 23
 * 30 31 32 33
 * i와j값이 같을때의 경우는 버림
 * 두 갈래로 나눠서 생각해보고 첫갈래에서 방문처리하고
 * 두번째 갈래에서 방문 안된곳만 찾아서 더하면 끝
 * 이 둘의 차이를 min에 저장해서 다음에 더 작은게 나오면 갱신
 * 0~N까지 N+1/2만큼 수를 골라서 그만큼 반복문
 * 
 * 
 */

class Solution {

	static int N,answer;
	static boolean[] select;
	static int[][] arr;
	
    public static void main(String[] args) throws IOException {
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int T=Integer.parseInt(br.readLine());
    	for(int t=0;t<T;t++) {
    		
    		N=Integer.parseInt(br.readLine());
    		
    		arr=new int[N][N];
    		select=new boolean[N];
    		answer=Integer.MAX_VALUE;
    		
    		for(int i=0;i<N;i++) {
    			StringTokenizer st=new StringTokenizer(br.readLine());
    			for(int j=0;j<N;j++) {
    				arr[i][j]=Integer.parseInt(st.nextToken());
    			}
    		}
    		
    		dfs(0,0);
    		System.out.println("#"+(t+1)+" "+answer);
    	}
    }
    
    //방문여부를 따져보고 i,j 위치가 바뀌면서 더해져야한다.
    static int cal() {
    	int a=0;
    	int b=0;
    	
    	for(int i=0;i<N;i++) {
    		for(int j=0;j<N;j++) {
    			if(i==j) {
    				continue;
    			}
    			if(select[i]&&select[j]) {
    				a+=arr[i][j];
    			}else if(!select[i]&&!select[j]) {
    				b+=arr[i][j];
    			}
    		}
    	}
    	return Math.abs(a-b);
    }
    
    //재귀함수를 통해서 방문처리하고 N이 6이면 123->124->125..이런식으로 select방문처리해서 cal로 넘겨준다.
    static void dfs(int start, int count) {
    	
    	if(count==(N/2)) {
    		answer=Math.min(answer, cal());
    		return;
    	}
    	
    	for(int i=start;i<N;i++) {
    		select[i]=true;
    		dfs(i+1,count+1);
    		select[i]=false;
    	}
    	
    	
    }
    
}
