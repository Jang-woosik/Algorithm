import java.io.*;
import java.util.*;

/*
 * 일단 1번만 깎을 수 있기 때문에 t/f로 나누고
 * 이미 한번 깎았으면 더이상 못 깎고 깎은 산은 직전 산보다 1만큼만 작게
 */

public class Solution {

	static int[][]map;
	static int n,k,sum;
	static boolean[][]visit;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T=Integer.parseInt(br.readLine());
        
        for(int s=1;s<=T;s++) {
        	
        	StringTokenizer st=new StringTokenizer(br.readLine());
        	n=Integer.parseInt(st.nextToken());
        	k=Integer.parseInt(st.nextToken());
        	map=new int[n][n];
        	int max=0;
        	for(int i=0;i<n;i++) {
        		st=new StringTokenizer(br.readLine());
        		for(int j=0;j<n;j++) {
        			map[i][j]=Integer.parseInt(st.nextToken());
        			if(max<map[i][j]) {
        				max=map[i][j];
        			}
        		}
        	}

        	sum=0;
        	for(int i=0;i<n;i++) {
        		for(int j=0;j<n;j++) {
        			if(map[i][j]==max) {
        				
        				visit=new boolean[n][n];
        				dfs(i,j,1,false);
        			}
        		}
        	}
        	
        	System.out.println("#"+s+" "+sum);
        }
        
    }
    
    static void dfs(int x,int y,int depth,boolean cut) {
    	sum=Math.max(sum, depth);
    	
    	
    	int[]dx= {1,-1,0,0};
    	int[]dy= {0,0,1,-1};
    	visit[x][y]=true;
    	
    	for(int i=0;i<4;i++) {
    		int nx=dx[i]+x;
    		int ny=dy[i]+y;
    		if(nx>=0&&ny>=0&&nx<n&&ny<n&&!visit[nx][ny]) {
    			if(map[nx][ny]<map[x][y]) {
    				dfs(nx,ny,depth+1,cut);
    			}else if(!cut&&map[nx][ny]>=map[x][y]){
    				if(k>map[nx][ny]-map[x][y]) {
    					int temp=map[nx][ny];
    					map[nx][ny]=map[x][y]-1;
    					dfs(nx,ny,depth+1,true);
    					map[nx][ny]=temp;
    					
    				}
    			}
    		}
    	}
    	visit[x][y]=false;
    }
}
