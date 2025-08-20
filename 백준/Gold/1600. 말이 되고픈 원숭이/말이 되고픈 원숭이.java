import java.io.*;
import java.util.*;

/*
 *  큐에 이동하는 위치를 다 넣고
 *  말처럼 움직이면 장애물 필요없음 도착위치가 장애물 아니면 됨
 *  사방탐색 시키고 방문처리?깊이로 방문처리 3차원
 *  if문에는 1아닐때랑 방문이 겹치는지
 *  상하좌우 x로2->y로 1,-1  x로 1->y로 2,-2 x로-1->y로 2, -2 x로 -2->y로 1,-1
 *  상하좌우를 빼고는 K번으로 제한
 */


public class Main { 
	
	static int K,W,H;
	static boolean[][][]visit;
	static int[][]arr;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        K=Integer.parseInt(br.readLine());
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        W=Integer.parseInt(st.nextToken());
        H=Integer.parseInt(st.nextToken());
        
        arr=new int[H][W];
        visit=new boolean[H][W][K+1];
        
        for(int i=0;i<H;i++) {
        	st=new StringTokenizer(br.readLine());
        	for(int j=0;j<W;j++) {
        		arr[i][j]=Integer.parseInt(st.nextToken());
        	}
        }
        
        System.out.println(bfs(0,0));

    }
    
    public static int bfs(int x, int y) {
    	Queue<int[]>q=new ArrayDeque<>();
    	
    	int[]dx= {1,-1,0,0,2,2,1,1,-1,-1,-2,-2};
    	int[]dy= {0,0,1,-1,1,-1,2,-2,2,-2,1,-1};
    	int depth=0;
    	int count=0;
    	q.add(new int[] {x,y,depth,count});
    	visit[x][y][0]=true;
    	
    	while(!q.isEmpty()) {
    		int[]v=q.poll();
    		int x1=v[0];
    		int y1=v[1];
    		depth=v[2];
    		count=v[3];
    		if(x1==H-1&&y1==W-1) {
    			return depth;
    		}
    		for(int i=0;i<4;i++) {
				int nx=x1+dx[i];
				int ny=y1+dy[i];
				if(nx>=0&&ny>=0&&nx<H&&ny<W&&arr[nx][ny]!=1&&!visit[nx][ny][count]) {
					q.add(new int[] {nx,ny,depth+1,count});
    				visit[nx][ny][count]=true;
				}
			}
    		if(count<K) {
    			for(int i=4;i<12;i++) {
    				int nx=x1+dx[i];
    				int ny=y1+dy[i];
    				if(nx>=0&&ny>=0&&nx<H&&ny<W&&arr[nx][ny]!=1&&!visit[nx][ny][count+1]) {
    					q.add(new int[] {nx,ny,depth+1,count+1});
        				visit[nx][ny][count+1]=true;

    				}
    			}
    		}
    	}
    	
    	return -1;
    }
    
}