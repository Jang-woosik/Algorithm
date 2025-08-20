import java.io.*;
import java.util.*;

/*
 *  벽이 하나면 뚫을 수 있으니까
 *  벽에 대한 카운트를 세서
 *  벽을 계속 초기화시키는것
 *  거리를 계속 depth에 넣어서 리턴 시키면 될듯
 *  00->N-1,M-1
 *  벽을 부수고 통과하는 경우, 벽을 안 부수고 통과하는 경우
 *  두가지로 나눠서 방문처리
 */


public class Main { 
	
	static int[][]arr;
	static int N,M;
	static boolean[][][]visit;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        
        arr=new int[N][M];
        visit=new boolean[N][M][2];
        for(int i=0;i<N;i++) {
        	String s=br.readLine();
        	for(int j=0;j<M;j++) {
        		arr[i][j]=s.charAt(j)-'0';
        	}
        }
    	System.out.println(bfs(0,0));
    }
    public static int bfs(int x, int y) {
    	Queue<int[]>q=new ArrayDeque<>();
    	
    	q.add(new int[] {x,y,1,0});
    	
    	
    	int[]dx= {1,-1,0,0};
    	int[]dy= {0,0,1,-1};
    	
    	while(!q.isEmpty()) {
    		int[]v=q.poll();
    		int x1=v[0];
    		int y1=v[1];
    		int depth=v[2];
    		int count=v[3];
    		
    		if(x1==N-1&&y1==M-1) {
    			return depth;
    		}
    		
    		for(int i=0;i<4;i++) {
        		int nx=x1+dx[i];
        		int ny=y1+dy[i];
        		if(nx>=0&&ny>=0&&nx<N&&ny<M&&count<2) {
        			if(count==0&&arr[nx][ny]==1&&!visit[nx][ny][1]) {
        				q.add(new int[] {nx,ny,depth+1,count+1});
        				visit[nx][ny][1]=true;
        			}
        			
        			else if(arr[nx][ny]==0&&!visit[nx][ny][count]) {
            				q.add(new int[] {nx,ny,depth+1,count});
            				visit[nx][ny][count]=true;
        			}
        		}
        	}
    	}
    	
    	return -1;
    }
    
}