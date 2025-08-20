import java.io.*;
import java.util.*;



public class Main {
	
	static int N,min;
	static boolean[]visit;
	static int[][]arr;
	
	public static void main(String[] args)throws IOException{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));		
		
		N=Integer.parseInt(br.readLine());
		
		arr=new int[N][N];
		visit=new boolean[N];
		min=Integer.MAX_VALUE;
		
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,0);
		System.out.println(min);
	}
	
	public static void dfs(int node,int depth) {
		if(depth==N/2) {
			min=Math.min(min, cal());
			return;
		}
		
		for(int i=node;i<N;i++) {
			if(!visit[i]) {
				visit[i]=true;
				dfs(i+1,depth+1);
				visit[i]=false;
			}
		}
		
	}
	
	public static int cal() {
		int sum1=0;
		int sum2=0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(visit[j]&&visit[i]) {
					sum1+=arr[i][j];
				}else if(!visit[j]&&!visit[i]){
					sum2+=arr[i][j];
				}
			}
		}
		
		return Math.abs(sum1-sum2);
	}
	
}
