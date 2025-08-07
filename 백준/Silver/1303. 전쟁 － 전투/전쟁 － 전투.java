import java.io.*;
import java.util.*;


/*

 */


public class Main {
	
	static int N,M;
	static boolean[][] visit;
	static char[][]arr;
	static int sum1,sum2;
	static int cnt;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		arr=new char[M][N];
		visit=new boolean[M][N];
		for(int i=0;i<M;i++) {
			String st2=br.readLine();
			for(int j=0;j<N;j++) {
				arr[i][j]=st2.charAt(j);
			}
		}
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(arr[i][j]=='W'&&!visit[i][j]) {
				cnt=0;
				dfs(i,j,'W');
				sum1+=cnt*cnt;
				
				}
			}
		}
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(arr[i][j]=='B'&&!visit[i][j]) {
				cnt=0;
				dfs(i,j,'B');
				sum2+=cnt*cnt;
				}
			}
		}
		System.out.println(sum1);
		System.out.println(sum2);
		
		}
	
	public static void dfs(int x,int y, char n) {
		cnt++;
		visit[x][y]=true;
		
		int[]dx= {1,-1,0,0};
		int[]dy= {0,0,1,-1};
		
		for(int i=0;i<4;i++) {
			int nx=dx[i]+x;
			int ny=dy[i]+y;
			if(nx>=0&&ny>=0&&nx<M&&ny<N&&!visit[nx][ny]&&arr[nx][ny]==n) {
				
				dfs(nx,ny,n);
				
			}
		}
		
	}
	
	
}
