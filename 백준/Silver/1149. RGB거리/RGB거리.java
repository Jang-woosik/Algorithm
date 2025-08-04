import java.util.*;
import java.io.*;


/*
 * 
 * 빨간색 칠하면 다음줄에 초록 파랑
 * 초록 칠하면 다음줄에 빨강 파랑
 * 파랑도 마찬가지
 * 이렇게 다 더해서 최솟값을 구하면 됨
 * 
 */

public class Main {
	
	
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[][] cost=new int[N][3];
		int[][] dp=new int[N][3];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				cost[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0]=cost[0][0];
		dp[0][1]=cost[0][1];
		dp[0][2]=cost[0][2];
		
		for(int i=1;i<N;i++) {
			dp[i][0]=Math.min(dp[i-1][1], dp[i-1][2])+cost[i][0];
			dp[i][1]=Math.min(dp[i-1][0], dp[i-1][2])+cost[i][1];
			dp[i][2]=Math.min(dp[i-1][0], dp[i-1][1])+cost[i][2];
					
		}
		
		System.out.println(Math.min(Math.min(dp[N-1][0], dp[N-1][1]), dp[N-1][2]));
	}
}
