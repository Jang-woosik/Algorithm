import java.io.*;
import java.util.*;

/*
 * 부피는 부피끼리 더해서 기준 넘기면 멈추고
 * 멈췄을때 부피 초기화시키고 그때 가치가 최댓값인지 확인하고
 * 그러면 부피 크기 순으로 배치하고
 */

public class Solution {

	
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int s=1;s<=T;s++) {
        	StringTokenizer st=new StringTokenizer(br.readLine());
        	int n=Integer.parseInt(st.nextToken());
        	int k=Integer.parseInt(st.nextToken());
        	int[]v=new int[n+1];
        	int[]value=new int[n+1];
        	for(int i=1;i<n+1;i++) {
        		st=new StringTokenizer(br.readLine());
        		v[i]=Integer.parseInt(st.nextToken());
            	value[i]=Integer.parseInt(st.nextToken());
        	}
        	
        	int[][]dp=new int[n+1][k+1];
        	
        	for(int i=1;i<=n;i++) {
        		for(int j=1;j<=k;j++) {
        			if(j<v[i]) {
        				dp[i][j]=dp[i-1][j];
        			}else {
        				dp[i][j]=Math.max(dp[i-1][j-v[i]]+value[i], dp[i-1][j]);
        			}
        		}
        	}
        	System.out.println("#"+s+" "+dp[n][k]);
        	
        }

    }
}
