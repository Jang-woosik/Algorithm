import java.io.*;
import java.util.*;


/*
 * 
 * dfs로 접근해서 영역 개수 세기
 * 영역 개수가 제일 많은 것을 출력한다.
 * 
 */


public class Main {
	
	static int[][]arr;
	static int max,N;
	static boolean[][]visit;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		
		arr=new int[N][N];
		max=0;
		
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				if(max<arr[i][j]) {
					max=arr[i][j];
				}
			}
		}
		int max2=0;
		
		for(int k=0;k<max+1;k++) {
			visit=new boolean[N][N];
			int cnt=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(!visit[i][j]&&arr[i][j]>k) {
						dfs(i,j,k);
						cnt++;
					}
				}
				
			}
			if(max2<cnt) {
				max2=cnt;
			}
		}
		System.out.println(max2);
	
	}
	
	static void dfs(int x,int y,int depth) {
		int[]dx= {1,-1,0,0};
		int[]dy= {0,0,1,-1};
		
		visit[x][y]=true;
		
		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(nx>=0&&ny>=0&&nx<N&&ny<N&&arr[nx][ny]>depth&&!visit[nx][ny]) {
				dfs(nx,ny,depth);
			}
		}
		
	}
	
}