import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int T = Integer.parseInt(br.readLine());
	    
	    

	    	
	    	int[]dp=new int[12];
	    	dp[0]=1;
	    	dp[1]=1;
	    	dp[2]=2;
	    	for(int i=3;i<=11;i++) {
	    		dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
	    		
	    	}
	    	for(int s=0;s<T;s++) {	
	    		int a=Integer.parseInt(br.readLine());
	    		System.out.println(dp[a]);
	    }
	    
	    
	    
	}
}