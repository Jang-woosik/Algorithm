import java.io.*;
import java.util.*;

/*
 * 
 * 
 * 
 */

public class Main {

	static int[]dp,map;
	static int n;
	
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    n=Integer.parseInt(br.readLine());
	    map=new int[n+1];
	    dp=new int[n+1];
	    
	    for(int i=1;i<n+1;i++) {
	    	map[i]=Integer.parseInt(br.readLine());
	    }
	    
	    dp[1]=map[1];
	    if(n>1) {
	    	dp[2]=map[1]+map[2];
	    }
	    for(int i=3;i<=n;i++) {
	    	dp[i]=Math.max(dp[i-1], Math.max(dp[i-2]+map[i], dp[i-3]+map[i-1]+map[i]));
	    }
	    System.out.println(dp[n]);
	    
	}
	
}