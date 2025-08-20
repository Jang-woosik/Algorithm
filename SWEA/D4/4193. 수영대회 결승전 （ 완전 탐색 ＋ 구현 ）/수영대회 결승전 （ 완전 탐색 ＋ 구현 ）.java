import java.io.*;
import java.util.*;

/*
 *  소용돌이는 2번 움직이면 사라짐
 *  1번 움직이면 다시 생김
 *  1인건 안 사라짐
 *  큐에 모든 경로를 넣어서
 *  경로가 제일 짧은걸 사용
 *  3으로 나눠서 2남으면 소용돌이 사라졌을때
 *  상하좌우로 움직일 수 있으니 bfs에서 사방탐색
 */


public class Solution { 
	
	static int x2,y2,N;
	static boolean[][]visit;
	static int min;
	static int[][]arr;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T=Integer.parseInt(br.readLine());
        for(int s=1;s<T+1;s++) {
        	N=Integer.parseInt(br.readLine());
            
            arr=new int[N][N];
            visit=new boolean[N][N];
            for(int i=0;i<N;i++) {
            	StringTokenizer st=new StringTokenizer(br.readLine());
            	for(int j=0;j<N;j++) {
            		arr[i][j]=Integer.parseInt(st.nextToken());
            	}
            }
            
            StringTokenizer st=new StringTokenizer(br.readLine());
        	
            int x1=Integer.parseInt(st.nextToken());
            int y1=Integer.parseInt(st.nextToken());
            
            st=new StringTokenizer(br.readLine());
        	x2=Integer.parseInt(st.nextToken());
        	y2=Integer.parseInt(st.nextToken());
            min=-1;
        	bfs(x1,y1);
        	System.out.println("#"+s+" "+min);
        }
        
    }
    
    public static void bfs(int x,int y) {
    	Queue<int[]>q=new ArrayDeque<>();
    	int depth=0;
    	q.add(new int[] {x,y,0});
    	int[]dx= {1,-1,0,0};
    	int[]dy= {0,0,1,-1};
    	
    	while(!q.isEmpty()) {
    		int[]v=q.poll();
    		x=v[0];
    		y=v[1];
    		depth=v[2];
    		visit[x][y]=true;
    		if(x==x2&&y==y2) {
    			if(depth>0) {
    				min=depth;
    			}
    			return;
    		}
    		
    		for(int i=0;i<4;i++) {
    			int nx=x+dx[i];
    			int ny=y+dy[i];
    			if(nx>=0&&ny>=0&&nx<N&&ny<N&&arr[nx][ny]!=1&&!visit[nx][ny]) {
    				if(arr[nx][ny]==2&&depth%3==2) {
    					q.add(new int[] {nx,ny,depth+1});
    				}else if(arr[nx][ny]==2&&depth%3!=2) {
    					q.add(new int[] {x,y,depth+1});
    				}else {
    					q.add(new int[] {nx,ny,depth+1});
    				}
    			}
    		}
    	}
    	
    }
    
}