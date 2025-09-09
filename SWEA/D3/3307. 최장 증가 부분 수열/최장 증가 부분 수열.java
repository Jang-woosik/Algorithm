import java.io.*;
import java.util.*;

public class Solution {

	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int s=1;s<=T;s++) {
        	
        	int n=Integer.parseInt(br.readLine());
        	int[]map=new int[n];
        	StringTokenizer st=new StringTokenizer(br.readLine());
        	for(int i=0;i<n;i++) {
        		
        		map[i]=Integer.parseInt(st.nextToken());
        	}
        	int[]dp=new int[n];
        	Arrays.fill(dp, 1);
        	for(int i=1;i<n;i++) {
        		for(int j=0;j<i;j++) {
        			if(map[j]<=map[i]) {
        			dp[i]=Math.max(dp[i],dp[j]+1);
        			}
        		}
        	}
        	int max=0;
        	for(int len:dp) {
        		if(max<len) {
        			max=len;
        		}
        	}
        	System.out.println("#"+s+" "+max);
        }

    }
}
