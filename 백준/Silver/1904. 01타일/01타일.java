import java.io.*;
import java.util.*;


/*
 * 1 2 3 5 
 * 
 * 00001 00111 10000 00100 11001 11100 11111 10011
 */


public class Main {
	
	static int[]dp=new int[1000001];
	
	public static void main(String[] args)throws IOException{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		
		dp[0]=0;
		dp[1]=1;
		dp[2]=2;
		
		for(int i=3;i<dp.length;i++) {
			dp[i]=-1;
		}
		System.out.println(title(N));
	}
	public static int title(int node) {
		
		
		if(dp[node]==-1) {
			dp[node]=title(node-1)+title(node-2);
		}
		
		return dp[node]%15746;
		
	}
}
