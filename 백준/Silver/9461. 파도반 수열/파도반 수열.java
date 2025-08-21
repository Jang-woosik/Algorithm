import java.io.*;
import java.util.*;


/*
 * 123번째를 1로 저장해두고 node-2랑 node-3을 더해서 출력
 */


public class Main {
	
	static long[]dp=new long[103];
	
	public static void main(String[] args)throws IOException{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		
		dp[1]=1;
		dp[2]=1;
		dp[3]=1;
		
		for(int s=0;s<T;s++) {
			
			int N=Integer.parseInt(br.readLine());
			
			for(int i=4;i<dp.length;i++) {
				dp[i]=-1;
			}
			
			System.out.println(test(N));
			
		}
		
	}
	
	public static long test(int node) {
		
		if(dp[node]==-1) {
			dp[node]=test(node-2)+test(node-3);
		}
		
		return dp[node];
	}
}
