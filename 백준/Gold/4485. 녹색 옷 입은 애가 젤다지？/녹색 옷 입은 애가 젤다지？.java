import java.io.*;
import java.util.*;


/*
 * 다익스트라 우선순위 큐
 * 오름차순 정리
 * 최소를 찾아야 하기 때문에
 */


public class Main {
	
	static class Pos implements Comparable<Pos>{
		int r,c,m;
		public Pos(int r,int c,int m) {
			this.r=r;
			this.c=c;
			this.m=m;
		}
		@Override
		public int compareTo(Pos o) {
			return this.m-o.m;
			//지금 값과 이전값을 비교해서 오름차순으로 정리한다.
		}
	}
	
	static int[][]map;
	static int N;
	
	public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int idx=1;
        
        while(true) {
        	N=Integer.parseInt(br.readLine());
        	
        	if(N==0) {
        		break;
        	}
        	map=new int[N][N];
        	
        	for(int i=0;i<N;i++) {
        		StringTokenizer st=new StringTokenizer(br.readLine());
        		for(int j=0;j<N;j++) {
        			map[i][j]=Integer.parseInt(st.nextToken());
        		}
        	}
        	System.out.println("Problem "+idx+": "+bfs());
        	idx++;
        }
       
        
    }
	
	public static int bfs() {
		PriorityQueue<Pos>q=new PriorityQueue<>();
		int[]dx= {1,-1,0,0};
		int[]dy= {0,0,1,-1};
		
		boolean[][]visit=new boolean[N][N];		
		q.add(new Pos(0,0,map[0][0]));
		visit[0][0]=true;
		while(!q.isEmpty()) {
			Pos cur=q.poll();
			if(cur.r==N-1&&cur.c==N-1) {
				return cur.m;
			}
			for(int i=0;i<4;i++) {
				int nx=cur.r+dx[i];
				int ny=cur.c+dy[i];
				if(nx>=0&&ny>=0&&nx<N&&ny<N&&!visit[nx][ny]) {
					visit[nx][ny]=true;
					q.add(new Pos(nx,ny,cur.m+map[nx][ny]));
				}
			}
		}
		
		return -1;
	}
	
}