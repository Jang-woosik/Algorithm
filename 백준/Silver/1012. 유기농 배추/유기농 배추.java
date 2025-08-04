import java.util.*;
import java.io.*;


/*
 * 입력 쭉 받아서 각 상하좌우에 1이 있는지 확인하고
 * 있으면 bfs 돌려서 다 true로 바꾸고 다음 1이 어딨는지 찾게
 * 또 찾으면 bfs 돌려서 그 무리도 bfs로 세줌
 */

public class Main {
	
	static boolean[][]visit;
	static int[][]arr;
	static int N;
	static int M;
	
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			int K=Integer.parseInt(st.nextToken());
			arr=new int[N][M];
			visit=new boolean[N][M];
			int cnt=0;
			
			
			
			for(int j=0;j<K;j++) {
				st=new StringTokenizer(br.readLine());
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				arr[a][b]=1;
			}
			
			for(int j=0;j<N;j++) {
				for(int k=0;k<M;k++) {
					if(arr[j][k]==1&&!visit[j][k]) {
						bfs(j,k);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
		
		
		
		
	}
	
	static void bfs(int x,int y) {
		visit[x][y]=true;
		
		int[]dx= {1,-1,0,0};
		int[]dy= {0,0,1,-1};
		
		for(int i=0;i<4;i++) {
			int nx=dx[i]+x;
			int ny=dy[i]+y;
			if(nx>=0&&ny>=0&&nx<N&&ny<M) {
				if(arr[nx][ny]==1&&!visit[nx][ny]) {
					bfs(nx,ny);
				}
			}
		}
		
	}
	
}
