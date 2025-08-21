import java.io.*;
import java.util.*;

/*
 *  for문을 돌려서 count가 1인거를 찾아
 *  거기서 큐에 넣어서 계속 돌리고 끝나면 다음 count가 1인걸 찾으러 떠남
 *  set에 포함 안된걸 시작점으로 잡고
 */


public class Solution { 
	
	static int[][]arr;
	static boolean[]visit;
	static int V;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
      
        for(int s=1;s<11;s++) {
        	StringTokenizer st=new StringTokenizer(br.readLine());
        	
        	V=Integer.parseInt(st.nextToken());
        	int E=Integer.parseInt(st.nextToken());
        	
        	
        	visit=new boolean[V+1];
        	arr=new int[V+1][V+1];
        	
        	st=new StringTokenizer(br.readLine());
        	for(int i=0;i<E;i++) {
        		int a=Integer.parseInt(st.nextToken());
        		int b=Integer.parseInt(st.nextToken());
        		arr[b][a]=1;
        	}
        	System.out.println("#"+s+" ");
        	for(int i=1;i<V+1;i++) {
        		if(!visit[i]) {
        			dfs(i);
        		}
        	}
        	System.out.println();
        }
    }
    
    public static void dfs(int node) {
    	visit[node]=true;
    	
    	for(int i=1;i<V+1;i++) {
    		if(!visit[i]&&arr[node][i]==1) {
    			dfs(i);
    		}
    	}
    	System.out.print(node+" ");
    }
    
    
}