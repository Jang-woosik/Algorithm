import java.io.*;
import java.util.*;


/*
 * 
 * 부모 배열에 자식을 넣어두고 
 * 큐로 계속 찾기
 * 
 * 
 */


public class Main {
	
	static int n;
	static boolean visit[];
	static int[][]arr;
	static int cnt=0;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		arr=new int[n+1][n+1];
		visit=new boolean[n+1];
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		int a=Integer.parseInt(st.nextToken());
		int b=Integer.parseInt(st.nextToken());
		
		
		int m=Integer.parseInt(br.readLine());
		
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			
			arr[x][y]=arr[y][x]=1;
		}
		System.out.println(bfs(a,b));
		
	}
	
	public static int bfs(int start, int target) {
		Queue<Integer> q=new ArrayDeque<>();
		int[]dist=new int[n+1];
		q.add(start);
		visit[start]=true;
		
		while(!q.isEmpty()) {
			int v=q.poll();
			if(v==target)return dist[v];
			
			for(int i=1;i<n+1;i++) {
				if(arr[v][i]==1&&!visit[i]) {
					visit[i]=true;
					dist[i]=dist[v]+1;
					q.add(i);
				}
			}
			
		}
	return -1;	
	}
		
}