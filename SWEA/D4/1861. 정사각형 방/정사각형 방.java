import java.io.*;
import java.util.*;

/*
 * 
 * n*n배열로 수를 넣고 00부터 시작
 * 상하좌우에 1만큼 큰 수가 있는지 확인
 * 반복해서 1만큼 큰 수가 있는지 확인하고 방문 처리
 * 00에 대한 확인이 끝나면 방문 처리 초기화 
 * 
 */

class Solution {
	
	static int arr[][];
	static int N,answer,count;
	static boolean[][]visit;
	
    public static void main(String[] args) throws IOException {
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int T=Integer.parseInt(br.readLine());
    	
    	for(int s=0;s<T;s++) {
    		
    		N=Integer.parseInt(br.readLine());
    		
    		arr=new int[N][N];
    		answer=-1;
    		int num=0;;
    		
    		for(int i=0;i<N;i++) {
    			StringTokenizer st=new StringTokenizer(br.readLine());
    			for(int j=0;j<N;j++) {
    				arr[i][j]=Integer.parseInt(st.nextToken());
    			}
    		}
    		
    		for(int i=0;i<N;i++) {
    			for(int j=0;j<N;j++) {
    				count=0;
    				visit=new boolean[N][N];
    				dfs(i,j);
    				if(count>answer) {
    					num=arr[i][j];
    					answer=count;
    				}else if(count==answer) {
    					num=Math.min(num, arr[i][j]);
    				}
    			}
    		}
    		System.out.println("#"+(s+1)+" "+num+" "+(answer+1));
    	}
    	
    }
    
    static void dfs(int x,int y) {
    	int[]dx= {1,-1,0,0};
    	int[]dy= {0,0,1,-1};
    	visit[x][y]=true;
    	
    	for(int i=0;i<4;i++) {
    		int nx=x+dx[i];
    		int ny=y+dy[i];
    		//nx, ny가 0보다 크거나 같고 N보단 작아야하고 다음에 나올 수가 1만큼만 커야 count증가, 재귀반복
    		if(nx>=0&&ny>=0&&nx<N&&ny<N&&arr[nx][ny]==arr[x][y]+1) {
    			count++;
    			dfs(nx,ny);
    		}
    	}
    	
    }
    
}
