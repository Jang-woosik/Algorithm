import java.io.*;
import java.util.*;

/*
 * .bfs로 퍼져나가서 우선순위 큐로 방문하면
 * 시작점과 끝점은 고정이므로 굳이 찾지 않아도 괜찮음
 */

public class Main {
	static int n,m;
	static int[][]map;
	static int[]dx= {-1,1,0,0};
	static int[]dy= {0,0,1,-1};
	public static class Node implements Comparable<Node>{
		int x,y,cost;
		public Node(int x,int y,int cost) {
			this.x=x;
			this.y=y;
			this.cost=cost;
		}public int compareTo(Node o) {
			return this.cost-o.cost;
		}
	}
	
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    
	    m=Integer.parseInt(st.nextToken());
	    n=Integer.parseInt(st.nextToken());
	    map=new int[n][m];
	    
	    for(int i=0;i<n;i++) {
	    	String s=br.readLine();
	    	for(int j=0;j<m;j++) {
	    		map[i][j]=s.charAt(j)-'0';
	    	}
	    }
	    System.out.println(bfs(0,0));
	}
	static int bfs(int x,int y) {
		PriorityQueue<Node>q=new PriorityQueue<>();
		q.add(new Node(x,y,0));
		
		int[][]dist=new int[n][m];
		for (int i = 0; i < n; i++) {
	        Arrays.fill(dist[i], Integer.MAX_VALUE);
	    }
		dist[x][y]=0;
		
		while(!q.isEmpty()) {
			Node now=q.poll();
			
			if(now.x==n-1&&now.y==m-1) {
				return now.cost;
			}
			if(now.cost>dist[now.x][now.y]) {
				continue;
			}
			for(int i=0;i<4;i++) {
				int nx=dx[i]+now.x;
				int ny=dy[i]+now.y;
				if(nx>=0&&ny>=0&&nx<n&&ny<m) {
					int nextCost=now.cost;
					if(map[nx][ny]==1) {
						nextCost++;
					}
					if(nextCost<dist[nx][ny]) {
						dist[nx][ny]=nextCost;
						q.add(new Node(nx,ny,nextCost));
					}
				}
			}
		}
		
		return -1;
	}
	
}
