import java.io.*;
import java.util.*;


/*
 * 
 * dfs를 활용해서 연결되면 cnt증가
 * cnt가 max보다 크면 max교체 
 * 반복해서 max를 마지막에 출력
 * 
 */


public class Main {
	
	static int N;
	static int M;
	static boolean[][] visit;
	static int[][]arr;
	static int cnt;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		arr=new int[N+1][M+1];
		visit=new boolean[N+1][M+1];
		
		
		for(int i=0;i<K;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			arr[a][b]=1;
		}
		int max=0;
		
		for(int i=1;i<N+1;i++) {
			for(int j=1;j<M+1;j++) {
				if(arr[i][j]==1&&!visit[i][j]) {
					cnt=0;
					dfs(i,j);
					if(max<cnt) {
						max=cnt;
					}
				}
			}
		}
		System.out.println(max);
		
		
	}
	
	public static void dfs(int x,int y) {
		cnt++;
		int[] dx= {1,-1,0,0};
		int[]dy= {0,0,1,-1};
		visit[x][y]=true;
		
		for(int i=0;i<4;i++) {
			int nx=dx[i]+x;
			int ny=dy[i]+y;
			if(nx>=1&&ny>=1&&nx<N+1&&ny<M+1&&arr[nx][ny]==1&&!visit[nx][ny]) {
				dfs(nx,ny);
			}
		}
		
	}
}
